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
public class Categorie {
    private int id_categorie;
    private String nom_categorie;
    private int nb_annonce;

    public Categorie() {
    }


    public Categorie(int id_categorie, String nom_categorie, int nb_annonce) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.nb_annonce = nb_annonce;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public int getNb_annonce() {
        return nb_annonce;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public void setNb_annonce(int nb_annonce) {
        this.nb_annonce = nb_annonce;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_categorie=" + id_categorie + ", nom_categorie=" + nom_categorie + ", nb_annonce=" + nb_annonce + '}';
    }



}

