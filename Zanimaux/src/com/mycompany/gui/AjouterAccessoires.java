/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.Validator;
import com.mycompagny.Service.ServiceAccessoires;
import com.mycompagny.Service.ServiceMagasin;
import com.mycompany.Entite.Accessoires;
import com.mycompany.Entite.Magasin;
import java.io.IOException;



/**
 *
 * @author Touha
 */
public class AjouterAccessoires {
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

    public void start(int idmag,String n) {
                        f = new Form("Ajouter Accessoires",new FlowLayout(Component.CENTER,Component.CENTER));
                     Container c =new Container(BoxLayout.y()); 

                                        ServiceAccessoires s=new ServiceAccessoires();

                        
                      TextField   nom = new TextField("","nom",20,TextArea.ANY);
      TextField  prix = new TextField("","prix",20,TextArea.ANY);
             ComboBox espece= new ComboBox("Chat","Chien","Oiseaux","Lapin");

        ImageViewer im=new ImageViewer();
        im.setSize(new Dimension(300, 200));
       Button choose=new Button("choose image");
                Button btnajout= new Button("ajouter");

        
        Validator validator = new Validator();
        validator.addSubmitButtons(btnajout);
        validator.addConstraint(nom, new Constraint() {
        @Override
            public boolean isValid(Object value) {
               return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ nom vide";
            }
        });
        validator.addConstraint(prix, new Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("") ;
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ prix vide";
            }
        });
        
        
       
        
        
        
        
 
       
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
           s.browseImage(im);
          
            }
        });
       
         btnajout.addActionListener((e) -> {
  Accessoires a = new Accessoires(nom.getText(), Float.parseFloat(prix.getText()), String.valueOf(espece.getSelectedItem()),idmag,im.getImage().getImageName());
                s.ajoutaccessoires(a);
                            Dialog.show("ajout", "Accessoire Ajouter a"+n ,"Ok", null);
                          MagasinAdmin ad=new MagasinAdmin();
                                ad.start();
                           
                              

                System.out.println("magasin ajouter"+a);
                });
          c.add(nom);
        c.add(prix);
        c.add(espece);
        c.add(choose);
        c.add(btnajout);
        c.add(im);
        f.add(c);
         f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      MagasinAdmin aaa = new MagasinAdmin();
                          
                              aaa.start();
                      }
                  });
          f.show();

    }
     
  /*    String image_path;
  
    private void load(ActionEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            image_path = selectedFile.toURI().toURL().toString();
            Image image = new Image(image_path);
            imgviewadd.setImage(image);
        } else {
            System.out.println("fichier invalide");
        }
    }
*/
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
