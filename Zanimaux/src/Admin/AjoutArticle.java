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
import com.mycompany.Entities.Article;
import com.mycompagny.Service.CrudArticle;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ci
 */
public class AjoutArticle {
    Form f;
     public void start() {
                        f = new Form("Ajouter un Article",BoxLayout.y());

     Label l = new Label("Ajouter un Article");
        TextField titre = new TextField("", "Titre", 20, TextField.ANY);
                TextField details = new TextField("", "Details", 20, TextField.ANY);
      
        Form hi = new Form("ComboBox", new BoxLayout(BoxLayout.Y_AXIS));
      

        Button BtnAjouter = new Button("Ajouter");
        
                Validator validator = new Validator();
        validator.addSubmitButtons(BtnAjouter);
        
validator.addConstraint(titre, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ titre vide";
            }
        });
validator.addConstraint(details, new com.codename1.ui.validation.Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ details vide";
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
        f.add(titre);
               f.add(details);
      
        f.add(BtnAjouter);

         BtnAjouter.addActionListener((e) -> {
                              CrudArticle servicemagain=new CrudArticle();
                Article m = new Article(titre.getText(), details.getText());
                servicemagain.AjoutPro(m);
                              Dialog.show("ajout", "Article Ajouter" ,"Ok", null);
                              AfficheArticle ma=new AfficheArticle();
                              ma.start();
                              

                System.out.println("Article ajouter"+m);
                });
        
          f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AfficheArticle af = new AfficheArticle();
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
