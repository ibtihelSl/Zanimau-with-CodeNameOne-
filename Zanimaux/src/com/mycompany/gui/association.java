/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceAssociation;

import com.mycompany.Entite.Association;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author abdelaziz
 */
public class association {
    
     private Form f;
    private Resources theme;
     private Container C1, C2;
 
    SpanLabel lb, lb1, lb2,lb3,lb4,lb5;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }

    public void start() {
         f = new Form("Associations", new BoxLayout(BoxLayout.Y_AXIS));
          
          Command cm5 = new Command("Logout");  
        
         f.getToolbar().addCommandToRightBar(cm5);
         
         
          
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

                    ServiceAssociation serviceev = new ServiceAssociation();
                    ArrayList<Association> lis = serviceev.getList3();
                    for (Association li : lis) {
                        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        Container c1 = new Container(BoxLayout.x());
                        Container c2 = new Container(BoxLayout.x());
                        Container c3 = new Container(BoxLayout.x());
                        Container c4 = new Container(BoxLayout.x());
                        Container c5 = new Container(BoxLayout.x());
                        Container c6 = new Container(BoxLayout.x());

                        Label l1= new Label("Name : ");
                        l1.getAllStyles().setFgColor(0xA52A2A); 
                        lb = new SpanLabel(li.getName());
                       
                      
                        
                         Label l2= new Label("Adresse : ");
                        l2.getAllStyles().setFgColor(0xA52A2A); 
                        lb1 = new SpanLabel(li.getAdress());
                        
                        
                        Label l3= new Label("Phone : ");
                        l3.getAllStyles().setFgColor(0xA52A2A); 
                        lb3 = new SpanLabel(li.getPhone());
                      
                        
                         
                        Label l4= new Label("Email : ");
                        l4.getAllStyles().setFgColor(0xA52A2A); 
                        lb4 = new SpanLabel(li.getEmail());
                       
                        
                         Label l5= new Label("Description : ");
                        l5.getAllStyles().setFgColor(0xA52A2A); 
                         lb5 = new SpanLabel(li.getDescription());
                         
                        ImageViewer imgv1 = new ImageViewer();
                        try {

                           Image img1 = Image.createImage("/bande-coloree.jpg");
                          c.add(imgv1);
                          imgv1.setImage(img1);  
                        } catch (IOException ex) {    
                           }
                        
                        c1.add(l1);
                        c1.add(lb);
                        c.add(c1);
                        
                        c2.add(l2);
                        c2.add(lb1);
                         c.add(c2);
                        
                         c3.add(l3);
                        c3.add(lb3);
                          c.add(c3);
                        
                        c4.add(l4);
                        c4.add(lb4);
                        c.add(c4);
                        
                        c5.add(l5);
                        c5.add(lb5);
                         c.add(c5);
                        
                        
                       f.add(c);
                        
            
              
             f.addCommandListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getCommand() == cm5) {
                               accueilController affc = new accueilController();
                               affc.start();
                            }
                        }
                    });
                     
             f.show();

    }
    }
    public void stop() {
        f = Display.getInstance().getCurrent();
        if (f instanceof Dialog) {
            ((Dialog) f).dispose();
            f = Display.getInstance().getCurrent();
        }
    }

    public void destroy() {
    }

    
}
