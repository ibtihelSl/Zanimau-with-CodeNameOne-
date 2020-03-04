/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

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
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entities.Veterinaires;
import com.mycompagny.Service.CrudVeterinaire;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author sana
 */
public class Affichage {

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
int article_id;
int id;
    public void start() {
                        f = new Form("Veterinaires",BoxLayout.y());
                  /*      lb = new SpanLabel("");
                      Container c =new Container(BoxLayout.y()); 

                   

     f.add(lb);*/
                     try {
            Command cm1 = new Command("");
            Image img1 = Image.createImage("/BACK2_26880 (2).png");
            cm1.setIcon(img1);
            f.getToolbar().addCommandToLeftBar(cm1);
            f.addCommandListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getCommand() == cm1) {
                          com.mycompany.gui.accueilConnectedController mc = new com.mycompany.gui.accueilConnectedController();
                                    mc.start();
                    }
                }
            });
             } catch (IOException ex) {

        }
                              CrudVeterinaire servicemagain=new CrudVeterinaire();
  
   //  lb.setText(servicemagain.getList2().toString());
     

                 ArrayList<Veterinaires> listMagasin = servicemagain.getList2();

                                for(Veterinaires m : listMagasin){
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


        
       int id=m.getId();
    
        Label l = new Label(m.getNom());
        l.getAllStyles().setFgColor(0xF69602);
        
        SpanLabel l2 = new SpanLabel(m.getAddress());
         l2.getAllStyles().setFgColor(0x000000);

        SpanLabel l3 = new SpanLabel( m.getVille());
      l3.getAllStyles().setFgColor(0x000000);

        SpanLabel l4 = new SpanLabel(  m.getPhone());
        
        l4.getAllStyles().setFgColor(0x000000)
                ;
      SpanLabel l5 = new SpanLabel(m.getEmail());
              l5.getAllStyles().setFgColor(0x000000);

         Button accessoireButton = new Button("Articles");

        accessoireButton.addActionListener(new ActionListener() {
             @Override
           public void actionPerformed(ActionEvent evt) {
            
           AffichageArticle af = new AffichageArticle();
       af.start(article_id);

           
        }});
        Button Assur = new Button("List des Assurances");

        Assur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AfficherAssurance modifmag=new   AfficherAssurance();
            modifmag.start(id);

           
        
           
        }});
        c.add(l);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(accessoireButton);
                c.add(Assur);

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

        
          //f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          f.show();
       /*   });*/

    }

    public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public void destroy() {
    }
    }
    


