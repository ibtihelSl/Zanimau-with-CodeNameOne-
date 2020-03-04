/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Adoption;
import com.mycompany.Entite.Animal;
import com.mycompagny.Service.AnimalService1;
import com.mycompagny.Service.ServiceAnimal;
import com.mycompany.Entite.User;
import java.io.IOException;

 

/**
 *
 * @author souad
 */
public class AffichageAni {

    Form f;

    Label lb;

    public void AffichageAnimaux() {

        f = new Form("List Animaux", BoxLayout.y());
          try {
            Command cm1 = new Command("");
            Image img1 = Image.createImage("/BACK2_26880 (2).png");
            cm1.setIcon(img1);
            f.getToolbar().addCommandToLeftBar(cm1);
            f.addCommandListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getCommand() == cm1) {
                          accueilConnectedController mc = new accueilConnectedController();
                                    mc.start();
                    }
                }
            });
        } catch (IOException ex) {

        }

        ServiceAnimal Es = new ServiceAnimal();
        for (Animal a : Es.getLisEvent1()) {
            lb = new Label("");
            Image placeholder = Image.createImage(500, 170);
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            URLImage imgUrl = URLImage.createToStorage(encImage, "http://localhost/integration/symfony3/web/images/" + a.getNom_image(), "http://localhost/integration/symfony3/web/images/" + a.getNom_image());
            ImageViewer img1 = new ImageViewer(imgUrl);

            System.out.println(a.getNom_image());

            lb.setText(a.getNom_a());
            lb.setText(a.getNom_a());

            //    lb2.setText(Es.getListCabinet2().get(i).getSpecialite().toString());
            Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            System.out.println(a.getNom_image());

            Button adoptionsBtn = new Button("Adoptez");
int ide= a.getId(); 
                 AnimalService1 as=new AnimalService1();
               //     ArrayList<Adoption> lista = as.rechadop(connectedUser, ide);
               //     int length=lista.size();
            adoptionsBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
//
//                     LocalNotification n = new LocalNotification();
//        n.setId("demo-notification");
//        n.setAlertBody("It's time to take a break and look at me");
//        n.setAlertTitle("Break Time!");
//        n.setAlertSound("/notification_sound_bells.mp3"); //file name must begin with notification_sound
//
//
//        Display.getInstance().scheduleLocalNotification(
//                n,
//                System.currentTimeMillis() + 10 * 1, // fire date/time
//                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
//        );
//      

                  /* SMS smsTut = new SMS();

                                    String num_tel_user = "+21652926497"; 
                                    String msg = "Vous avez adopté un animal";

                                    String login = "Souad95";
                                    String password = "SouSSou1995";

                                    smsTut.SendSMS(login, password, msg, num_tel_user, "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0"); 
                    
                    AffichageAdoption af = new AffichageAdoption();
                    af.start();

                    Message m = new Message("Vous avez adopté un animal depuis notre application ZANIMAUX");
                    Display.getInstance().sendMessage(new String[]{"souad.saidi@gmail.com"}, "PIDEV", m);*/
                  //  if (length == 0){
                        as.ajoutadop(User.connectedUser, ide);
                        Dialog.show("Adopter avec succés !", "félicitation !", "Ok", null);
                        
                    /*   }
                           else { Dialog.show("Erreur", "deja adopté", "OK", null);}
                    
              */  }

            });

            Button Delete = new Button("Supprimez");

            Delete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    int id = a.getId();

                    Es.suppAnimal(id);
                    Dialog.show("suppression", "Animal " + a.getNom_a() + "a été Supprimé", "Ok", null);

                    AffichageAnimaux();

                }
            });

            Button Modifier = new Button("Modifiez");

            Modifier.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ModifierAnimal modifAnimal = new ModifierAnimal();
                    modifAnimal.start(a.getId(), a.getNom_a(), Integer.toString(a.getAge()), Double.toString(a.getPoids()), a.getRace());

                }
            });

            c1.add(lb);
            c1.add(img1);
            f.add(c1);
            f.add(adoptionsBtn);
            //   f.add(Modifier);
            //  f.add(Delete);

        }
        Button add = new Button("Ajoutez Animal");

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                AjouterAnimal1 am = new AjouterAnimal1();
                am.start();

            }
        });

        //  f.add(add);
        f.show();

    }

}
