/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entities.Comment;
import com.mycompagny.Service.CrudComment;

/**
 *
 * @author ci
 */
public class ModifComment {
    Form f;
    public void start(int article_id,String mm) {
                        f = new Form("Modifier un Commentaire",BoxLayout.y());
                TextField message=new TextField(mm);
      
        Button btnajout= new Button("Modifier");
        
         btnajout.addActionListener((e) -> {
                              CrudComment servicemagain=new CrudComment();
  Comment m = new Comment(article_id,message.getText());
                servicemagain.ModifComment(m);
                              Dialog.show("Modifier", "Commentaire Modifier" ,"Ok", null);
                             AjouterComment ma=new AjouterComment();
                              ma.start(article_id);
                              

                System.out.println("Commentaire Modifier"+m);
                });
         
           f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AfficherComment af = new AfficherComment();
                      af.start(article_id);
                      }
                  });
                       f.show();
    
          f.add(message);
        
        f.add(btnajout);
        
          f.show();

    }
    
}
