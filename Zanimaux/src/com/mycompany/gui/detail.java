/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceEvent;
import com.mycompany.Entite.Event;
import com.mycompany.Entite.Participants;
import java.io.IOException;
import java.util.ArrayList;
import static com.mycompany.Entite.User.connectedUser;
/**
 *
 * @author Said
 */
public class detail {

    private Form f;
    private Resources theme;
     private Container C1, C2;
     
    SpanLabel lb, lb1,lb2,lb3,lb4,lb5;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }

    public void start( int id ) {
         f = new Form( new BoxLayout(BoxLayout.Y_AXIS));
         
         
         try {
            Command cm1 = new Command("");
            Image img1 = Image.createImage("/BACK2_26880 (2).png");
            cm1.setIcon(img1);
            f.getToolbar().addCommandToLeftBar(cm1);
            f.addCommandListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getCommand() == cm1) {
                          events mc = new events();
                                    mc.start();
                    }
                }
            });
        } catch (IOException ex) {

        }
        
         

                    ServiceEvent serviceev = new ServiceEvent();
                    ArrayList<Event> lis = serviceev.getList2();
                    
                    Event li = new Event();
                 for (Event ev : lis) {
                       if (ev.getId() == id) {
                          li = ev;
                           }}
                    
                    
                    
                    
     
                        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        Container c1 = new Container(BoxLayout.x());
                        Container c2 = new Container(BoxLayout.x());
                        Container c3 = new Container(BoxLayout.x());
                        Container c4 = new Container(BoxLayout.x());
                        Container c5 = new Container(BoxLayout.x());
                        Container c6 = new Container(BoxLayout.x());

                        
                        ImageViewer imgv1 = new ImageViewer();
               
                       try {

                           Image img1 = Image.createImage("/petEvent11.jpg");
                          c.add(imgv1);
                          imgv1.setImage(img1);  
                        } catch (IOException ex) {    
                           }
        
        
                         Label l1= new Label("Titre : ");
                         l1.getAllStyles().setFgColor(0xA52A2A);               
                        lb = new SpanLabel(li.getTitre());
                       
                        
                        Label l2= new Label("Adresse : ");
                         l2.getAllStyles().setFgColor(0xA52A2A);    
                        lb1 = new SpanLabel(li.getAdresse());
                        
                        
                        Label l3= new Label("Date début : ");
                         l3.getAllStyles().setFgColor(0xA52A2A);    
                        lb2 = new SpanLabel(li.getDb());
                        
                        
                        Label l4= new Label("Date fin : ");
                         l4.getAllStyles().setFgColor(0xA52A2A);   
                        lb3 = new SpanLabel(li.getDf());
                        
                         Label l5= new Label("Type : ");
                         l5.getAllStyles().setFgColor(0xA52A2A);
                        lb4 = new SpanLabel(li.getType());
                        
                        Label l6= new Label("Détails : ");
                         l6.getAllStyles().setFgColor(0xA52A2A);
                         lb5 = new SpanLabel(li.getDetails());
//                        lb1.setText());
                       
                         Button detail = new Button("Participer");
                        c1.add(l1);
                        c1.add(lb);
                        c.add(c1);
                        
                        c2.add(l2);
                        c2.add(lb1);
                        c.add(c2);
                        
                        c3.add(l3);
                        c3.add(lb2);
                        c.add(c3);
                        
                        c4.add(l4);
                        c4.add(lb3);
                         c.add(c4);
                       
                        c5.add(l5); 
                        c5.add(lb4);
                         c.add(c5);
                        
                        c6.add(l6); 
                        c6.add(lb5);
                         c.add(c6);

                        c.add(detail);
                       f.add(c);
            
             
//              detail.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//                       
//                   
//                    
//                }
//            });

              int ide= li.getId(); 
        int nbp = li.getNombre_place();
        int nbr = li.getNombre_reserve();
         ServiceEvent serviceeve = new ServiceEvent();
                    ArrayList<Participants> listP = serviceeve.rechPart(connectedUser, ide);
                    int length=listP.size();
                        
        
   detail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                    if (nbr < nbp) {
                        
                        
                          if (length == 0){
                        serviceev.ajoutPar(connectedUser, ide);
                        Dialog.show("Participation avec succés !", "Have fun !", "Ok", null);
                       events evn = new events();
                        evn.start();}
                           else { Dialog.show("Erreur", "Vous etes inscrits deja", "OK", null);
             }

                    } else {
                        Dialog.show("Nombre de places !", "Nombre de place est bien limité por cet event ! au prochain evenement.", "Ok", null);

                    }            }
        });





       
             f.show();

    
    }
    public void stop() {
        f = Display.getInstance().getCurrent();
        if (f instanceof Dialog) {
            ((Dialog) f).dispose();
            f = Display.getInstance().getCurrent();
        }
    }

    public void destroy() {
    }

}
