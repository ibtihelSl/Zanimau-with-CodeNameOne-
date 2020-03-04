/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Animal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souad
 */
public class ServiceAnimal {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
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
      
      
      public void ModifAnimal(Animal ma) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/integration/symfony3/web/app_dev.php/animalupdate?id="+ma.getId()+"&nom_a="+ma.getNom_a()+"&age="+ma.getAge()+"&poids="+ma.getPoids()+"&race="+ma.getRace();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      
      public void suppAnimal(int id) {
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

     
    
   
}


