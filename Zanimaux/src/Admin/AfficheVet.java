/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import com.codename1.components.ImageViewer;
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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.Entities.Veterinaires;
import com.mycompagny.Service.CrudVeterinaire;
import com.mycompany.gui.accueilAdminController;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ci
 */
public class AfficheVet {
        private Form current;
        String n;

          Form f;
        SpanLabel lb;
          //Label lb;
private ImageViewer imgv;
    private Image img;
    private EncodedImage enc;
    public void start() {
        
        
        
        
       /*   CrudVeterinaire Es=new CrudVeterinaire();
        for (Veterinaires a : Es.getList2()){
            lb = new Label("");
            Image placeholder = Image.createImage(500, 170);
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            URLImage imgUrl = URLImage.createToStorage(encImage, "http://localhost/web/images/" + a.getNom_image(), "http://localhost/web/images/" + a.getNom_image());
            ImageViewer img1 = new ImageViewer(imgUrl);
      
            System.out.println(a.getNom_image());
            
                lb.setText(a.getNom());
            //    lb2.setText(Es.getListCabinet2().get(i).getSpecialite().toString());
        Container c1 = new Container(BoxLayout.y());
            System.out.println(a.getNom_image());

             Button ajout = new Button("Ajouter un veterinaire");

        ajout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AjoutVet modifmag=new  AjoutVet();
            modifmag.start();

           
        }});
                c1.add(ajout);

            c1.add(lb);
            c1.add(img1);
                                                                f.add(c1);

                     
        }

        f.show();
        
    
}
*/
                        f = new Form("Veterinaires",BoxLayout.y());
                              try {
            Command cm1 = new Command("");
            Image img1 = Image.createImage("/BACK2_26880 (2).png");
            cm1.setIcon(img1);
            f.getToolbar().addCommandToLeftBar(cm1);
            f.addCommandListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getCommand() == cm1) {
                          accueilAdminController mc = new accueilAdminController();
                                    mc.start();
                    }
                }
            });
        } catch (IOException ex) {

        }
             
                              CrudVeterinaire servicemagain=new CrudVeterinaire();
  
     

                 ArrayList<Veterinaires> listMagasin = servicemagain.getList2();

                                for(Veterinaires m : listMagasin){
                                    Container finishLandingPage = new Container(BoxLayout.x());
            Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container containervide = new Container(BoxLayout.x());
        Label spaceLabel0 = new Label(" ");
        Label spaceLabel2 = new Label(" ");
        containervide.add(spaceLabel0);
        containervide.add(spaceLabel2);

     
    Button ajout = new Button("Ajouter un veterinaire");

        ajout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AjoutVet modifmag=new  AjoutVet();
            modifmag.start(n);

           
        }});
        
        

        Button modif = new Button("Modifier un veterinaire");

        modif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ModifVet modifmag=new  ModifVet();
            modifmag.start(m.getId(),m.getNom(),m.getAddress(),m.getVille(),m.getPhone(),m.getEmail());

           
        }});
        
       int id=m.getId();
     Button Delete = new Button("Supprimer un veterinaire");

        Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            servicemagain.suppVet(id);
          Dialog.show("suppression", "Veterinaire "+m.getNom()+m.getAddress()+m.getVille()+m.getPhone()+m.getEmail()+"a été Supprimer" ,"Ok", null);

          start();

           
        }});
      /*  Button Assur = new Button("List des assurances");

        Assur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AfficheAssurance modifmag=new  AfficheAssurance();
            modifmag.start();

           
        }});
        */
           Button Article = new Button("List des articles");

        Article.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AfficheArticle modifmag=new  AfficheArticle();
            modifmag.start();

           
        }});
        
      
          
         Image placeholder = Image.createImage(200, 100);
            EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
      //   URLImage img1 = URLImage.createToStorage(enc , "imkkhaf" + m, "http://localhost/symfony3/web/images/" + m.getNom_image(), URLImage.RESIZE_SCALE);
        //       int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
          //           img1.fill(500, 100);
                            
        //finishLandingPage.add(img1.scaledWidth(150));
        
        Label l = new Label(m.getNom());
         
        l.getAllStyles().setFgColor(0xF69602);
        
        SpanLabel l2 = new SpanLabel(m.getAddress());
         l2.getAllStyles().setFgColor(0x000000);

        SpanLabel l3 = new SpanLabel( m.getVille());
      l3.getAllStyles().setFgColor(0x000000);

        SpanLabel l4 = new SpanLabel(  m.getPhone());
        
        l4.getAllStyles().setFgColor(0x000000)
                ;
      SpanLabel l5 = new SpanLabel(m.getEmail());
              l5.getAllStyles().setFgColor(0x000000);
              
             /* SpanLabel l6 = new SpanLabel(m.getNom_image());
              l6.getAllStyles().setFgColor(0x000000);*/

        c.add(l);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(ajout);
         c.add(modif);
        c.add(Delete);
//                c.add(Assur);
                
        c.add(Article);

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

        
          f.show();
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


