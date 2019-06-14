package com.example.android.myapplication.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author khadija bennouna
 */
public class Ville {
    private int id_ville;
    private String nom_ville;
    private Region region;
    private int population;

    public Ville() {
    }

    public Ville(int id_ville, String nom_ville, int idR, int population) {
        super();
        this.id_ville = id_ville;
        this.nom_ville = nom_ville;
        setRegion(new Region());
        this.population = population;
    }

    public int getId_ville() {
        return id_ville;
    }

    public String getNom_ville() {
        return nom_ville;
    }

    public Region getRegion() {
        return region;
    }

    public int getPopulation() {
        return population;
    }

    public void setId_ville(int id_ville) {
        this.id_ville = id_ville;
    }

    public void setNom_ville(String nom_ville) {
        this.nom_ville = nom_ville;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Ville{" + "id_ville=" + id_ville + ", nom_ville=" + nom_ville + ", region=" + region + ", population=" + population + '}';
    }


}

