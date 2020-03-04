/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.GUI;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.Entities.Assurance;
import com.mycompagny.Service.CrudAssurance;
import java.util.ArrayList;

/**
 *
 * @author ci
 */
public class AfficherAssurance {
      private Form current;

          Form f;
        SpanLabel lb;
int article_id;
    public void start(int id) {
                        f = new Form("Les Assurances",BoxLayout.y());
                  /*      lb = new SpanLabel("");
                      Container c =new Container(BoxLayout.y()); 

                   
     f.add(lb);*/
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
        
         TextField nbranim = new TextField("", "Nombre des animaux", 20, TextField.ANY);

          Button btnCal= new Button("Calculer");
                                    System.out.println(m.toString());
            btnCal.addActionListener((e) -> {
                            //  System.out.println(m.getId());
                              //System.out.println(Double.parseDouble(nbranim.getText()));
                               
             //   Assurance aaa = new Assurance(id,Double.parseDouble(nbranim.getText()));
           //  Assurance res= servicemagain.CalculerAssurance(m.getId(),Double.parseDouble(nbranim.getText()));
           
           double totale= Double.parseDouble(nbranim.getText()) * m.getPrixparanimaux();
                              Dialog.show("Calculer", "Total est "+String.valueOf(totale)/*+String.valueOf(res.getTotalprix())*/,"Ok", null);
                            // AfficherAssurance ma=new AfficherAssurance();
                              //ma.start(id);
                              

               // System.out.println("Assurance calculer"+m);
                });
   
    
      /*   f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      Affichage af = new Affichage();
                      af.start();
                      }
                  });*/
f.show();
       /* try {
            enc = EncodedImage.create("/giphy.gif");
        } catch (IOException ex) {
            System.out.println("error encoder");
        }*/

       
    //   int id=m.getId();
    
        Label l = new Label(m.getNom());
        l.getAllStyles().setFgColor(0xF69602);
        
        SpanLabel l2 = new SpanLabel(m.getAdresse());
         l2.getAllStyles().setFgColor(0x000000);

          
        SpanLabel l3 = new SpanLabel(m.getMail());
         l3.getAllStyles().setFgColor(0x000000);

          
        SpanLabel l4 = new SpanLabel(m.getDescription());
         l4.getAllStyles().setFgColor(0x000000);

          
/*        SpanLabel l5 = new SpanLabel(String.valueOf((m.getAge_de_ce_animal())));
         l5.getAllStyles().setFgColor(0x000000);

          
        SpanLabel l6 = new SpanLabel(m.getType_de_ce_animal());
         l6.getAllStyles().setFgColor(0x000000);*/
         
 SpanLabel l7 = new SpanLabel(String.valueOf(m.getPrixparanimaux()));
         l7.getAllStyles().setFgColor(0x000000);
        

        c.add(l);
        c.add(l2);
               c.add(l3);
        c.add(l4);
//        c.add(l5);
  //      c.add(l6);
        c.add(l7);
     c.add(nbranim);

     c.add(btnCal);
        
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
