/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompagny.Service;

import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.File;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.ImageIO;
import com.codename1.util.Base64;
import com.mycompany.Entities.Veterinaires;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ci
 */
public class CrudVeterinaire {
    
    public void ajoutvet(Veterinaires v) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony3/web/app_dev.php/AjouterrVet?nom="+ v.getNom()+"&address="+v.getAddress()+"&ville="+ v.getVille()+"&phone="+v.getPhone()+"&email="+ v.getEmail() ;
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

  public ArrayList<Veterinaires> getListVeterinaires(String json) {

        ArrayList<Veterinaires> an = new ArrayList<>();

        try {
           
            JSONParser j = new JSONParser();

            Map<String, Object> animalMap = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) animalMap.get("root");

            for (Map<String, Object> obj : list) {
                Veterinaires e = new Veterinaires();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setNom(obj.get("nom").toString());
                e.setAddress(obj.get("address").toString());
                e.setVille(obj.get("ville").toString());
                e.setPhone(obj.get("phone").toString());
                e.setEmail(obj.get("phone").toString());
              
                an.add(e);

            }

        } catch (IOException ex) {
        }
      
        return an;

    }
    
    
    ArrayList<Veterinaires> listVet = new ArrayList<>();
    public ArrayList<Veterinaires> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfony3/web/app_dev.php/AllVeterinaire");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                CrudVeterinaire ser = new CrudVeterinaire();
                listVet = ser.getListVeterinaires(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listVet;
    }
    
     public void ModifVet(Veterinaires v) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony3/web/app_dev.php/updateVetMobile?id="+v.getId()+"&nom="+v.getNom()+"&address=" +v.getAddress()+ "&ville=" + v.getVille()+ "&phone=" +v.getPhone()+ "&email=" + v.getEmail();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    public void suppVet(int id) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony3/web/app_dev.php/deleteVetMobile?id="+ id;
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

             public void setImage(String filePath, ImageViewer iv) {
           try {
               //creation d'image apartir du filepath
               Image i1 = Image.createImage(filePath).scaled(400,400);
               iv.setImage(i1);
               if (i1 != null) {
                   //FileSystemStorage  
                   //trodek tnajm testoki l image en binaire
                   ImageIO imgIO = ImageIO.getImageIO();
                   //stocker l'inage dans le flux
                   ByteArrayOutputStream out = new ByteArrayOutputStream();
                   imgIO.save(i1, out, File.separator, 1);
                   //recuperer l image du flux dans un tab binaire
                   byte[] ba = out.toByteArray();
                   //cryptage de l image binaire
                   String Imagecode = Base64.encode(ba);
                   ConnectionRequest request = new ConnectionRequest();
                   request.addResponseListener((NetworkEvent evt) -> {
                       byte[] data = (byte[]) evt.getMetaData();
                       String imageName = new String(data);
                       System.out.println("metadata "+imageName);
                       iv.getImage().setImageName(imageName);
                   });
                   request.setPost(true);
                   request.setHttpMethod("POST");
                  // imagecode sequence binaire de l image coder
                   request.addArgument("Image", Imagecode);
                   request.setUrl("http://localhost:80/Upload.php");
                   NetworkManager.getInstance().addToQueueAndWait(request);
               } else {
                   System.out.println("Unable to upload");
               }
               iv.getParent().revalidate();

           } catch (Exception ex) {
            
           }
       
    }
        
 public void browseImage(ImageViewer im){
     //open gallery
     Display.getInstance().openGallery((ActionListener) (ActionEvent ev) -> {
         
         if (ev != null && ev.getSource() != null) {
             String filePath = (String) ev.getSource();
                // retenue de nom d'image
//             int fileNameIndex = filePath.lastIndexOf("/") + 1;
//             String fileName = filePath.substring(fileNameIndex);
             // Do something
             
             setImage(filePath,im);
         }
     }, Display.GALLERY_IMAGE);
    
    
 }}

