/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.Entities.Article;
import com.mycompagny.Service.CrudArticle;
import java.util.ArrayList;

/**
 *
 * @author ci
 */
public class AfficheArticle {
       private Form current;

          Form f;
        SpanLabel lb;

    public void start() {
                        f = new Form("Les Articles",BoxLayout.y());
                  /*      lb = new SpanLabel("");
                      Container c =new Container(BoxLayout.y()); 

                   

     f.add(lb);*/
                              CrudArticle servicemagain=new CrudArticle();
  
   //  lb.setText(servicemagain.getList2().toString());
     

                 ArrayList<Article> listMagasin = servicemagain.getList2();

                                for(Article m : listMagasin){
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
 Button ajout = new Button("Ajouter un Article");

        ajout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AjoutArticle modifmag=new  AjoutArticle();
            modifmag.start();

           
        }});

        Button modif = new Button("Modifier un Article");

        modif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ModifArticle modifmag=new  ModifArticle();
            modifmag.start(m.getId(),m.getTitre(),m.getDetails());

           
        }});
        
        
         Button media = new Button("Article Audio");

        media.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AdminMedia media=new  AdminMedia();
            media.start();

           
        }});
        Button video = new Button("Article video");

        video.addActionListener(new ActionListener() {
             @Override
           public void actionPerformed(ActionEvent evt) {
            
           video af = new video();
       af.start();

           
        }});
       int id=m.getId();
     Button Delete = new Button("Supprimer un Article");

        Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            servicemagain.suppArticle(id);
          Dialog.show("suppression", "Article "+m.getTitre()+m.getDetails()+"a été Supprimer" ,"Ok", null);

          start();

           
        }});
        
        Label l = new Label(m.getTitre());
        l.getAllStyles().setFgColor(0xF69602);
        
        SpanLabel l2 = new SpanLabel(m.getDetails());
         l2.getAllStyles().setFgColor(0x000000);

        

        c.add(l);
        c.add(l2);
       
        c.add(ajout);
       c.add(media);
        c.add(video);
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
