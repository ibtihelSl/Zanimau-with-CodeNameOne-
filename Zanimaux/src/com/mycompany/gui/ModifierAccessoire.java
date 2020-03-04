/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceAccessoires;
import com.mycompagny.Service.ServiceMagasin;
import com.mycompany.Entite.Accessoires;
import com.mycompany.Entite.Magasin;
import java.io.IOException;


/**
 *
 * @author Touha
 */
public class ModifierAccessoire {
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

    public void start(Accessoires a,String n) {
                        f = new Form("Ajouter Magasins",BoxLayout.y());
                                                                ServiceAccessoires s=new ServiceAccessoires();

                TextField nom=new TextField(a.getNom());
       TextField prix= new TextField(String.valueOf(a.getPrix()));
         Label oldEspece= new Label(a.getEspece());
         ComboBox espece= new ComboBox("Chat","Chien","Oiseaux","Lapin");
          ImageViewer im=new ImageViewer();
        im.setSize(new Dimension(300, 200));
       Button choose=new Button("choose image");
       
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
           s.browseImage(im);
          
            }
        });
       
        Button btnajout= new Button("Modifier");
        
         btnajout.addActionListener((e) -> {
                             
  Accessoires acc = new Accessoires(a.getId(),nom.getText(), Float.parseFloat(prix.getText()), String.valueOf(espece.getSelectedItem()),im.getImage().getImageName());
                s.Modifaccessoire(acc);
                              Dialog.show("Modifier", "Accessoires Modifier" ,"Ok", null);
                              MagasinAdmin ma=new MagasinAdmin();
                                ma.start();
                                                  
                 

                System.out.println("magasin ajouter"+a);
                });
          f.add(nom);
        f.add(prix);
        f.add(oldEspece);
        f.add(espece);
        f.add(choose);
        f.add(btnajout);
        f.add(im);
         f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AccessoiresAdmin ma = new AccessoiresAdmin();
                          try {
                              ma.start(a.getId_magasin(),n);
                          } catch (IOException ex) {
                              System.out.println("erreur acc 2");                          }
                      }
                  });
        
          f.show();

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
