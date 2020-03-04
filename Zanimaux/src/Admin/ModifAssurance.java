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
import com.mycompany.Entities.Assurance;
import com.mycompagny.Service.CrudAssurance;


/**
 *
 * @author ci
 */
public class ModifAssurance {
      Form f;
    public void start(int id,String n, String a,String m,String d,String p) {
                        f = new Form("Modifier un Assurance",BoxLayout.y());
                TextField nom=new TextField(n);
                      TextField adresse=new TextField(a);
              
                       TextField mail=new TextField(m);
                      TextField description=new TextField(d);
                      
                     //  TextField ageDeCeAnimal=new TextField(g);
                      //TextField typeDeCeAnimal=new TextField(t);
                                            TextField prixparanimaux=new TextField(p);

                      
        Button btnajout= new Button("Modifier");
        
            btnajout.addActionListener((e) -> {
                              CrudAssurance servicemagain=new CrudAssurance();
                Assurance ss = new Assurance(id,nom.getText(), adresse.getText(), mail.getText(), description.getText(), Double.parseDouble(prixparanimaux.getText()));
                servicemagain.ModifAssurance(ss);
                              Dialog.show("Modifier", "Article Modifier" ,"Ok", null);
                             AfficheAssurance ma=new AfficheAssurance();
                              ma.start();
                              

                System.out.println("Assurance Modifier"+m);
                });
         
           f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AfficheAssurance af = new AfficheAssurance();
                      af.start();
                      }
                  });
                       f.show();
    
          f.add(nom);
                  f.add(adresse);
          f.add(mail);
                  f.add(description); 
//                  f.add(ageDeCeAnimal);
  //                f.add(typeDeCeAnimal); 
                  f.add(prixparanimaux);
        f.add(btnajout);
        
          f.show();

    
    }}
