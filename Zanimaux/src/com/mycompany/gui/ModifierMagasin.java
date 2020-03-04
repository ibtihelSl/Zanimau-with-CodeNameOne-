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
import com.mycompagny.Service.ServiceMagasin;
import com.mycompany.Entite.Magasin;

/**
 *
 * @author Touha
 */
public class ModifierMagasin {
    
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

    public void start(int id,String n,String adr,String v,String ph) {
                        f = new Form("Ajouter Magasins",BoxLayout.y());
                TextField nom=new TextField(n);
       TextField addresse= new TextField(adr);
         TextField ville= new TextField(v);
       TextField phone= new TextField(ph);
        Button btnajout= new Button("Modifier");
        
         btnajout.addActionListener((e) -> {
                              ServiceMagasin servicemagain=new ServiceMagasin();
  Magasin m = new Magasin(id,nom.getText(), addresse.getText(), ville.getText(), phone.getText());
                servicemagain.Modifmagasin(m);
                              Dialog.show("Modifier", "Magasin Modifier" ,"Ok", null);
                              MagasinAdmin ma=new MagasinAdmin();
                              ma.start();
                              

                System.out.println("magasin ajouter"+m);
                });
          f.add(nom);
        f.add(addresse);
        f.add(ville);
        f.add(phone);
        f.add(btnajout);
         f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      MagasinAdmin ma = new MagasinAdmin();
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
