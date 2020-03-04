/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.Validator;
import com.mycompagny.Service.ServiceMagasin;
import com.mycompany.Entite.Magasin;
import java.util.ArrayList;

/**
 *
 * @author Touha
 */
public class AjouterMagasin {

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

    public void start() {
                        f = new Form("Ajouter Magasins",BoxLayout.y());
                TextField nom= new TextField("", "nom",20,TextArea.ANY);
       TextField addresse= new TextField("","addresse",20,TextArea.ANY);
         TextField ville= new TextField("", "ville",20,TextArea.ANY);
       TextField phone= new TextField("","phone",20,TextArea.ANY);
        Button btnajout= new Button("ajouter");
        
         Validator validator = new Validator();
        validator.addSubmitButtons(btnajout);
        validator.addConstraint(nom, new Constraint() {
            @Override
            public boolean isValid(Object value) {
               return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ nom vide";
            }
        });
        validator.addConstraint(addresse, new Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ adresse vide";
            }
        });
        validator.addConstraint(ville, new Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ ville vide";
            }
        });
        validator.addConstraint(phone, new Constraint() {
            @Override
            public boolean isValid(Object value) {
                return String.valueOf(value).length() == 8;
            }

            @Override
            public String getDefaultFailMessage() {
               return  "num tel -8 chiffres";
            }
        });
        
         btnajout.addActionListener((e) -> {
                              ServiceMagasin servicemagain=new ServiceMagasin();
  Magasin m = new Magasin(nom.getText(), addresse.getText(), ville.getText(), phone.getText());
                servicemagain.ajoutmagasin(m);
                              Dialog.show("ajout", "Magasin Ajouter" ,"Ok", null);
                              MagasinAdmin ma=new MagasinAdmin();
                              ma.start();
                              

                System.out.println("magasin ajouter"+m);
                });
          f.add(nom);
        f.add(addresse);
        f.add(ville);
        f.add(phone);
        f.add(btnajout);
        
         f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      MagasinAdmin ma = new MagasinAdmin();
                      ma.start();
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


