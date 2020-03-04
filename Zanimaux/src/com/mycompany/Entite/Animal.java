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
public class Animal {

    private int id;
    private String nom_a;
    private String race;
    private int age;
    private Double poids;

    private String nom_image;

    public Animal() {
    }

    public Animal(int id, String nom_a, String race, int age, double poids, String nom_image) {
        this.id = id;
        this.nom_a = nom_a;
        this.race = race;
        this.age = age;
        this.poids = poids;
        this.nom_image = nom_image;
    }

    public Animal(String espece, int age, double poids, String race, String nom_image) {

        this.nom_a = espece;
        this.race = race;
        this.age = age;
        this.poids = poids;
        this.nom_image = nom_image;
    }

    public Animal(int id, String espece, int age, double p, String r) {

        this.id = id;
        this.nom_a = espece;
        this.race = r;
        this.age = age;
        this.poids = p;
    }

    public Animal(String espece, String race, int age, double poids) {
        this.nom_a = espece;
        this.race = race;
        this.age = age;
        this.poids = poids;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_a(String nom_a) {
        this.nom_a = nom_a;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nom_a=" + nom_a + ", race=" + race + ", age=" + age + ", poids=" + poids + ", nom_image=" + nom_image + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
        return hash;
    }

    public int getId() {
        return id;
    }

    public String getNom_a() {
        return nom_a;
    }

    public String getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }

    public double getPoids() {
        return poids;
    }

    public String getNom_image() {
        return nom_image;
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
        final Animal other = (Animal) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
