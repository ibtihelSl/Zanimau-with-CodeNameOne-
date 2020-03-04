/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.mycompany.Entities.Comment;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.codename1.io.JSONParser;
/**
 *
 * @author gaalo
 */
public class CrudComment {
     public void AjoutPro(Comment c) {
       ConnectionRequest con = new ConnectionRequest();
   String Url = "http://localhost/symfony3/web/app_dev.php/AjouterrComment?id="+c.getArticle_id()+"&message="+ c.getMessage();
   con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
         
    }
    
     public ArrayList<Comment> afficherEtab(String json)
    { 
    ArrayList<Comment> listEtudiants = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(etudiants);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            for (Map<String, Object> obj : list) {
               Comment e = new Comment();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setMessage(obj.get("message").toString());
                System.out.println(e);
                listEtudiants.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listEtudiants);
        return listEtudiants;
    }
     
     
            ArrayList<Comment> listTasks = new ArrayList<>();

       public ArrayList<Comment> getList2(int article_id) {
       ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfony3/web/app_dev.php/findComment?id="+article_id);  
 con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                CrudComment ser = new CrudComment();
                listTasks = ser.afficherEtab(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    public void ModifComment(Comment ma) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony3/web/app_dev.php/updateCommentMobile?id="+ma.getId()+"&message="+ ma.getMessage();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    public void suppComment(int id) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony3/web/app_dev.php/deleteCommentMobile?id="+ id;
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

}


