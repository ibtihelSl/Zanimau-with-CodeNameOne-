/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.Entities;

/**
 *
 * @author ci
 */
public class Assurance {
    private int id;
    private String nom;
        private String adresse;
    private String mail;
    private String description;
       // private int age_de_ce_animal;
   // private String type_de_ce_animal;
    private Double totalprix;
   private Double prixparanimaux;

    public Assurance() {
    }

    public Assurance(int id, String nom, String adresse, String mail, String description, Double totalprix, Double prixparanimaux) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.description = description;
       // this.age_de_ce_animal = age_de_ce_animal;
        //this.type_de_ce_animal = type_de_ce_animal;
        this.totalprix = totalprix;
        this.prixparanimaux = prixparanimaux;
    }
     public Assurance(int id, String nom, String adresse, String mail, String description, Double prixparanimaux) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.description = description;
        
        this.prixparanimaux = prixparanimaux;
    }
      public Assurance( String nom, String adresse, String mail, String description, Double prixparanimaux) {
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.description = description;
        
        this.prixparanimaux = prixparanimaux;
    }
      public Assurance(int id, Double totalprix) {
        this.id = id;
      
        this.totalprix = totalprix;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  

    public Double getTotalprix() {
        return totalprix;
    }

    public void setTotalprix(Double totalprix) {
        this.totalprix = totalprix;
    }

    public Double getPrixparanimaux() {
        return prixparanimaux;
    }

    public void setPrixparanimaux(Double prixparanimaux) {
        this.prixparanimaux = prixparanimaux;
    }

    @Override
    public String toString() {
        return "Assurance{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", mail=" + mail + ", description=" + description + ", totalprix=" + totalprix + ", prixparanimaux=" + prixparanimaux + '}';
    }


    
}
