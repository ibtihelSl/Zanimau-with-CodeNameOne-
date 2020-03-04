/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
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
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Adoption;
import com.mycompany.Entite.Animal;
import com.mycompagny.Service.ServiceAdop;
import com.mycompagny.Service.ServiceAdoption;
import com.mycompagny.Service.ServiceAnimal;
import java.util.ArrayList;

/**
 *
 * @author souad
 */
public class AffichageAdop {

//        Form f;
//
//    
//    Label lb;
//  
//    public void AffichageAdop() {
//        
//        f = new Form("List d'aAdoption",BoxLayout.y());
//        
//         ServiceAdop Es=new ServiceAdop();
//        for (Adoption a : Es.getLisEvent1()){
//            lb = new Label("");
//            Image placeholder = Image.createImage(500, 170);
//            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
//      
//            
//                lb.setText(a.getNom_a());
//            //    lb2.setText(Es.getListCabinet2().get(i).getSpecialite().toString());
//            Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
//            System.out.println(a.getNom_image());
//            
//            c1.add(lb);
//            c1.add(img1);
//                      f.add(c1);
//                      
//                     
//        }
//        f.show();
//    
//}
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
        f = new Form("Adoption", BoxLayout.y());
        /*      lb = new SpanLabel("");
                      Container c =new Container(BoxLayout.y()); 

                   

     f.add(lb);*/
        ServiceAdoption serviceAdoption = new ServiceAdoption();

        //  lb.setText(servicemagain.getList2().toString());
        ArrayList<Adoption> listAdoption = serviceAdoption.getList2();

        for (Adoption m : listAdoption) {
            Container finishLandingPage = new Container(BoxLayout.x());
            Container c = new Container(BoxLayout.y());
            Container containervide = new Container(BoxLayout.x());
            Label spaceLabel0 = new Label(" ");
            Label spaceLabel2 = new Label(" ");
            containervide.add(spaceLabel0);
            containervide.add(spaceLabel2);

            /* try {
            enc = EncodedImage.create("/giphy.gif");
        } catch (IOException ex) {
            System.out.println("error encoder");
        }*/
            int id = m.getId();

            SpanLabel l2 = new SpanLabel(m.getEspece());
            l2.getAllStyles().setFgColor(0xF69602);

            Label l = new Label(m.getNomprop());
            l.getAllStyles().setFgColor(0xF69602);
            
            Button adoptionBtn = new Button("Ajouter");

            adoptionBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {

//           AfficheAccessoires af = new AfficheAccessoires();
//       af.start(id);
                }
            });
////          Button maps = new Button("affiche dans map");
////
////        maps.addActionListener(new ActionListener() {
////            public void actionPerformed(ActionEvent evt) {
////            
////           mapmagasin mm = new mapmagasin();
////       mm.lister(m.getAddresse(),m.getNom());
////
////           
////        }});
////                /* Button map = new Button("map");
//                 map.addActionListener(new ActionListener() {
//
//                                        @Override
//                                        public void actionPerformed(ActionEvent evt) {
//map m = new map();
//m.lister();
//                                        }
//                                    });*/

            c.add(l);
            c.add(l2);
            // c.add(l3);
            // c.add(l4);
            c.add(adoptionBtn);
            // c.add(maps);
            //  c.add(map);
            c.setWidth(500);
            c.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
            c.getUnselectedStyle().setBackgroundGradientEndColor(0xeae4e4);
            c.getUnselectedStyle().setBackgroundGradientStartColor(0xeae4e4);

            containervide.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
            containervide.getUnselectedStyle().setBackgroundGradientEndColor(0xFFFFFF);
            containervide.getUnselectedStyle().setBackgroundGradientStartColor(0xFFFFFF);
            /* finishLandingPage.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        finishLandingPage.getUnselectedStyle().setBackgroundGradientEndColor(0xFFFFFF);
        finishLandingPage.getUnselectedStyle().setBackgroundGradientStartColor(0xFFFFFF);*/
            // c.add(containervide);
            //  finishLandingPage.add(c);
            // finishLandingPage.add(containervide);
            //    c.setPreferredW(400);
            //  f.add(FlowLayout.encloseIn(finishLandingPage));
            //   f.add(containervide);
            /*     Container c =new Container(BoxLayout.x()); 

                                   // f.add("Nom :");
                                   // f.add(m.getNom());
                                  String nom=m.getNom().toString();
                                  String address=m.getAddresse().toString();
                                  String ville=m.getVille().toString();
                                  String phone = m.getPhone().toString();
                                   Label l1= new Label(nom);
                                   Label l2= new Label(address);
                                   Label l3= new Label(ville);
                                   Label l4= new Label(phone);
                                   c.add(l1);
                                   c.add(l2);
                                   c.add(l3);
                                   c.add(l4);*/
            f.add(c);
            f.add(containervide);
        }

//        f.getToolbar().addCommandToRightBar("Map", null, new ActionListener() {
//
//                      @Override
//                      public void actionPerformed(ActionEvent evt) {
//                      map map = new map();
//                      map.lister();
//                      }
//                  });
//          //f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
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
