/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import com.codename1.io.JSONParser;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.validation.Validator;
import com.mycompany.Entities.Assurance;
import com.mycompagny.Service.CrudAssurance;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ci
 */
public class AjoutAssurance {
    Form f;
     public void start() {
                        f = new Form("Ajouter une Assurance",BoxLayout.y());

     Label l = new Label("Ajouter une Assurance");
        TextField nom = new TextField("", "Nom", 20, TextField.ANY);
                TextField adresse = new TextField("", "Adresse", 20, TextField.ANY);
      
                 TextField mail = new TextField("", "Email", 20, TextField.ANY);
                TextField description = new TextField("", "Description", 20, TextField.ANY);
      
                 //TextField ageDeCeAnimal = new TextField("", "Age de l'animal", 20, TextField.ANY);
                //TextField typeDeCeAnimal = new TextField("", "Type de l'animal", 20, TextField.ANY);
      
                 TextField prixparanimaux = new TextField("", "Prix par nombre d'animal", 20, TextField.ANY);
      
        Form hi = new Form("ComboBox", new BoxLayout(BoxLayout.Y_AXIS));
              Button BtnAjouter = new Button("Ajouter");


                Validator validator = new Validator();
        validator.addSubmitButtons(BtnAjouter);
        
        
        validator.addConstraint(nom, new com.codename1.ui.validation.Constraint() {
        @Override
            public boolean isValid(Object value) {
               return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ nom vide";
            }
        });
        validator.addConstraint(adresse, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ adresse vide";
            }
        });
         validator.addConstraint(mail, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ email vide";
            }
        });
         validator.addConstraint(description, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ description vide";
            }
        });
        /* validator.addConstraint(typeDeCeAnimal, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ type de l'animal vide";
            }
        });*/
        
/*validator.addConstraint(ageDeCeAnimal, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ age de l'animal vide";
            }
        });*/
         validator.addConstraint(prixparanimaux, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ prix vide";
            }
        });
        
        

        /**
         * ***
         */
        JSONParser json = new JSONParser();
        /**
         * ***
         */
        f.add(l);
        f.add(nom);
               f.add(adresse);
                 f.add(mail);
               f.add(description); 
              // f.add(ageDeCeAnimal);
               //f.add(typeDeCeAnimal);  
               f.add(prixparanimaux);
      
        f.add(BtnAjouter);

       BtnAjouter.addActionListener((e) -> {
                              CrudAssurance servicemagain=new CrudAssurance();
                Assurance m = new Assurance(nom.getText(), adresse.getText(), mail.getText(), description.getText(), Double.parseDouble(prixparanimaux.getText()));
                servicemagain.ajoutAssurance(m);
                              Dialog.show("ajout", "Assurance Ajouter" ,"Ok", null);
                              AfficheAssurance ma=new AfficheAssurance();
                              ma.start();
                              

                System.out.println("Assurance ajouter"+m);
                });
       
       
        
          f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AfficheAssurance af = new AfficheAssurance();
                      af.start();
                      }
                  });
                       f.show();
    
            f.show();
     }
         private Map<String, Object> createListEntry(String s1) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", s1);

        return entry;
    }

     public Form getForm() {
        return f;
    }

    public void setForm(Form f) {
        this.f = f;
    }
    
}
