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
import com.mycompany.Entite.Animal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souad
 */
public class ServiceAdop {
   
     public ArrayList<Adoption> getListAdoption(String json) {

        ArrayList<Adoption> an = new ArrayList<>();

        try {
           
            JSONParser j = new JSONParser();

            Map<String, Object> adoptionMap = j.parseJSON(new CharArrayReader(json.toCharArray()));
           
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) adoptionMap.get("root");

            for (Map<String, Object> obj : list) {
                Adoption a = new Adoption();

               

                 float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                a.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                a.setEspece(obj.get("espece").toString());
                a.setNomprop(obj.get("nomprop").toString());

                System.out.println(a);
                an.add(a);


            }

        } catch (IOException ex) {
        }
      
        return an;

    }
    
    
    ArrayList<Adoption> listAdoption = new ArrayList<>();
    
    public ArrayList<Adoption> getLisEvent1(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/integration/symfony3/web/app_dev.php/allAdoptionMobile");  
       con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAdop ser = new ServiceAdop();
                listAdoption = ser.getListAdoption(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAdoption;
    }

    
}
