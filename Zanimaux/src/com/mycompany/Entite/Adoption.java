/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author souad
 */
public class Adoption {
    private int id;
    private String espece;
    private int fk_post;
    private int user_id;
    private String nomprop;
    private float prix;

    public Adoption() {
    }

    public int getId() {
        return id;
    }

    public String getEspece() {
        return espece;
    }

    public int getFk_post() {
        return fk_post;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getNomprop() {
        return nomprop;
    }

    public float getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adoption other = (Adoption) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Adoption{" + "id=" + id + ", espece=" + espece + ", fk_post=" + fk_post + ", user_id=" + user_id + ", nomprop=" + nomprop + ", prix=" + prix + '}';
    }
    

    public void setFk_post(int fk_post) {
        this.fk_post = fk_post;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setNomprop(String nomprop) {
        this.nomprop = nomprop;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    
    
}
