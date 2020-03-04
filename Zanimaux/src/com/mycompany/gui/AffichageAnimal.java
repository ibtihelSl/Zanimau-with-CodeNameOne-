/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Adoption;
import com.mycompany.Entite.Animal;
import com.mycompagny.Service.AnimalService1;
import com.mycompagny.Service.ServiceAdoption;
import com.mycompagny.Service.ServiceAnimal;
import java.util.ArrayList;

/**
 *
 * @author souad
 */
public class AffichageAnimal {
    
           private Form current;
    private Resources theme;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }
    Form f;
        SpanLabel l;

        Label lb;
    public void start() {
     f = new Form("List Animaux",BoxLayout.y());
        
         ServiceAnimal Es=new ServiceAnimal();
        for (Animal a : Es.getLisEvent1()){
            lb = new Label("");
            Image placeholder = Image.createImage(500, 170);
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            URLImage imgUrl = URLImage.createToStorage(encImage, "http://localhost/ba3tour/web/images/" + a.getNom_image(), "http://localhost/ba3tour/web/images/" + a.getNom_image());
            ImageViewer img1 = new ImageViewer(imgUrl);
      
            System.out.println(a.getNom_image());
            
                lb.setText(a.getNom_a());
                                lb.setText(a.getNom_a());

            //    lb2.setText(Es.getListCabinet2().get(i).getSpecialite().toString());
            Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            System.out.println(a.getNom_image());
            
              int ide= a.getId(); 
                 AnimalService1 as=new AnimalService1();
int connectedUser=2;
               //     ArrayList<Adoption> lista = as.rechadop(connectedUser, ide);
                //    int length=lista.size();
     /*                   
        
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
        });*/


           
         Button adoptionsBtn = new Button("Adoptez");

            adoptionsBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    
                    
             //       if (length == 0){
                        as.ajoutadop(connectedUser, ide);
                        Dialog.show("Adopter avec succés !", "félicitation !", "Ok", null);
                        
                  /*     }
                           else { Dialog.show("Erreur", "deja adopté", "OK", null);}*/
                    
                   /* Message m =  new Message ( "  l'équipe Zanimaux vous souhaite le bienvenue parmis nous, et Vous annonce que vous avez adoptez un animal " );
//m . getAttachments () . put (textAttachmentUri, " text / plain " );
//m . getAttachments () . put (imageAttachmentUri, " image / png " );
Display.getInstance().sendMessage(new String[] {"souad.said@gmail.com"}, "PIDEV", m);

                     LocalNotification n = new LocalNotification();
        n.setId("demo-notification");
        n.setAlertBody("vous avez adoptez un animal :D");
        n.setAlertTitle("Break Time!");
        n.setAlertSound("/notification_sound_bell.mp3"); //file name must begin with notification_sound


        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        );*/
      
                 //   AffichageAdoption af = new AffichageAdoption();
                    //af.start(id);

                    
                }
                
                
                
                
            });


       
         
      
            
            c1.add(lb);
            c1.add(img1);
                      f.add(c1);
                      f.add(adoptionsBtn);
                   //   f.add(Modifier);
                    //  f.add(Delete);
                      
                     
        }
          
      //  f.add(add);
        f.show();
    
}}
