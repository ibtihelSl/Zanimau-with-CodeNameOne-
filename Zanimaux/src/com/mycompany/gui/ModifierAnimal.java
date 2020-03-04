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
import com.mycompany.Entite.Animal;
import com.mycompagny.Service.ServiceAnimal;

/**
 *
 * @author souad
 */
public class ModifierAnimal {
    
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

    public void start(int id,String es,String r,String a,String p) {
                        f = new Form("Modifier ",BoxLayout.y());
                TextField espece=new TextField(es);
       TextField race= new TextField(r);
         TextField age= new TextField(a);
       TextField poids= new TextField(p);
        Button btnMdifier= new Button("Modifiez");
        
         btnMdifier.addActionListener((e) -> {
                              ServiceAnimal serviceanimal=new ServiceAnimal();
  Animal m = new Animal(id,espece.getText(),
          Integer.parseInt(age.getText()),
          Double.parseDouble(poids.getText()),
          race.getText());
                serviceanimal.ModifAnimal(m);
                              Dialog.show("Modifier", "Animal Modifié" ,"Ok", null);
                           //   MagasinAdmin ma=new MagasinAdmin();
                           //   ma.start();
                              

                System.out.println("Animal Modifier"+m);
                });
          f.add(espece);
        f.add(race);
        f.add(age);
        f.add(poids);
        f.add(btnMdifier);
         f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AniAdmin ma = new AniAdmin();
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
