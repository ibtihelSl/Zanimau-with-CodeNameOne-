/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.GUI;

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
import com.codename1.ui.validation.Validator;
import com.mycompany.Entities.Comment;
import com.mycompagny.Service.CrudComment;

/**
 *
 * @author ci
 */
public class AjouterComment {
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

    public void start(int article_id) {
                        f = new Form("Ajouter un Commantaire",BoxLayout.y());
        TextField message = new TextField("", "Message", 20, TextField.ANY);
    
        Button btnajout= new Button("ajouter");
         Validator validator = new Validator();
        validator.addSubmitButtons(btnajout);
        
        
        validator.addConstraint(message, new com.codename1.ui.validation.Constraint() {
        @Override
            public boolean isValid(Object value) {
               return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ message vide";
            }
        });
        
         btnajout.addActionListener((e) -> {
                              CrudComment servicemagain=new CrudComment();
             Comment m = new Comment(article_id,message.getText());
                servicemagain.AjoutPro(m);
                              Dialog.show("ajout", "Commantaire Ajouter" ,"Ok", null);
                              AjouCommentForm ma=new AjouCommentForm();
                              ma.start(article_id);
                              

                System.out.println("Commentaire ajouter"+m);
                });
         
          f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AjouCommentForm af = new AjouCommentForm();
                      af.start(article_id);
                      }
                  });
                       f.show();
    
           
         
          f.add(message);
       
        f.add(btnajout);
        
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
