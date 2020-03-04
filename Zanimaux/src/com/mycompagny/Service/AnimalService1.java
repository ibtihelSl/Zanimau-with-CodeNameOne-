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
import com.mycompany.Entite.Adoption;
import com.mycompany.Entite.Animal;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souad
 */
public class AnimalService1 {
   
     public void ajoutaccessoires(Animal a) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/integration/symfony3/web/app_dev.php/animal/new"+"?nomImage="+a.getNom_image()+"&nom_a="+a.getNom_a()+"&age="+a.getAge()+"&poids="+a.getPoids()+"&race="+a.getRace();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
        public void Modifaccessoire(Animal ma) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/integration/symfony3/web/app_dev.php/animalupdate?id="+ma.getId()+"nom_image="+ma.getNom_image()+"&nom_a="+ma.getNom_a()+"&age="+ma.getAge()+"&poids="+ma.getPoids()+"&race="+ma.getRace();
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
        String Url = "http://localhost/integration/symfony3/web/app_dev.php/deleteAni?id="+ id;
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    
       public ArrayList<Animal> getListEvent(String json) {

        ArrayList<Animal> an = new ArrayList<>();

        try {
           
            JSONParser j = new JSONParser();

            Map<String, Object> animalMap = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) animalMap.get("root");

            for (Map<String, Object> obj : list) {
                Animal a = new Animal();

               
                float id = Float.parseFloat(obj.get("id").toString());
                                float age = Float.parseFloat(obj.get("age").toString());

                a.setId((int) id);
                                a.setAge((int) age);

                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                a.setNom_a(obj.get("nomA").toString());
                a.setRace(obj.get("race").toString());
                a.setNom_image(obj.get("nomImage").toString());
              //  e.setSpecialite(obj.get("specialite").toString());
              
             // a.setAge(Float.parseFloat(obj.get("age").toString()));
              a.setPoids(Double.parseDouble(obj.get("poids").toString()));
              
                an.add(a);

            }

        } catch (IOException ex) {
        }
      
        return an;

    }
    
    
    ArrayList<Animal> listAnimaux = new ArrayList<>();
    
    public ArrayList<Animal> getLisEvent1(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/integration/symfony3/web/app_dev.php/allAnimaux");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAnimal ser = new ServiceAnimal();
                listAnimaux = ser.getListEvent(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAnimaux;
    }

    
     public void ajoutAnimal(Animal ma) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/integration/symfony3/web/app_dev.php/animal/new?nom_a="+ma.getNom_a()+"&age="+ma.getAge()+"&poids="+ma.getPoids()+"&race="+ma.getRace();
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
 
 
   public void ajoutadop(int idu, int ide) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/integration/symfony3/web/app_dev.php/addadopterMobile/" + idu + "/" + ide;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

 


 /* public ArrayList<Adoption> rechadop(int idu, int ide) {
        ArrayList<Adoption> listadop = new ArrayList<>();

        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ba3tour/web/app_dev.php/findadop/" + idu + "/" + ide;
        con.setUrl(Url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> partic = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) partic.get("root");
                    for (Map<String, Object> obj : list) {
                        Adoption ev = new Adoption();
                        float id = Float.parseFloat(obj.get("id").toString());
                        ev.setId((int) id);
                        ev.setUser_id((int)  obj.get("user"));
                        ev.setFk_post((int)  obj.get("animaux"));
                        System.out.println(ev);
                        listadop.add(ev);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listadop;

    }
 */
 

   }