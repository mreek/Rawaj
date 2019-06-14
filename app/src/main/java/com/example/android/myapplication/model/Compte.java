package com.example.android.myapplication.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author khalfaoui saad
 */
public class Compte {
    private int id_compte;
    private String nom;
    private String password;
    private String telephone;
    private String email;
    private String codev;


    public Compte(){

    }

    public Compte(int id_compte, String nom, String password, String telephone, String email, String codev) {
        this.id_compte = id_compte;
        this.nom = nom;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.codev = codev;
    }

    public int getId_compte() {
        return id_compte;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getCodev() {
        return codev;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCodev(String codev) {
        this.codev = codev;
    }



    @Override
    public String toString() {
        return "compte_utilisateur{" + "id_compte=" + id_compte + ", nom=" + nom + ", password=" + password + ", telephone=" + telephone + ", email=" + email + ", codev=" + codev + '}';
    }




}

