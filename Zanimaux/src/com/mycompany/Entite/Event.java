/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import com.codename1.l10n.SimpleDateFormat;

/**
 *
 * @author abdelaziz
 */
public class Event {

    private int id;
    private String titre;
    private String adresse;
    private SimpleDateFormat date_debut;
    private SimpleDateFormat date_fin;
    private String type;
    private int nombre_place;
    private String details;
    private int nombre_reserve;
    private String db;
    private String df;

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getDf() {
        return df;
    }

    public void setDf(String df) {
        this.df = df;
    }

    public int getNombre_reserve() {
        return nombre_reserve;
    }

    public void setNombre_reserve(int nombre_reserve) {
        this.nombre_reserve = nombre_reserve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public SimpleDateFormat getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(SimpleDateFormat date_debut) {
        this.date_debut = date_debut;
    }

    public SimpleDateFormat getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(SimpleDateFormat date_fin) {
        this.date_fin = date_fin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNombre_place() {
        return nombre_place;
    }

    public void setNombre_place(int nombre_place) {
        this.nombre_place = nombre_place;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", titre=" + titre + ", adresse=" + adresse + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", type=" + type + ", nombre_place=" + nombre_place + ", details=" + details + '}';
    }
    

}
