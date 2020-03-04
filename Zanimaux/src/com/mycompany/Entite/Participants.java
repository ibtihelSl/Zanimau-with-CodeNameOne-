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
public class Participants {
    
    
    private int id;
    private String titre;
    private SimpleDateFormat dateDebut;
    private String participant;
    private String adresse;
     private int ide;
      private int idu;

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
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

    public SimpleDateFormat getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(SimpleDateFormat dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
}
