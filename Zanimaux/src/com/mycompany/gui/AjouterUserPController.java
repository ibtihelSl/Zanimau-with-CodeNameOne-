/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
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
public class AjouterUserPController {
    
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
        Form FormeC = new Form("S'inscrire", BoxLayout.y());
        
              try {
             Command cm1 = new Command("");
             Image img1 = Image.createImage("/BACK2_26880 (2).png");
             cm1.setIcon(img1);
             FormeC.getToolbar().addCommandToLeftBar(cm1);
             FormeC.addCommandListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getCommand()==cm1)
                                {
                                    inscriptionController mc = new inscriptionController();
                                    mc.start();
                                }
                             }
                            });
         } catch (IOException ex) {
            
         }
        
        Label Titre = new Label("Inscription veterinaire");
        TextField username = new TextField("", "Nom d'utilisateur");
        TextField email = new TextField("", "Email");
        TextField password = new TextField("", "Mot de passe");
         
       FormeC.add(Titre);
       FormeC.add(username);
       FormeC.add(email);
       FormeC.add(password);

        Button btnAjouter = new Button("S'inscrire");

        FormeC.add(btnAjouter);
        btnAjouter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                
                
                if (username.getText().equals("") )  {
               
                    Dialog.show("Erreur", "Nom d'utilisateur ne doit pas etre null ", "Ok", null);
                
                }          
                else if (password.getText().equals(""))  {
                
                 Dialog.show("Erreur", "Le mot de passe ne doit pas etre null ", "Ok", null);
                    
                }    
                
                else if (email.getText().equals(""))  {
                
                 Dialog.show("Erreur", "L'email ne doit pas etre null ", "Ok", null);
                    
                }    
               
                else  {
                ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/karhabtymobile/InscriptionCandidat.php?"
                        
                        +"&mot_de_passe=" + password.getText() 
                          +"");

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);

                        if (s.equals("success")) {
                            Dialog.show("Félicitations", "Inscription avec succès ", "Ok", null);
//Envoi SMS    
//             try {
//                   Display.getInstance().sendSMS(tel.getText().toString(), "Bienvenue Dans Notre Auto-école, Espérons que vous"
//                           + "passez de bons moments ");
//               } catch (IOException ex) {
//               }

               }    
                        }
                  
                });
                
                NetworkManager.getInstance().addToQueue(req);
                

            }
            }
        });

       FormeC.show();

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
