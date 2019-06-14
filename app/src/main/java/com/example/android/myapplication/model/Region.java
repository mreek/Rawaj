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
public class Region {
    private int idR;
    private String nom_region;

    public Region() {
    }

    public Region(int idR, String nom_region) {
        this.idR = idR;
        this.nom_region = nom_region;
    }

    public int getIdR() {
        return idR;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
    }



}

