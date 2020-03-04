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
public class Magasin {
     private int id;
   private String nom;
   private String addresse;
   private String ville;
   private String phone;

    public Magasin() {
    }

    public Magasin(String nom, String addresse, String ville, String phone) {
        this.nom = nom;
        this.addresse = addresse;
        this.ville = ville;
        this.phone = phone;
    }
    
    

    public Magasin(int id, String nom, String addresse, String ville, String phone) {
        this.id = id;
        this.nom = nom;
        this.addresse = addresse;
        this.ville = ville;
        this.phone = phone;
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

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Magasin{" + "id=" + id + ", nom=" + nom + ", addresse=" + addresse + ", ville=" + ville + ", phone=" + phone + '}';
    }
   
   
    
}
