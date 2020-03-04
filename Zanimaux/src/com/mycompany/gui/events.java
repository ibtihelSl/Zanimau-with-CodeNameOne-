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
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceEvent;
import com.mycompany.Entite.Event;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Said
 */
public class events {

    private Form f;
    private Resources theme;
     private Container C1, C2;
 
    SpanLabel lb, lb1;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }

    public void start() {
         f = new Form("Evenements", new BoxLayout(BoxLayout.Y_AXIS));
         
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

                    ServiceEvent serviceev = new ServiceEvent();
                    ArrayList<Event> lis = serviceev.getList2();
                    for (Event li : lis) {
                        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
Container c1 = new Container(BoxLayout.x());
                        
                        ImageViewer imgv1 = new ImageViewer();
               
                       try {

                           Image img1 = Image.createImage("/22.jpg");
                          c.add(imgv1);
                          imgv1.setImage(img1);  
                        } catch (IOException ex) {    
                           }
        

                       Label l1= new Label("Titre : ");
                       l1.getAllStyles().setFgColor(0xA52A2A);
                        lb = new SpanLabel(li.getTitre());
                        
                       
                   Label l2= new Label("Adresse : ");
                   l2.getAllStyles().setFgColor(0xA52A2A);

                        lb1 = new SpanLabel(li.getAdresse());
//                        lb1.setText());
                       
                         Button detail = new Button("Détails");
                         c1.add(l1);
                         c1.add(lb);
                        c.add(c1);
Container c2 = new Container(BoxLayout.x());

                        c2.add(l2);
                        c2.add(lb1);
                        c.add(c2);
                        c.add(detail);
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
              detail.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                       detail affc = new  detail();
                               affc.start(li.getId());
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
