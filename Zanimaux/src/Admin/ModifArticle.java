/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entities.Article;
import com.mycompagny.Service.CrudArticle;


/**
 *
 * @author ci
 */
public class ModifArticle {
      Form f;
    public void start(int id,String t, String d) {
                        f = new Form("Modifier un Article",BoxLayout.y());
                TextField titre=new TextField(t);
                      TextField details=new TextField(d);
              
        Button btnajout= new Button("Modifier");
        
            btnajout.addActionListener((e) -> {
                              CrudArticle servicemagain=new CrudArticle();
                Article m = new Article(id,titre.getText(), details.getText());
                servicemagain.ModifArticle(m);
                              Dialog.show("Modifier", "Article Modifier" ,"Ok", null);
                             AfficheVet ma=new AfficheVet();
                              ma.start();
                              

                System.out.println("Article Modifier"+m);
                });
         
           f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AfficheArticle af = new AfficheArticle();
                      af.start();
                      }
                  });
                       f.show();
    
          f.add(titre);
                  f.add(details);
         
        f.add(btnajout);
        
          f.show();

    }
    
}
