/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import com.codename1.components.ImageViewer;
import com.codename1.io.JSONParser;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.Validator;
import com.mycompany.Entities.Veterinaires;
import com.mycompagny.Service.CrudVeterinaire;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ci
 */

public class AjoutVet {
     Form f;
      ImageViewer im;
       private Form current;
    private Resources theme;

     public void start(String n) {
                        f = new Form("Ajouter un veterinaire",BoxLayout.y());
                                             Container c =new Container(BoxLayout.y()); 

                                                      CrudVeterinaire servicemagain=new CrudVeterinaire();


     Label l = new Label("Ajouter un Veterinaire");
        TextField Nom = new TextField("", "Nom", 20, TextField.ANY);
              TextField   address = new TextField("", "Addresse", 20, TextField.ANY);
       TextField  ville = new TextField("", "Ville", 20, TextField.ANY);
        TextField  phone = new TextField("", "Phone", 20, TextField.ANY);
      TextField email = new TextField("", "Email", 20, TextField.ANY);
  
        
            Button btnajout= new Button("ajouter");

       
               
               
        Validator validator = new Validator();
        validator.addSubmitButtons(btnajout);
        
        
        validator.addConstraint(Nom, new com.codename1.ui.validation.Constraint() {
        @Override
            public boolean isValid(Object value) {
               return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ nom vide";
            }
        });
        validator.addConstraint(address, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ adresse vide";
            }
        });
         validator.addConstraint(ville, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ ville vide";
            }
        });
         validator.addConstraint(phone, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ phone vide";
            }
        });
         validator.addConstraint(email, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ email vide";
            }
        });
        
         
          
        

        /**
         * ***
         */
        JSONParser json = new JSONParser();
        /**
         * ***
         */
        c.add(l);
        f.add(Nom);
         f.add(address);
        f.add(ville);
        f.add(phone);
        f.add(email);

//                c.add(im);
        f.add(btnajout);

   
        
        
       
       
         btnajout.addActionListener((e) -> {
  Veterinaires m = new Veterinaires(Nom.getText(), address.getText(), ville.getText(), phone.getText(),email.getText());
                servicemagain.ajoutvet(m);
                            Dialog.show("ajout", "Veterinaire Ajouter a"+n ,"Ok", null);
                          AfficheVet ad=new AfficheVet();
                                ad.start();
                           
                              

                System.out.println("veterinaire ajouter"+m);
                });
       
          f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AfficheVet af = new AfficheVet();
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
         public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }
    
    public void destroy() {
    }
    

     public Form getForm() {
        return f;
    }

    public void setForm(Form f) {
        this.f = f;
    }
}
