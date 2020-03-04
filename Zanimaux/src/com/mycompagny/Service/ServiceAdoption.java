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
import com.mycompany.Entite.Adoption;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souad
 */
public class ServiceAdoption {
//    
////        public void ajoutAdoption(Adoption ta) {
////        ConnectionRequest con = new ConnectionRequest();
////        String Url = "http://localhost/ba3tour/web/app_dev.php/allAdoption" + ta.getEspece()+ "/" + ta.getFk_post()+ "/" + ta.getNomprop();
////        con.setUrl(Url);
////
////        //System.out.println("tt");
////
////        con.addResponseListener((e) -> {
////            String str = new String(con.getResponseData());
////            System.out.println(str);
////
////        });
////        NetworkManager.getInstance().addToQueueAndWait(con);
////    }
//
//    public ArrayList<Adoption> getListAnimal(String json) {
//
//        ArrayList<Adoption> listAdoptions = new ArrayList<>();
//
//        try {
//            System.out.println(json);
//            JSONParser j = new JSONParser();
//
//            Map<String, Object> adoptions = j.parseJSON(new CharArrayReader(json.toCharArray()));
//            System.out.println(adoptions);
//           
//            List<Map<String, Object>> list = (List<Map<String, Object>>) adoptions.get("root");
//
//            for (Map<String, Object> obj : list) {
//                Adoption a = new Adoption();
//
//                // System.out.println(obj.get("id"));
//                float id = Float.parseFloat(obj.get("id").toString());
//                System.out.println(id);
//                a.setId((int) id);
//                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
//                a.setEspece(obj.get("espece").toString());
//                a.setNomprop(obj.get("nomprop").toString());
//
//                System.out.println(a);
//                listAdoptions.add(a);
//
//            }
//
//        } catch (IOException ex) {
//        }
//        System.out.println(listAdoptions);
//        return listAdoptions;
//
//    }
//    
//    
//    ArrayList<Adoption> listAdop = new ArrayList<>();
//    
//    public ArrayList<Adoption> getList2(){       
//        ConnectionRequest con = new ConnectionRequest();
//        con.setUrl("http://localhost/ba3tour/web/app_dev.php/allAdoption");  
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                ServiceAdop ser = new ServiceAdop();
//                listAdop = ser.getListAdoption(new String(con.getResponseData()));
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//        return listAdop;
//    }

    
    
      public void ajoutAdoption(Adoption ma) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/integration/symfony3/web/app_dev.php/adoptionMobile/new?nomprop="+ma.getNomprop()+"&espece="+ma.getEspece();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      
      
//      public void Modifmagasin(Adoption ma) {
//        ConnectionRequest con = new ConnectionRequest();
//        String Url = "http://localhost//touha/symfony3/web/app_dev.php/updatemagasinMobile?id="+ma.getId()+"&nom="+ ma.getNom() +"&addresse="+ ma.getAddresse()+"&ville=" + ma.getVille()+"&phone=" + ma.getPhone();
//        con.setUrl(Url);
//
//        //System.out.println("tt");
//
//        con.addResponseListener((e) -> {
//            String str = new String(con.getResponseData());
//            System.out.println(str);
//
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//    }
//      
//      public void suppAdoption(int id) {
//        ConnectionRequest con = new ConnectionRequest();
//        String Url = "http://localhost/touha/symfony3/web/app_dev.php/deletemagasinMobile?id="+ id;
//        con.setUrl(Url);
//
//        //System.out.println("tt");
//
//        con.addResponseListener((e) -> {
//            String str = new String(con.getResponseData());
//            System.out.println(str);
//
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//    }

    
    
     public ArrayList<Adoption> getListAdoption(String json) {

        ArrayList<Adoption> listAdoption = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> adoption = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(adoption);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) adoption.get("root");

            for (Map<String, Object> obj : list) {
                Adoption e = new Adoption();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setEspece(obj.get("espece").toString());
                e.setNomprop(obj.get("nomprop").toString());
//                e.setVille(obj.get("ville").toString());
//                e.setPhone(obj.get("phone").toString());

                System.out.println(e);
                listAdoption.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listAdoption);
        return listAdoption;

    }
    
    
     ArrayList<Adoption> listAdoption = new ArrayList<>();
    
    public ArrayList<Adoption> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/integration/symfony3/web/app_dev.php/allAdoptionMobile");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAdoption ser = new ServiceAdoption();
                listAdoption = ser.getListAdoption(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAdoption;
    }
        public ArrayList<Adoption> getListById(int id){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/integration/symfony3/web/app_dev.php/findAccessoires?id="+ id );  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAdoption ser = new ServiceAdoption();
                listAdoption = ser.getListAdoption(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAdoption;
    }

    public void supAdoption(int id) {
ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/integration/symfony3/web/app_dev.php/deleteAdop?id="+ id;
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        }
    
  
    
}
