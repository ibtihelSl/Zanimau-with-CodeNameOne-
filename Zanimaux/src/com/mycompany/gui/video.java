/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.GUI;

import Admin.*;
import com.codename1.components.MediaPlayer;
import com.codename1.io.Log;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Command;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.io.IOException;

/**
 *
 * @author ci
 */
public class video {
    int article_id;
         public void start() {

   final Form hi = new Form("Ajouter video Article", new BorderLayout());
hi.setToolbar(new Toolbar());
Style s = UIManager.getInstance().getComponentStyle("Title");
FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_VIDEO_LIBRARY, s);
hi.getToolbar().addCommandToRightBar(new Command("", icon) {
    @Override
    public void actionPerformed(ActionEvent evt) {
        Display.getInstance().openGallery((e) -> {
            if(e != null && e.getSource() != null) {
                String file = (String)e.getSource();
                try {
                    Media video = MediaManager.createMedia(file, true);
                    hi.removeAll();
                    hi.add(BorderLayout.CENTER, new MediaPlayer(video));
                    hi.revalidate();
                } catch(IOException err) {
                    Log.e(err);
                } 
            }
        }, Display.GALLERY_VIDEO);
    }
});


           hi.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent evt) {
                     AffichageArticle  af = new AffichageArticle ();
                      af.start(article_id);
                      }
                  });
           
hi.show();
    
}}
