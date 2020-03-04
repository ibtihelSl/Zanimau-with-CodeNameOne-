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
import com.mycompany.Entities.Veterinaires;
import com.mycompagny.Service.CrudVeterinaire;

/**
 *
 * @author ci
 */
public class ModifVet {
    Form f;
    public void start(int id,String n, String a, String v, String p, String c) {
                        f = new Form("Modifier un veterinaire",BoxLayout.y());
                TextField nom=new TextField(n);
                      TextField address=new TextField(a);
                TextField ville=new TextField(v);
                TextField phone=new TextField(p);
                TextField email=new TextField(c);

        Button btnajout= new Button("Modifier");
        
            btnajout.addActionListener((e) -> {
                              CrudVeterinaire servicemagain=new CrudVeterinaire();
  Veterinaires m = new Veterinaires(id,nom.getText(), address.getText(), ville.getText(), phone.getText(),email.getText());
                servicemagain.ModifVet(m);
                              Dialog.show("Modifier", "Veterinaire Modifier" ,"Ok", null);
                             AfficheVet ma=new AfficheVet();
                              ma.start();
                              

                System.out.println("Veterinaire Modifier"+m);
                });
         
           f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AfficheVet af = new AfficheVet();
                      af.start();
                      }
                  });
                       f.show();
    
          f.add(nom);
                  f.add(address);
          f.add(ville);
          f.add(phone);
          f.add(email);

        f.add(btnajout);
        
          f.show();

    }
}
