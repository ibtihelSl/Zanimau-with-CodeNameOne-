/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.notifications.LocalNotification;
import com.codename1.social.FacebookConnect;
import com.codename1.social.Login;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceEvent;
import com.mycompany.Entite.Event;
import com.mycompany.Entite.User;
import static com.mycompany.Entite.User.connectedUser;
import java.util.ArrayList;

/**
 * A simple details form
 *
 * @author Shai Almog
 */
public class TestForm extends com.codename1.ui.Form {

    ImageViewer imageViewer;
    EncodedImage imgEncodedimage; //recuperer une image stocké dans un serveur 
    URLImage urlImage;

    public TestForm () {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public TestForm (com.codename1.ui.util.Resources resourceObjectInstance) {
        setToolbar(new Toolbar(true));
        initGuiBuilderComponents(resourceObjectInstance);
        Form last = Display.getInstance().getCurrent();
        getToolbar().setBackCommand("", e -> last.show());
    }

//-- DON'T EDIT BELOW THIS LINE!!!
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
         //use your own facebook app identifiers here   
                //These are used for the Oauth2 web login process on the Simulator.
                String clientId = "946530208839031";
                String redirectURI = "https://google.com/";
                String clientSecret = "d17b5717cd68dc2d2155398fdda56be2";
                Login fb = FacebookConnect.getInstance();
                fb.setClientId(clientId);
                fb.setRedirectURI(redirectURI);
                fb.setClientSecret(clientSecret);
                //Sets a LoginCallback listener
//                fb.setCallback();
                //trigger the login if not already logged in
                
                
                    accueilConnectedController hom = new accueilConnectedController();
                    hom.getF();
                
                if(!fb.isUserLoggedIn()){
                    fb.doLogin();
                }else{
                    //get the token and now you can query the facebook API
                    String token = fb.getAccessToken().getToken();
                      
                }
                
        
         
//            LocalNotification ln= new LocalNotification();
//             ln.setId("LnMessage");
//            ln.setAlertTitle("Welcome");
//            ln.setAlertBody("Thanks for arriving!");
//            Display.getInstance().scheduleLocalNotification(ln,10,  LocalNotification.REPEAT_NONE);

    }

    public void start(int id) {

        Resources theme = UIManager.initFirstTheme("/theme");
        setLayout(new com.codename1.ui.layouts.FlowLayout());

         
        this.show();
    }
//-- DON'T EDIT ABOVE THIS LINE!!!
}
