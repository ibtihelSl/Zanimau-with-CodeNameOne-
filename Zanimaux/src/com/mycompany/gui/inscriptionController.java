
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
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
import java.io.IOException;
/**
 *
 * @author Said
 */
public class inscriptionController {
    
    private Form current;
    private Resources theme;
    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");
        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }
    public void start() {
        Form f = new Form("Mon Compte", BoxLayout.y());
       

         try {
             Command cm1 = new Command("");
             Image img1 = Image.createImage("/BACK2_26880 (2).png");
             cm1.setIcon(img1);
             f.getToolbar().addCommandToLeftBar(cm1);
             f.addCommandListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getCommand()==cm1)
                                {
                                   accueilController affc = new accueilController();
                               affc.start();
                                }
                             }
                            });
         } catch (IOException ex) {
            
         }
        
      
        Label bienvenue = new Label("Inscrivez-vous");
        Button inscriptionclient = new Button("Inscription Client");
        
                       
        f.add(bienvenue);
        f.add(inscriptionclient);
   
        ImageViewer imgv1 = new ImageViewer();
               
        try {
            Image img1 = Image.createImage("/zanimaux.jpg");
              f.add(imgv1);
             imgv1.setImage(img1);  
        } catch (IOException ex) {    
        }
        
        
        inscriptionclient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                               AjouterUserCController affc = new AjouterUserCController();
                               affc.start();
                }    
        });
        
        
        
    
        
       f.show();
        
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