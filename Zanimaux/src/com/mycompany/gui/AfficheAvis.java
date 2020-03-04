/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.Validator;
import com.mycompagny.Service.ServiceAvis;
import com.mycompany.Entite.Avis;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.util.ArrayList;



/**
 *
 * @author Touha
 */
public class AfficheAvis {
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
                        f = new Form("Avis",BoxLayout.y());
  ImageViewer imgv1 = new ImageViewer();
                        try {

                           Image img1 = Image.createImage("/Rating.jpg");
                          f.add(imgv1);
                          imgv1.setImage(img1);  
                        } catch (IOException ex) {    
                           }
                        
                         try {
            Command cm1 = new Command("");
            Image img = Image.createImage("/BACK2_26880 (2).png");
            cm1.setIcon(img);
            f.getToolbar().addCommandToLeftBar(cm1);
            f.addCommandListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getCommand() == cm1) {
                         AfficheAccessoires af = new AfficheAccessoires();
                          try {
                              af.start(idmag,nom);
                          } catch (IOException ex) {
                              System.out.println("erreur av");                          }
                      
                    }
                }
            });
        } catch (IOException ex) {

        }
                           ServiceAvis serviceacc=new ServiceAvis();
        ArrayList<Avis> list = serviceacc.getList2(idmag);
                for (Avis a: list)  {
                    
                            Container c = new Container(BoxLayout.x());
                           Container c1 = new Container(BoxLayout.y());
        Container containervide = new Container(BoxLayout.x());
  
         
                        
                     Label l = new Label("User : ");
        l.getAllStyles().setFgColor(0x778899);
        c1.add(l);
          SpanLabel l2 = new SpanLabel(valueOf(a.getRating()+"."));
        l2.getAllStyles().setFgColor(0xFFFF00);
        
          SpanLabel l3 = new SpanLabel(valueOf(a.getCommentaire()));
        l2.getAllStyles().setFgColor(0x000000);
        
         c.setWidth(500);
        c.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        c.getUnselectedStyle().setBackgroundGradientEndColor(0xeae4e4);
        c.getUnselectedStyle().setBackgroundGradientStartColor(0xeae4e4);
         c1.setWidth(500);
        c1.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        c1.getUnselectedStyle().setBackgroundGradientEndColor(0xeae4e4);
        c1.getUnselectedStyle().setBackgroundGradientStartColor(0xeae4e4);
        
        containervide.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        containervide.getUnselectedStyle().setBackgroundGradientEndColor(0xFFFFFF);
        containervide.getUnselectedStyle().setBackgroundGradientStartColor(0xFFFFFF);
        
        c.add(l2);
        c.add(l3);
        f.add(c1);
        f.add(c);
        f.add(containervide);

                    
     
                
              }  
                        
                  
                        
                        
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
