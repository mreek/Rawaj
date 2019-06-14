package com.example.android.myapplication.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author khadija bennouna
 */
public class Annonce {
    private int id_annonce;
    private sous_Categorie souscategorie;
    private Quartier quartier;
    private String titre_annonce;
    private String description;
    private double prix;
    private String photo_principale;
    private Date date;
    private Time heure;
    private int vues;
    private Compte compte;
    private String etat;

    public Annonce(){

    }

    public Annonce(int id_annonce, int id_souscategorie, int  id_quartier, String titre_annonce, String description, double prix, String photo_principale, Date date, Time heure, int vues, int id_compte, String etat) {
        super();
        this.id_annonce = id_annonce;
        setSouscategorie(new sous_Categorie());
        setQuartier(new Quartier());
        this.titre_annonce = titre_annonce;
        this.description = description;
        this.prix = prix;
        this.photo_principale = photo_principale;
        this.date = date;
        this.heure = heure;
        this.vues = vues;
        setCompte(new Compte());
        this.etat = etat;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public sous_Categorie getSouscategorie() {
        return souscategorie;
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public String getTitre_annonce() {
        return titre_annonce;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    public String getPhoto_principale() {
        return photo_principale;
    }

    public Date getDate() {
        return date;
    }

    public Time getHeure() {
        return heure;
    }

    public int getVues() {
        return vues;
    }

    public Compte getCompte() {
        return compte;
    }

    public String getEtat() {
        return etat;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public void setSouscategorie(sous_Categorie souscategorie) {
        this.souscategorie = souscategorie;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }

    public void setTitre_annonce(String titre_annonce) {
        this.titre_annonce = titre_annonce;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setPhoto_principale(String photo_principale) {
        this.photo_principale = photo_principale;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public void setVues(int vues) {
        this.vues = vues;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id_annonce=" + id_annonce + ", souscategorie=" + souscategorie + ", quartier=" + quartier + ", titre_annonce=" + titre_annonce + ", description=" + description + ", prix=" + prix + ", photo_principale=" + photo_principale + ", date=" + date + ", heure=" + heure + ", vues=" + vues + ", compte=" + compte + ", etat=" + etat + '}';
    }

    public JSONArray convertToJSONArray(){
        List l=new ArrayList();
        l.add(id_annonce);
        l.add(souscategorie);
        l.add(quartier);
        l.add(titre_annonce);
        l.add(description);
        l.add(prix);
        l.add(photo_principale);
        l.add(date);
        l.add(heure);
        l.add(vues);
        l.add(compte);
        l.add(etat);

        return new JSONArray(l);
    }


}
