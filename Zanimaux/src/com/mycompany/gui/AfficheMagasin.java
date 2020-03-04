/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceMagasin;
import com.mycompany.Entite.Magasin;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Touha
 */
public class AfficheMagasin {
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

    public void start() {
                        f = new Form("Magasins",BoxLayout.y());

                        try {
            Command cm1 = new Command("");
            Image img1 = Image.createImage("/BACK2_26880 (2).png");
            cm1.setIcon(img1);
            f.getToolbar().addCommandToLeftBar(cm1);
            f.addCommandListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getCommand() == cm1) {
                          accueilConnectedController mc = new accueilConnectedController();
                                    mc.start();
                    }
                }
            });
        } catch (IOException ex) {

        }
                        ServiceMagasin servicemagain=new ServiceMagasin();
  
     

                 ArrayList<Magasin> listMagasin = servicemagain.getList2();

                                for(Magasin m : listMagasin){
                                    Container finishLandingPage = new Container(BoxLayout.x());
        Container c = new Container(BoxLayout.y());
        Container containervide = new Container(BoxLayout.x());
        Label spaceLabel0 = new Label(" ");
        Label spaceLabel2 = new Label(" ");
        containervide.add(spaceLabel0);
        containervide.add(spaceLabel2);

        
       int id=m.getId();
    
        Label l = new Label(m.getNom());
        l.getAllStyles().setFgColor(0x778899);
        SpanLabel l2 = new SpanLabel(m.getAddresse());
         l2.getAllStyles().setFgColor(0xF0FFFF);

        SpanLabel l3 = new SpanLabel( m.getVille());
      l3.getAllStyles().setFgColor(0xF0FFFF);

        SpanLabel l4 = new SpanLabel(  m.getPhone());
        
        l4.getAllStyles().setFgColor(0xF0FFFF);
      SpanLabel l5 = new SpanLabel(m.getPhone());
         Button accessoireButton = new Button("Accessoires");

        accessoireButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            
           AfficheAccessoires af = new AfficheAccessoires();
                try {
                    af.start(id,m.getNom());
                } catch (IOException ex) {
                    System.out.println("erreur affiche mag");     
                }

           
        }});
          Button maps = new Button("affiche dans map");
    
        maps.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            
           mapmagasin mm = new mapmagasin();
       mm.lister(m.getAddresse(),m.getNom());

           
        }});
      

        c.add(l);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(maps);
        c.add(accessoireButton);
        
        c.setWidth(500);
        c.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        c.getUnselectedStyle().setBackgroundGradientEndColor(0xeae4e4);
        c.getUnselectedStyle().setBackgroundGradientStartColor(0xeae4e4);

        containervide.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        containervide.getUnselectedStyle().setBackgroundGradientEndColor(0xFFFFFF);
        containervide.getUnselectedStyle().setBackgroundGradientStartColor(0xFFFFFF);
      
                                
                                   f.add(c);
                                     f.add(containervide);
                                }

        f.getToolbar().addCommandToRightBar("Map", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                      map map = new map();
                      map.lister();
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
