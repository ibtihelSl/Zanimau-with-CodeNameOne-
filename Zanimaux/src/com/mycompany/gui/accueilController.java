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
public class accueilController {

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
    
        Command cm5 = new Command("Contact Us");

        f.getToolbar().addCommandToSideMenu(cm1);
       
        f.getToolbar().addCommandToSideMenu(cm5);
        
        
           f.addCommandListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                if (evt.getCommand() == cm5) {
            Message m = new Message("Body of message");


         Display.getInstance().sendMessage(new String[] {"zanimaux.pi@gmail.com"}, "Subject of message", m);  
            }
            }
        });
        
        
         
//        
        Label bienvenue = new Label("Bienvenue dans Zanimaux");
        Button inscription = new Button("S'inscrire");
        Button connexion = new Button("Se connecter");
        Button connexionfb = new Button("Se connecter avec Facebook");

        f.add(bienvenue);
        f.add(inscription);
        f.add(connexion);
        f.add(connexionfb);
      
        ImageViewer imgv1 = new ImageViewer();
        try {
            Image img1 = Image.createImage("/zanimaux.jpg");
            f.add(imgv1);
            imgv1.setImage(img1);
        } catch (IOException ex) {
        }

        connexion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                loginController lc = new loginController();
                lc.start();

            }
        });

         connexionfb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

               new TestForm(theme).show();

            }
        });
        
        inscription.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                inscriptionController insc = new inscriptionController();
                insc.start();

            }
        });

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
