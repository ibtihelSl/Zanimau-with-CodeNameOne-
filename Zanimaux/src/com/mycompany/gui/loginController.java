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
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceUser;
import com.mycompany.Entite.User;
import static com.mycompany.Entite.User.connectedUser;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Said
 */
public class loginController {

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
        Form f = new Form("    Connexion", BoxLayout.y());

        try {
            Command cm1 = new Command("");
            Image img1 = Image.createImage("/BACK2_26880 (2).png");
            cm1.setIcon(img1);
            f.getToolbar().addCommandToLeftBar(cm1);
            f.addCommandListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getCommand() == cm1) {
                          inscriptionController mc = new inscriptionController();
                                    mc.start();
                    }
                }
            });
        } catch (IOException ex) {

        }

        Slider loginSlider = new Slider();
        Slider passwordSlider = new Slider();
        Label usernameL = new Label("Nom d'utilisateur :");
        TextField username = new TextField("", "Nom d'utilisateur");
        Label passwordL = new Label("Mot de passe :");
        TextField password = new TextField("", "Mot de passe", 20, TextField.PASSWORD);
        Button button = new Button("Se connecter");
        //password.setEchoChar("");
        //password.setConstraint(TextField.PASSWORD);

        //f.getAllStyles().setBgColor(0xe5e7e5);
        f.add(usernameL);
        
        f.add(username);
        f.add(loginSlider);
        
        f.add(passwordL);

        
        f.add(password);
        f.add(passwordSlider);
        f.add(button);
           f.show();

        /* if (username.getText()=="" && password.getText() =="")
        {
            
        }*/
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

//                ConnectionRequest req = new ConnectionRequest();
//                req.setUrl("http://localhost/integrationfinal/symfony3/web/app_dev.php/user/findBy/"  + username.getText() + "&password=" + password.getText() + "");
//
//                req.addResponseListener(new ActionListener<NetworkEvent>() {
//
//                    @Override
//                    public void actionPerformed(NetworkEvent evt) {
//                        byte[] data = (byte[]) evt.getMetaData();
//                        String s = new String(data);
//
//                        System.out.println(s);
//                        if (s.endsWith("s")) {
//
//                        } else {
//                            Dialog.show("Données invalides", "Le nom d'utilisateur et le mot de passe que vous avez entré ne correspondent pas à nos enregistrements. Vérifiez et réessayez.", "Ok", null);
//                        }
//                    }
//                });
//                NetworkManager.getInstance().addToQueue(req);
//            }
//        });






            if(username.getText().equals("") )  {
               
                    Dialog.show("Erreur", "Vous devez saisir le nom d'utilisateur ", "Ok", null);
                
                }          
                else if (password.getText().equals(""))  {
                
                 Dialog.show("Erreur", "Vous devez saisir le mot de passe", "Ok", null);
                    
                }    
                
                else if ((username.getText().equals("admin")) &&( password.getText().equals("admin")) ){
                    accueilAdminController acc = new accueilAdminController();
                acc.start();
            }else{
        ServiceUser s1 = new ServiceUser();
        ArrayList<User> list= s1.getList(username.getText(),password.getText());
         

          if(list.size()==1)
         { 
          connectedUser=list.get(0).getId();
             accueilConnectedController acc = new accueilConnectedController();
                acc.start();
            } else {
      Dialog.show("Données invalides", "Le nom d'utilisateur et le mot de passe que vous avez entré ne correspondent pas à nos enregistrements. Vérifiez et réessayez.", "Ok", null);

            }
                }

     

            }});}

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
