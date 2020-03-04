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
import com.mycompany.Entite.Accessoires;
import com.mycompany.Entite.Magasin;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Touha
 */
public class ServiceAccessoires {
    
    
    
     public void ajoutaccessoires(Accessoires a) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost//touha/symfony3/web/app_dev.php/addaccmobile?id="+a.getId_magasin()+"&nom="+ a.getNom() +"&prix="+ a.getPrix()+"&espece=" + a.getEspece()+"&image_name="+a.getImage();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
        public void Modifaccessoire(Accessoires a) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost//touha/symfony3/web/app_dev.php/updateacccMobile?id="+a.getId()+"&nom="+ a.getNom() +"&prix="+ a.getPrix()+"&espece=" + a.getEspece()+"&image_name="+a.getImage();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        
          public void suppacc(int id) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/touha/symfony3/web/app_dev.php/deleteaccMobile?id="+ id;
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    
     public ArrayList<Accessoires> getListAccessoires(String json,int idmag) {

        ArrayList<Accessoires> listAccessoires = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> accessoires = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(accessoires);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) accessoires.get("root");

            for (Map<String, Object> obj : list) {
                Accessoires e = new Accessoires();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setNom(obj.get("nom").toString());
                e.setPrix(Float.parseFloat(obj.get("prix").toString()));
                e.setEspece(obj.get("espece").toString());
                e.setImage(obj.get("imageName").toString());
               e.setId_magasin(idmag);

                System.out.println(e);
                listAccessoires.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listAccessoires);
        return listAccessoires;

    }
    
    
     ArrayList<Accessoires> listaccessoires = new ArrayList<>();
    
      public ArrayList<Accessoires> getList2(int idmag){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/touha/symfony3/web/app_dev.php/findAccessoires?id="+ idmag );  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAccessoires ser = new ServiceAccessoires();
                listaccessoires = ser.getListAccessoires(new String(con.getResponseData()),idmag);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listaccessoires;
    }
      
      public void setImage(String filePath, ImageViewer iv) {
           try {
               Image i1 = Image.createImage(filePath).scaled(400,400);
               iv.setImage(i1);
               if (i1 != null) {
                  
                   ImageIO imgIO = ImageIO.getImageIO();
                   ByteArrayOutputStream out = new ByteArrayOutputStream();
                   imgIO.save(i1, out, File.separator, 1);
                 
                   byte[] ba = out.toByteArray();
                   
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
                   request.addArgument("Image", Imagecode);
                   request.setUrl("http://localhost/Upload.php");
                   NetworkManager.getInstance().addToQueueAndWait(request);
               } else {
                   System.out.println("Unable to upload");
               }
               iv.getParent().revalidate();

           } catch (Exception ex) {
            
           }
    }
        
 public void browseImage(ImageViewer im){
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
        

 }
    
}
