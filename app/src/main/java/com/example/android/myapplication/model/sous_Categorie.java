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
public class sous_Categorie {
    private int id_souscategorie;
    private String nom_souscategorie;
    private Categorie categorie;
    private int nb_annonce;

    public sous_Categorie() {
    }

    public sous_Categorie(int id_souscategorie, String nom_souscategorie, int  id_categorie, int nb_annonce) {

        super();
        this.id_souscategorie = id_souscategorie;
        this.nom_souscategorie = nom_souscategorie;
        setCategorie(new Categorie());
        this.nb_annonce = nb_annonce;
    }

    public int getId_souscategorie() {
        return id_souscategorie;
    }

    public String getNom_souscategorie() {
        return nom_souscategorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public int getNb_annonce() {
        return nb_annonce;
    }

    public void setId_souscategorie(int id_souscategorie) {
        this.id_souscategorie = id_souscategorie;
    }

    public void setNom_souscategorie(String nom_souscategorie) {
        this.nom_souscategorie = nom_souscategorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setNb_annonce(int nb_annonce) {
        this.nb_annonce = nb_annonce;
    }

    @Override
    public String toString() {
        return "sous_Categorie{" + "id_souscategorie=" + id_souscategorie + ", nom_souscategorie=" + nom_souscategorie + ", categorie=" + categorie + ", nb_annonce=" + nb_annonce + '}';
    }




}

