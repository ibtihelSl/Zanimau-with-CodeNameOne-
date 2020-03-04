/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceAccessoires;
import com.mycompany.Entite.Accessoires;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.util.ArrayList;


/**
 *
 * @author Touha
 */
public class AccessoiresAdmin {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    
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
    public void start(int idmag,String nom) throws IOException {
                                 f = new Form("Accessoires ",BoxLayout.y());
                                     Container cnmag =new Container(new FlowLayout(Component.CENTER,Component.CENTER)); 
                 Label lnmag = new Label(nom );
                 lnmag.getAllStyles().setFgColor(0xA52A2A);
                cnmag.add(lnmag);
                f.add(cnmag);
        lb = new SpanLabel("");
        f.add(lb);
        ServiceAccessoires serviceacc=new ServiceAccessoires();
        ArrayList<Accessoires> list = serviceacc.getList2(idmag);
                for (Accessoires a: list)     
                               
                {   
        Container finishLandingPage = new Container(BoxLayout.x());
        Container c = new Container(BoxLayout.y());
        Container containervide = new Container(BoxLayout.x());
        Label spaceLabel0 = new Label(" ");
        Label spaceLabel2 = new Label(" ");
        containervide.add(spaceLabel0);
        containervide.add(spaceLabel2);
 //EncodedImage  enc ;
      
 //        enc = EncodedImage.create(img1);
        
  /*     Image placeholder = Image.createImage(170, 70);
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            URLImage imgUrl = URLImage.createToStorage(encImage, "http://localhost/touha/symfony3/web/images/" + a.getImage(), "http://localhost/touha/symfony3/web/images/" + a.getImage());
            ImageViewer img1 = new ImageViewer(imgUrl);*/

         Image placeholder = Image.createImage(200, 100);
            EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
         URLImage img1 = URLImage.createToStorage(enc , "imkkhaf" + a, "http://localhost/touha/symfony3/web/images/" + a.getImage(), URLImage.RESIZE_SCALE);
               int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
                     img1.fill(500, 100);
                            
        finishLandingPage.add(img1.scaledWidth(150));
        Label l = new Label(a.getNom() );
        l.getAllStyles().setFgColor(0x778899);
        SpanLabel l2 = new SpanLabel(valueOf(a.getPrix()));

        l2.getAllStyles().setFgColor(0x000000);
        SpanLabel l3 = new SpanLabel(a.getEspece());
    Button Delete = new Button("Supprimer");

            Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
             ServiceAccessoires s=new ServiceAccessoires();

            s.suppacc(a.getId());
          Dialog.show("suppression", "Accessoire "+a.getNom()+" a été Supprimer" ,"Ok", null);

                try {
                    start(idmag,nom);
                } catch (IOException ex) {
                    System.out.println("erreur");                }

           
        }});
        
         Button Modifier = new Button("Modifier");

        Modifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            ModifierAccessoire modifacc=new ModifierAccessoire();
            modifacc.start(a,nom);

           
        }});
        
       
        c.add(l);
        c.add(l2);
        c.add(l3);
        c.add(Modifier);
        c.add(Delete);
        c.setWidth(500);
        c.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        c.getUnselectedStyle().setBackgroundGradientEndColor(0xeae4e4);
        c.getUnselectedStyle().setBackgroundGradientStartColor(0xeae4e4);

        containervide.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        containervide.getUnselectedStyle().setBackgroundGradientEndColor(0xFFFFFF);
        containervide.getUnselectedStyle().setBackgroundGradientStartColor(0xFFFFFF);
        finishLandingPage.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        finishLandingPage.getUnselectedStyle().setBackgroundGradientEndColor(0xFFFFFF);
        finishLandingPage.getUnselectedStyle().setBackgroundGradientStartColor(0xFFFFFF);
        // c.add(containervide);
        finishLandingPage.add(c);
        // finishLandingPage.add(containervide);
        c.setPreferredW(600);
        f.add(FlowLayout.encloseIn(finishLandingPage));
        f.add(containervide);
       
        
        
                }
        
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

    

