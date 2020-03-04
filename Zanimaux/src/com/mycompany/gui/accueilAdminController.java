/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import Admin.AfficheAssurance;
import Admin.AfficheVet;
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
public class accueilAdminController {

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
        Command cm3 = new Command("Adoption");
        Command cm4 = new Command("Magasin");
        Command cm2 = new Command("Veterinaire");
        Command cm7 = new Command("Assurance");
        Command cm5 = new Command("Animaux");
        Command cm6 = new Command("Logout");
        
        f.getToolbar().addCommandToSideMenu(cm1);
        f.getToolbar().addCommandToSideMenu(cm2);
        f.getToolbar().addCommandToSideMenu(cm7);
        f.getToolbar().addCommandToSideMenu(cm4);
        f.getToolbar().addCommandToSideMenu(cm3);
        f.getToolbar().addCommandToSideMenu(cm5);


        f.getToolbar().addCommandToRightBar(cm6);
        
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
                            if (evt.getCommand() == cm7) {
                                AfficheAssurance affc = new AfficheAssurance();
                               affc.start();
                            }
                        }
                    });
         f.addCommandListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getCommand() == cm2) {
                                AfficheVet affc = new AfficheVet();
                               affc.start();
                            }
                        }
                    });
          f.addCommandListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getCommand() == cm5) {
                                AniAdmin affc = new AniAdmin();
                               affc.start();
                            }
                        }
                    });
           f.addCommandListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getCommand() == cm3) {
                               AffichageAdoption af = new AffichageAdoption();
                    af.start();
                            }
                        }
                    });
         
          f.addCommandListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getCommand() == cm4) {
                               MagasinAdmin affc = new MagasinAdmin();
                               affc.start();
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

}
