package com.mycompany.myapp;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.Log;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UITimer;
import java.io.IOException;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompagny.Service.ServiceAssociation;
import com.mycompagny.Service.ServiceEvent;
import com.mycompany.Entite.Association;
import com.mycompany.Entite.Event;
import com.mycompany.gui.TestForm;
import com.mycompany.gui.events;
import com.mycompany.gui.inscriptionController;
import com.mycompany.gui.loginController;
import java.util.ArrayList;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {
    private Form current;
    private Resources theme;
    private Container C1, C2;
    private Form page1;
    private Form page2;

    SpanLabel lb, lb1, lb2;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }
    
    public void start() {
         if (current != null) {
            current.show();
            return;
        }
        Form hi = new Form("Zanimaux");

        Label bienvenue = new Label("Bienvenue dans Zanimaux");
        Button inscription = new Button("S'inscrire");
        Button connexion = new Button("Se connecter");
                  Button connexionfb = new Button("Se connecter avec facebook");

        hi.add(bienvenue);
        hi.add(inscription);
        hi.add(connexion);
        hi.add(connexionfb);

        ImageViewer imgv1 = new ImageViewer();
        try {
            Image img1 = Image.createImage("/zanimaux.jpg");
            hi.add(imgv1);
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

        Command cm1 = new Command("Accueil");
       
         Command cm5 = new Command("Contact us");
        Command cm4 = new Command("Back");

        cm4.setIcon(theme.getImage("cal_left_arrow.png"));

        hi.getToolbar().addCommandToSideMenu(cm1);
       
          hi.getToolbar().addCommandToSideMenu(cm5);

       
        
         hi.addCommandListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getCommand() == cm5) {

//                    Message m = new Message("Body of message");
//         Display.getInstance().sendMessage(new String[] {"safa.benturkia@esprit.tn"}, "Subject of message", m);
//         
              Message m = new Message("Body of message");
                
                 
           Display.getInstance().sendMessage(new String[] {"zanimaux.pi@gmail.com"}, "Zanimaux", m);
   
         
                }
            }
        });
        

//            new TestForm(theme).show();
        
        hi.show();
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }
    
    public void destroy() {
    }

}
