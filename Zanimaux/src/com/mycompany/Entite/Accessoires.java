/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.Entite;

/**
 *
 * @author Touha
 */
public class Accessoires {
   private int id;
   private String nom;
   private Float prix;
   private String image_name;
   private String espece;
   private int id_magasin;

    public Accessoires() {
    }

    public Accessoires(int id,String nom, Float prix, String espece, String image_name) {
                this.id = id;

        this.nom = nom;
        this.prix = prix;
        this.image_name = image_name;
        this.espece = espece;
    }
    
    

    public Accessoires(String nom, Float prix, String espece, int id_magasin,String image) {
        this.nom = nom;
        this.prix = prix;
        this.espece = espece;
        this.id_magasin = id_magasin;
        this.image_name = image;

    }

    
    public Accessoires(int id, String nom, Float prix, String image, String espece, int id_magasin) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.image_name = image;
        this.espece = espece;
        this.id_magasin = id_magasin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image_name;
    }

    public void setImage(String image) {
        this.image_name = image;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public int getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(int id_magasin) {
        this.id_magasin = id_magasin;
    }

    @Override
    public String toString() {
        return "Accessoires{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", image=" + image_name + ", espece=" + espece + ", id_magasin=" + id_magasin + '}';
    }
   
    
}
