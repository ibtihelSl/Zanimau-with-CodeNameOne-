/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.Entite.Animal;
import com.mycompagny.Service.AnimalService1;
import com.mycompagny.Service.ServiceAnimal;

/**
 *
 * @author souad
 */
public class AjoutAnimal {

//    
//       private Form current;
//    private Resources theme;
//
//    public void init(Object context) {
//        theme = UIManager.initFirstTheme("/theme");
//
//        // Enable Toolbar on all Forms by default
//        Toolbar.setGlobalToolbar(true);
//
//        // Pro only feature, uncomment if you have a pro subscription
//        // Log.bindCrashProtection(true);
//    }
//    Form f;
//        SpanLabel lb;
//
//    public void start() {
//                        f = new Form("Ajouter Animal",BoxLayout.y());
//                TextField espece= new TextField("", "Espece");
//       TextField race= new TextField("","Race");
//         TextField age= new TextField("", "age");
//       TextField poids= new TextField("","poids");
//        Button btnajout= new Button("ajouter");
//        
//         btnajout.addActionListener((e) -> {
//                              ServiceAnimal serviceAn=new ServiceAnimal();
//  Animal m = new Animal(espece.getText(), race.getText(), Integer.parseInt(age.getText()), Double.parseDouble(poids.getText()));
//                serviceAn.ajoutAnimal(m);
//                              Dialog.show("ajout", "Animal Ajouté" ,"Ok", null);
//                    //          MagasinAdmin ma=new MagasinAdmin();
//                         //     ma.start();
//                              
//
//                System.out.println("Animal ajoutée"+m);
//                });
//          f.add(espece);
//        f.add(race);
//        f.add(age);
//        f.add(poids);
//        f.add(btnajout);
//        
//          f.show();
//
//    }
//
//    public void stop() {
//        current = Display.getInstance().getCurrent();
//        if(current instanceof Dialog) {
//            ((Dialog)current).dispose();
//            current = Display.getInstance().getCurrent();
//        }
//    }
//    
//    public void destroy() {
//    }
//
//    
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
ImageViewer im;
    public void start( ) {
        f = new Form("Ajouter Animal", new FlowLayout(Component.CENTER, Component.CENTER));
        Container c = new Container(BoxLayout.y());

        AnimalService1 s = new AnimalService1();

        TextField race = new TextField("", "race", 20, TextArea.ANY);
        TextField age = new TextField("", "age", 20, TextArea.ANY);

        TextField poids = new TextField("", "poids", 20, TextArea.ANY);

        ComboBox espece = new ComboBox("Chat", "Chien", "Oiseaux", "Lapin");

        im = new ImageViewer();
       // im.setSize(new Dimension(300, 200));
        Button choose = new Button("choose image");
        Button btnajout = new Button("ajouter");

        Validator validator = new Validator();
        validator.addSubmitButtons(btnajout);
        validator.addConstraint(espece, new Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ nom vide";
            }
        });
        validator.addConstraint(age, new Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ age vide";
            }
        });

        validator.addConstraint(poids, new Constraint() {
            @Override
            public boolean isValid(Object value) {
                return !String.valueOf(value).equals("");
            }

            @Override
            public String getDefaultFailMessage() {
                return "Champ poids vide";
            }
        });

        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                s.browseImage(im);

            }
        });

        btnajout.addActionListener((e) -> {
            Animal a = new Animal(String.valueOf(espece.getSelectedItem()), Integer.parseInt(age.getText()), Double.parseDouble(poids.getText()), race.getText(), im.getImage().getImageName());
            s.ajoutaccessoires(a);
            Dialog.show("ajout", "Animal "+ a.getNom_a( )+ "a été ajouté avec succées", "Ok", null);
            System.out.println(im.getImage().getImageName());
            AniAdmin ad = new AniAdmin();
            ad.start();
            

            System.out.println("Animal ajouté" + a);
        });
        c.add(espece);
        c.add(race);
        c.add(age);
        c.add(poids);
        c.add(choose);
        c.add(btnajout);
        c.add(im);
        f.add(c);
        f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AniAdmin aaa = new AniAdmin();

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
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }

    public void destroy() {
    }

}
