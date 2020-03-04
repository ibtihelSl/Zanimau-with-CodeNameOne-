/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.Entities.Assurance;
import com.mycompagny.Service.CrudAssurance;
import com.mycompany.gui.accueilAdminController;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ci
 */
public class AfficheAssurance {
     private Form current;

          Form f;
        SpanLabel lb;

    public void start() {
                        f = new Form("Les Assurances",BoxLayout.y());
                  /*      lb = new SpanLabel("");
                      Container c =new Container(BoxLayout.y()); 

                   

     f.add(lb);*/
                        try {
            Command cm1 = new Command("");
            Image img1 = Image.createImage("/BACK2_26880 (2).png");
            cm1.setIcon(img1);
            f.getToolbar().addCommandToLeftBar(cm1);
            f.addCommandListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getCommand() == cm1) {
                          accueilAdminController mc = new accueilAdminController();
                                    mc.start();
                    }
                }
            });
        } catch (IOException ex) {

        }
                              CrudAssurance servicemagain=new CrudAssurance();
  
   //  lb.setText(servicemagain.getList2().toString());
     

                 ArrayList<Assurance> listMagasin = servicemagain.getList2();

                                for(Assurance m : listMagasin){
                                    Container finishLandingPage = new Container(BoxLayout.x());
        Container c = new Container(BoxLayout.y());
        Container containervide = new Container(BoxLayout.x());
        Label spaceLabel0 = new Label(" ");
        Label spaceLabel2 = new Label(" ");
        containervide.add(spaceLabel0);
        containervide.add(spaceLabel2);

       /* try {
            enc = EncodedImage.create("/giphy.gif");
        } catch (IOException ex) {
            System.out.println("error encoder");
        }*/
 Button ajout = new Button("Ajouter une Assurance");

        ajout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AjoutAssurance modifmag=new AjoutAssurance();
            modifmag.start();

           
        }});

        Button modif = new Button("Modifier une Assurance");

        modif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ModifAssurance modifmag=new  ModifAssurance();
            modifmag.start(m.getId(),m.getNom(),m.getAdresse(),m.getMail(),m.getDescription(),String.valueOf(m.getPrixparanimaux()));

           
        }});
        
        
       
       int id=m.getId();
     Button Delete = new Button("Supprimer une Assurance");

        Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            servicemagain.suppAssurance(id);
          Dialog.show("suppression", "Assurance "+m.getNom()+m.getAdresse()+m.getMail()+m.getDescription()+m.getPrixparanimaux()+"a été Supprimer" ,"Ok", null);

          start();

           
        }});
        
        Label l = new Label(m.getNom());
        l.getAllStyles().setFgColor(0xF69602);
        
        SpanLabel l2 = new SpanLabel(m.getAdresse());
         l2.getAllStyles().setFgColor(0x000000);

          
        SpanLabel l3 = new SpanLabel(m.getMail());
         l3.getAllStyles().setFgColor(0x000000);

          
        SpanLabel l4 = new SpanLabel(m.getDescription());
         l4.getAllStyles().setFgColor(0x000000);

          
        /*SpanLabel l5 = new SpanLabel(String.valueOf((m.getAge_de_ce_animal())));
         l5.getAllStyles().setFgColor(0x000000);

          
        SpanLabel l6 = new SpanLabel(m.getType_de_ce_animal());
         l6.getAllStyles().setFgColor(0x000000);*/
         
 SpanLabel l7 = new SpanLabel(String.valueOf(m.getPrixparanimaux()));
         l7.getAllStyles().setFgColor(0x000000);
        

        c.add(l);
        c.add(l2);
               c.add(l3);
        c.add(l4);
      //  c.add(l5);
       // c.add(l6);
        c.add(l7);

        c.add(ajout);
        
         c.add(modif);
        c.add(Delete);
        
        c.setWidth(500);
        c.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        c.getUnselectedStyle().setBackgroundGradientEndColor(0xeae4e4);
        c.getUnselectedStyle().setBackgroundGradientStartColor(0xeae4e4);

        containervide.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        containervide.getUnselectedStyle().setBackgroundGradientEndColor(0xFFFFFF);
        containervide.getUnselectedStyle().setBackgroundGradientStartColor(0xFFFFFF);
       /* finishLandingPage.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        finishLandingPage.getUnselectedStyle().setBackgroundGradientEndColor(0xFFFFFF);
        finishLandingPage.getUnselectedStyle().setBackgroundGradientStartColor(0xFFFFFF);*/
        // c.add(containervide);
      //  finishLandingPage.add(c);
        // finishLandingPage.add(containervide);
    //    c.setPreferredW(400);
     //  f.add(FlowLayout.encloseIn(finishLandingPage));
     //   f.add(containervide);
                                         /*     Container c =new Container(BoxLayout.x()); 

                                   // f.add("Nom :");
                                   // f.add(m.getNom());
                                  String nom=m.getNom().toString();
                                  String address=m.getAddresse().toString();
                                  String ville=m.getVille().toString();
                                  String phone = m.getPhone().toString();
                                   Label l1= new Label(nom);
                                   Label l2= new Label(address);
                                   Label l3= new Label(ville);
                                   Label l4= new Label(phone);
                                   c.add(l1);
                                   c.add(l2);
                                   c.add(l3);
                                   c.add(l4);*/
                                   f.add(c);
                                     f.add(containervide);
                                }

        
          //f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          f.show();
       /*   });*/

    }

    public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public void destroy() {
    }
    
}
