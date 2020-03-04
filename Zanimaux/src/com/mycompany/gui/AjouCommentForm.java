/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.Validator;
import com.mycompany.Entities.Comment;
import com.mycompagny.Service.CrudComment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gaalo
 */
public class AjouCommentForm {
    private Form f;
    private Resources theme;
    ConnectionRequest cnx;
    Graphics g;
    String typeE;
    String mm;
    
       private Form current;
int n;
      public void start(int article_id) {
                        f = new Form("Commentaire",BoxLayout.y());
                  /*      lb = new SpanLabel("");
                      Container c =new Container(BoxLayout.y()); 

                   

     f.add(lb);*/
                              CrudComment servicemagain=new CrudComment();
  
   //  lb.setText(servicemagain.getList2().toString());
     

                 ArrayList<Comment> listMagasin = servicemagain.getList2(article_id);

                                for(Comment m : listMagasin){
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


        
       int id=m.getId();
    
        Label l = new Label(m.getMessage());
        l.getAllStyles().setFgColor(0xF69602);
        
       Button ajout = new Button("Ajouter un Commentaire");

        ajout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AjouterComment modifmag=new  AjouterComment();
            modifmag.start(article_id);

           
        }});
        
        

        Button modif = new Button("Modifier un Commentaire");

        modif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ModifComment modifmag=new  ModifComment();
            modifmag.start(m.getId(),m.getMessage());
  f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AffichageArticle af = new AffichageArticle();
                      af.start(article_id);
                      }
                  });
                       f.show();
           
        }});
        
      // int id=m.getId();
     Button Delete = new Button("Supprimer un Commentaire");

        Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            servicemagain.suppComment(id);
          Dialog.show("suppression", "Commentaire "+m.getMessage()+"a été Supprimer" ,"Ok", null);

          start(id);

           
        }});

        c.add(l);
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
  f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      AffichageArticle af = new AffichageArticle();
                      af.start(article_id);
                      }
                  });
                       f.show();
        
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

    

