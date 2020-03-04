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
import com.mycompany.Entite.Magasin;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Touha
 */
public class ServiceMagasin {
    
      public void ajoutmagasin(Magasin ma) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost//touha/symfony3/web/app_dev.php/addmagmobile?nom="+ ma.getNom() +"&addresse="+ ma.getAddresse()+"&ville=" + ma.getVille()+"&phone=" + ma.getPhone();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      
      
      public void Modifmagasin(Magasin ma) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost//touha/symfony3/web/app_dev.php/updatemagasinMobile?id="+ma.getId()+"&nom="+ ma.getNom() +"&addresse="+ ma.getAddresse()+"&ville=" + ma.getVille()+"&phone=" + ma.getPhone();
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      
      public void suppmagasin(int id) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/touha/symfony3/web/app_dev.php/deletemagasinMobile?id="+ id;
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    
    
     public ArrayList<Magasin> getListMagasin(String json) {

        ArrayList<Magasin> listMagasin = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> magasin = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(magasin);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) magasin.get("root");

            for (Map<String, Object> obj : list) {
                Magasin e = new Magasin();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setNom(obj.get("nom").toString());
                e.setAddresse(obj.get("address").toString());
                e.setVille(obj.get("ville").toString());
                e.setPhone(obj.get("phone").toString());

                System.out.println(e);
                listMagasin.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listMagasin);
        return listMagasin;

    }
    
    
     ArrayList<Magasin> listMagasin = new ArrayList<>();
    
    public ArrayList<Magasin> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/touha/symfony3/web/app_dev.php/allMagasins");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceMagasin ser = new ServiceMagasin();
                listMagasin = ser.getListMagasin(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listMagasin;
    }
    
}
