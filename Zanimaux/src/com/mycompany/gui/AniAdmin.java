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
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Animal;
import com.mycompagny.Service.ServiceAnimal;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author souad
 */
public class AniAdmin {
    
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
    SpanLabel lb;

    public void start() {
        f = new Form("Animaux", BoxLayout.y());

                     try {
            Command cm1 = new Command("");
            Image img1 = Image.createImage("/BACK2_26880 (2).png");
            cm1.setIcon(img1);
            f.getToolbar().addCommandToLeftBar(cm1);
            f.addCommandListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getCommand() == cm1) {
                          accueilAdminController mc = new accueilAdminController();
                                    mc.start();
                    }
                }
            });
        } catch (IOException ex) {

        }
        ServiceAnimal serviceAnimal = new ServiceAnimal();

        ArrayList<Animal> listanimal = serviceAnimal.getLisEvent1();
        Button add = new Button("Ajoutez Animal");
        
       /*  Button adoptionsBtn = new Button("Adoptions");

            adoptionsBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                    AffichageAdoption af = new AffichageAdoption();
                    af.start();

                }
            });*/
            
//                    Button fb = new Button("Partage FaceBook");
//                    fb.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent evt) {
//
//                         String accessToken = "EAACEdEose0cBACXQwCKFZA0lXZBhVxY8wPGL9rUvXTm0d1ZBFYXWt0bdH0LAHaKla5rz2xQnyvmgrZBO9ZBbNwsZAL61IZAWPZAuCol8KRi6spc0LKqoomodmVWvJAfaW73MXGw4xbj8ZA9xPhh9NT4fqpT8qHQh9QEPZBfZCaUnFgKj4ZAreLtE9IyhWGRwNo4ZCnbOpELYgH7SFCgZDZD";
////        FacebookClient fb=new DefaultFacebookClient(accessToken);
//        FacebookClient fbClient= new DefaultFacebookClient(accessToken);
//         FacebookType response = fbClient.publish("me/feed", FacebookType.class,Parameter.with("message", fb.getTitre()),Parameter.with("link", "http://www.google.com"));
//         System.out.println("fb.com/"+response.getId());
//         Dialog.show("Succes", "Votre post à été partagé sur facebook", "Fermer", null);
//                                      }
//                                  
//               
//            });

            


        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                AjoutAnimal am = new AjoutAnimal();
                am.start();

            }
        });
        for (Animal m : listanimal) {
            
             Label lb = new Label("");
            Image placeholder = Image.createImage(500, 170);
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            URLImage imgUrl = URLImage.createToStorage(encImage, "http://localhost/integration/symfony3/web/images/" + m.getNom_image(), "http://localhost/integration/symfony3/web/images/" + m.getNom_image());
            ImageViewer img1 = new ImageViewer(imgUrl);
            System.out.println(m.getNom_image());
            
      
           
            Container finishLandingPage = new Container(BoxLayout.x());
            Container c = new Container(BoxLayout.y());
            Container containervide = new Container(BoxLayout.x());
            Label spaceLabel0 = new Label(" ");
            Label spaceLabel2 = new Label(" ");
            containervide.add(spaceLabel0);
            containervide.add(spaceLabel2);

            int id = m.getId();

            Label l = new Label(m.getNom_a());
            l.getAllStyles().setFgColor(0xF69602);
            SpanLabel l2 = new SpanLabel(m.getRace());
            l2.getAllStyles().setFgColor(0x000000);

            SpanLabel l3;
            l3 = new SpanLabel(String.valueOf(m.getAge()));
            l3.getAllStyles().setFgColor(0x000000);

            SpanLabel l4 = new SpanLabel(String.valueOf((m.getPoids())));

            l4.getAllStyles().setFgColor(0x000000);
            //SpanLabel l5 = new SpanLabel(m.getPhone());
            
            
            
            
                    Button fb = new Button("Partage FaceBook");
                    fb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                         String accessToken = "EAACEdEose0cBAGm94lwhZC3WIk16PNqqteBbFb98QnGzUr1cy6lD94awRxfWFJZCLq3ZA4MIm8DTKuMgv44DRQf9HHUHRyjTVZAamMVEGojUUPDNbZA3TZAUWefkCnI6lW6XQTF1ZAR4gkeZAsheizB7sHZBLZAe3hQ4xZB1BpaLFra8mdjZBfQupIXfKUwzDZCnewN9fZACkmQe4T1wZDZD";
//        FacebookClient fb=new DefaultFacebookClient(accessToken);
        FacebookClient fbClient= new DefaultFacebookClient(accessToken);
         FacebookType response = fbClient.publish("me/feed", FacebookType.class,Parameter.with("message", m.getNom_a()),Parameter.with("link", "http://www.google.com"));
         System.out.println("fb.com/"+response.getId());
         Dialog.show("Succes", "Votre post à été partagé sur facebook", "Fermer", null);
                                      }
                                  
               
            });

           
            Button Delete = new Button("Supprimez");

            Delete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    serviceAnimal.suppAnimal(id);
                    Dialog.show("suppression", "Animal " + m.getNom_a()+ "a été Supprimé", "Ok", null);

                    start();

                }
            });

            Button Modifier = new Button("Modifiez");

            Modifier.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ModifierAnimal modifAnimal = new ModifierAnimal();
                    modifAnimal.start(m.getId(), m.getNom_a(), Integer.toString(m.getAge()), Double.toString(m.getPoids()), m.getRace());

                }
            });

             c.add(lb);
            c.add(img1);
                      f.add(c);
           
            c.add(l);
            c.add(l2);
        //    c.add(l3);
         //   c.add(l4);
         c.add(fb);
            c.add(Modifier);
            c.add(Delete);
            c.setWidth(500);
            c.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
            c.getUnselectedStyle().setBackgroundGradientEndColor(0xeae4e4);
            c.getUnselectedStyle().setBackgroundGradientStartColor(0xeae4e4);

            containervide.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
            containervide.getUnselectedStyle().setBackgroundGradientEndColor(0xFFFFFF);
            containervide.getUnselectedStyle().setBackgroundGradientStartColor(0xFFFFFF);

            f.add(containervide);
        }

      //  f.add(adoptionsBtn);
        f.add(add);
        f.show();
        /*   });*/

    }

    public void stop() {
        current = Display.getInstance().getCurrent();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }

    public void destroy() {
    }

}
