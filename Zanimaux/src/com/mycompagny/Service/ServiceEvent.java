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
import com.mycompany.Entite.Event;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mycompany.Entite.Participants;

/**
 *
 * @author sana
 */
public class ServiceEvent {

    public ArrayList<Event> getList2() {
        ArrayList<Event> listEvts= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/integration/symfony3/web/app_dev.php/Events/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Event ev = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                        ev.setId((int) id);
                        ev.setTitre(obj.get("titre").toString());
                        ev.setAdresse(obj.get("adresse").toString());
                        ev.setNombre_place((int)(double)obj.get("nombrePlace"));
                        ev.setNombre_reserve((int)(double)obj.get("nombreReserve"));
                        ev.setDb(obj.get("db").toString());
                        ev.setDf(obj.get("df").toString());
                        ev.setDetails(obj.get("details").toString());
                        ev.setType(obj.get("type").toString());
                        
                        listEvts.add(ev);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvts;
    }
    
     public void ajoutPar(int idu, int ide) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/integration/symfony3/web/app_dev.php/partic/" + idu + "/" + ide;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

     
     public ArrayList<Participants> getListPar() {
        ArrayList<Participants> listEvts= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/integration/symfony3/web/app_dev.php/allParticipant");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    for (Map<String, Object> obj : list) {
                        Participants ev = new Participants();
                        float id = Float.parseFloat(obj.get("id").toString());
                        ev.setId((int) id);
                        ev.setTitre(obj.get("titre").toString());
                        ev.setParticipant(obj.get("participant").toString());
                        
                        listEvts.add(ev);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvts;
    }
     
      public ArrayList<Participants> rechPart(int idu, int ide) {
        ArrayList<Participants> listEvts = new ArrayList<>();

        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/integration/symfony3/web/app_dev.php/findpartic/" + idu + "/" + ide;
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
                        Participants ev = new Participants();
                        float id = Float.parseFloat(obj.get("id").toString());
                        ev.setId((int) id);
                        ev.setIdu((int) (double) obj.get("idu"));
                        ev.setIde((int) (double) obj.get("ide"));
                        System.out.println(ev);
                        listEvts.add(ev);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvts;

    }
    

}

