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
import com.mycompany.Entities.Article;
import com.mycompagny.Service.CrudArticle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ci
 */
public class CrudArticle {
    
     public void AjoutPro(Article c) {
       ConnectionRequest con = new ConnectionRequest();
   String Url = "http://localhost/symfony3/web/app_dev.php/AjouterrArticle?Titre="+ c.getTitre()+ "&Details=" +c.getDetails();
   con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
         
    }
    
 public ArrayList<Article> getListArticle(String json) {


        ArrayList<Article> listAccessoires = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> accessoires = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(accessoires);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) accessoires.get("root");

            for (Map<String, Object> obj : list) {
              Article e = new Article();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setTitre(obj.get("titre").toString());
                e.setDetails(obj.get("details").toString());
               // e.setImage(obj.get("image_name").toString());
               // e.setId_magasin(Integer.parseInt(obj.get("id_magasin").toString()));

          
                listAccessoires.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listAccessoires);
        return listAccessoires;

    }
    
    
      ArrayList<Article> listTasks = new ArrayList<>();

       public ArrayList<Article> getList2() {
       ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfony3/web/app_dev.php/AllArticle");  
 con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                CrudArticle ser = new CrudArticle();
                listTasks = ser.getListArticle(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
      
    public void ModifArticle(Article ma) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony3/web/app_dev.php/updateArticletMobile?id="+ma.getId()+"&Titre="+ma.getTitre()+ "&Details="+ ma.getDetails();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    public void suppArticle(int id) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony3/web/app_dev.php/deleteArticleMobile?id="+ id;
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
}


