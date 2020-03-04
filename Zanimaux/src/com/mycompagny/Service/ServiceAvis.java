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
import com.mycompany.Entite.Accessoires;
import com.mycompany.Entite.Avis;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Touha
 */
public class ServiceAvis {
    
       public void ajoutavis(Avis a) {
           ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost//touha/symfony3/web/app_dev.php/addavismobile?id="+ a.getId_magasin()+"&commentaire="+ a.getCommentaire()+"&rating=" + a.getRating();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
           NetworkManager.getInstance().addToQueueAndWait(con);
    }
       
       
        public void suppavis(int id) {
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
      
    
    public ArrayList<Avis> getListAvis(String json,int idmag) {

        ArrayList<Avis> listAvis = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> avis = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(avis);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) avis.get("root");

            for (Map<String, Object> obj : list) {
                Avis e = new Avis();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setCommentaire(obj.get("commentaire").toString());
                e.setRating((int)Double.parseDouble(obj.get("rating").toString()));
//                e.setUser_name(obj.get("user_name").toString());
               
               e.setId_magasin(idmag);

                System.out.println(e);
                listAvis.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listAvis);
        return listAvis;

    }
    
    
     ArrayList<Avis> listavis = new ArrayList<>();
    
      public ArrayList<Avis> getList2(int idmag){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/touha/symfony3/web/app_dev.php/findAvisMobile?id="+ idmag );  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAvis ser = new ServiceAvis();
                listavis = ser.getListAvis(new String(con.getResponseData()),idmag);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listavis;
    }    
        
        
        
}
