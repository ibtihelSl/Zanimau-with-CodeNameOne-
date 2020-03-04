/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.Entite.Animal;
import com.mycompagny.Service.AnimalService1;

/**
 *
 * @author souad
 */
public class AjouterAnimal1 {
    
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
 
                        f = new Form("Ajouter Animal",BoxLayout.y());
                TextField espece= new TextField("", "espece");
       TextField race= new TextField("","race");
         TextField age= new TextField("", "age");
       TextField poids= new TextField("","poids");
        Button btnajout= new Button("ajouter");
        
         Validator validator = new Validator();
        validator.addSubmitButtons(btnajout);
        validator.addConstraint(espece, new Constraint() {
            @Override
            public boolean isValid(Object value) {
               return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ nom vide";
            }
        });
        validator.addConstraint(race, new Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ race vide";
            }
        });
        validator.addConstraint(age, new Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ age vide";
            }
        });
//        validator.addConstraint(poids, new Constraint() {
//            @Override
//            public boolean isValid(Object value) {
//                return String.valueOf(value).length() == 8;
//            }
//
//            @Override
//            public String getDefaultFailMessage() {
//               return  "num tel -8 chiffres";
//            }
//        });
//       

 validator.addConstraint(poids, new Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ poids vide";
            }
        });
       
         btnajout.addActionListener((e) -> {
                              AnimalService1 serviceAnimal=new AnimalService1();
  Animal m = new Animal(espece.getText(), race.getText(), Integer.parseInt(age.getText()), Double.parseDouble(poids.getText()));
                serviceAnimal.ajoutAnimal(m);
                              Dialog.show("ajout", "Animal Ajouté" ,"Ok", null);
                              AniAdmin ma=new AniAdmin();
                              ma.start();
                              

                System.out.println("Animal ajouter"+m);
                });
          f.add(espece);
        f.add(race);
        f.add(age);
        f.add(poids);
        f.add(btnajout);
        
         f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AniAdmin ma = new AniAdmin();
                      ma.start();
                      }
                  });
        
          f.show();

    }
    /* 
      String image_path;
  
    private void load(ActionEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            image_path = selectedFile.toURI().toURL().toString();
            Image image = new Image(image_path);
            imgviewadd.setImage(image);
        } else {
            System.out.println("fichier invalide");
        }
    }
*/
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
