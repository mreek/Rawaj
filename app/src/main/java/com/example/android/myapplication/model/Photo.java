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
public class Photo {

    private int id_photo;
    private String chemin;
    private Annonceold annonceold;
    public Photo(){

    }

    public Photo(int id_photo, String chemin, int id_annonce) {
        super();
        this.id_photo = id_photo;
        this.chemin = chemin;
        setAnnonceold(new Annonceold());
    }

    public int getId_photo() {
        return id_photo;
    }

    public String getChemin() {
        return chemin;
    }

    public Annonceold getAnnonceold() {
        return annonceold;
    }

    public void setId_photo(int id_photo) {
        this.id_photo = id_photo;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public void setAnnonceold(Annonceold annonceold) {
        this.annonceold = annonceold;
    }

    @Override
    public String toString() {
        return "Photo{" + "id_photo=" + id_photo + ", chemin=" + chemin + ", annonceold=" + annonceold + '}';
    }


}

