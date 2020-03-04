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
import com.mycompany.Entities.Assurance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ci
 */
public class CrudAssurance {
   public void ajoutAssurance(Assurance v) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony3/web/app_dev.php/AjouterrAsuurance?nom="+ v.getNom()+"&adresse=" +v.getAdresse()+"&mail=" + v.getMail()+"&description=" +v.getDescription()+"&prixparanimaux=" + v.getPrixparanimaux();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

   public ArrayList<Assurance> getListAssur(String json) {


        ArrayList<Assurance> an = new ArrayList<>();

        try {
           
            JSONParser j = new JSONParser();

            Map<String, Object> animalMap = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) animalMap.get("root");

            for (Map<String, Object> obj : list) {
                Assurance e = new Assurance();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
//                e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setNom(obj.get("nom").toString());
                e.setAdresse(obj.get("adresse").toString());
                e.setMail(obj.get("mail").toString());
                e.setDescription(obj.get("description").toString());
//                e.setAge_de_ce_animal(Integer.valueOf((obj.get("age_de_ce_animal").toString())));
//                e.setType_de_ce_animal(obj.get("type_de_ce_animal").toString());
                                e.setPrixparanimaux(Double.valueOf(obj.get("prixparanimaux").toString()));
                          // e.setTotalprix(Double.valueOf(obj.get("totalprix").toString()));



                an.add(e);

            }

        } catch (IOException ex) {
        }
      
        return an;

    }
    
    
   
    
  public ArrayList<Assurance> getListAssurance(String json) {

        ArrayList<Assurance> an = new ArrayList<>();

        try {
           
            JSONParser j = new JSONParser();

            Map<String, Object> animalMap = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) animalMap.get("root");

            for (Map<String, Object> obj : list) {
                Assurance e = new Assurance();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setNom(obj.get("nom").toString());
                e.setAdresse(obj.get("adresse").toString());
                e.setMail(obj.get("mail").toString());
                e.setDescription(obj.get("description").toString());
//                e.setAge_de_ce_animal(Integer.valueOf((obj.get("age_de_ce_animal").toString())));
//                e.setType_de_ce_animal(obj.get("type_de_ce_animal").toString());
                                e.setPrixparanimaux(Double.valueOf(obj.get("prixparanimaux").toString()));
                         //  e.setTotalprix(Double.valueOf(obj.get("totalprix").toString()));



                an.add(e);

            }

        } catch (IOException ex) {
        }
      
        return an;

    }
    
    
    ArrayList<Assurance> listVet = new ArrayList<>();
    
    public ArrayList<Assurance> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfony3/web/app_dev.php/AllAssurance");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                CrudAssurance ser = new CrudAssurance();
                listVet = ser.getListAssur(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listVet;
    }
    
     public void ModifAssurance(Assurance v) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony3/web/app_dev.php/updateAssuranceMobile?id="+v.getId()+"&nom="+ v.getNom()+"&adresse=" +v.getAdresse()+"&mail=" + v.getMail()+"&description=" +v.getDescription()+"&prixparanimaux=" + v.getPrixparanimaux();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    public void suppAssurance(int id) {
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony3/web/app_dev.php/deleteAssuranceMobile?id="+ id;
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    
    
    
    
Assurance listAssurancedd = new Assurance();

     public Assurance CalculerAssurance(int id,Double d) {
         
                

        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony3/web/app_dev.php/calcul?id="+id+"&nbanimaux="+d;
       con.setUrl(Url);

        
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
                public void actionPerformed(NetworkEvent evt) {
                CrudAssurance ser = new CrudAssurance();
                listVet = ser.getListAssur(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAssurancedd;
        
      
     
     }
}
