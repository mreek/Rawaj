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
public class Quartier {
    private int id_quartier;
    private String nom_quartier;
    private Ville ville;

    public Quartier(){

    }
    public Quartier(int id_quartier, String nom_quartier, int id_ville) {
        super();
        this.id_quartier = id_quartier;
        this.nom_quartier = nom_quartier;
        setVille(new Ville());

    }

    public int getId_quartier() {
        return id_quartier;
    }

    public String getNom_quartier() {
        return nom_quartier;
    }

    public Ville getVille() {
        return ville;
    }

    public void setId_quartier(int id_quartier) {
        this.id_quartier = id_quartier;
    }

    public void setNom_quartier(String nom_quartier) {
        this.nom_quartier = nom_quartier;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }


}

