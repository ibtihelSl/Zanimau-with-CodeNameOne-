/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Command;
import com.codename1.ui.Container;

import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import java.io.IOException;
import javafx.geometry.Pos;
import com.codename1.messaging.Message;


/**
 *
 * @author Said
 */
public class accueilConnectedController {

    private Form f;
    private Resources theme;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }

    public void start() {
       f = new Form("Zanimaux");

        Command cm1 = new Command("Accueil");
        Command cm2 = new Command("Evenements");
        Command cm3 = new Command("Associations");
        Command cm4 = new Command("Magasin");
        Command cm7 = new Command("Animaux");
        Command cm8 = new Command("Veterinaire");
        Command cm5 = new Command("Contact Us");
        Command cm6 = new Command("Logout");
        
        f.getToolbar().addCommandToSideMenu(cm1);
        f.getToolbar().addCommandToSideMenu(cm2);
        f.getToolbar().addCommandToSideMenu(cm3);
        f.getToolbar().addCommandToSideMenu(cm4);
        f.getToolbar().addCommandToSideMenu(cm7);
        f.getToolbar().addCommandToSideMenu(cm8);
        f.getToolbar().addCommandToSideMenu(cm5);
        f.getToolbar().addCommandToRightBar(cm6);
        
        f.addCommandListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getCommand() == cm2) {
                    events affc = new events();
                    affc.start();

                }
            }
             });
        f.addCommandListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getCommand() == cm7) {
                    AffichageAni affc = new AffichageAni();
                    affc.AffichageAnimaux();

                }
            }
             });
         f.addCommandListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getCommand() == cm8) {
                    com.mycompany.GUI.Affichage  affc = new com.mycompany.GUI.Affichage();
                    affc.start();

                }
            }
             });
         f.addCommandListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getCommand() == cm6) {
                               accueilController affc = new accueilController();
                               affc.start();
                            }
                        }
                    });
         
          f.addCommandListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getCommand() == cm4) {
                               AfficheMagasin affc = new AfficheMagasin();
                               affc.start();
                            }
                        }
                    });
        
        f.addCommandListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getCommand() == cm3) {
                    association affca = new association();
                    affca.start();

                }
            }
             });
        
           f.addCommandListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                if (evt.getCommand() == cm5) {
            Message m = new Message("Body of message");


         Display.getInstance().sendMessage(new String[] {"zanimaux.pi@gmail.com"}, "Zanimaux", m);  
            }
            }
        });
        
        
         
//        
        Label bienvenue = new Label("Bienvenue dans Zanimaux");
        
        f.add(bienvenue);
        
        ImageViewer imgv1 = new ImageViewer();
        try {
            Image img1 = Image.createImage("/zanimaux.jpg");
            f.add(imgv1);
            imgv1.setImage(img1);
        } catch (IOException ex) {
        }

        


        f.refreshTheme();
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

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
