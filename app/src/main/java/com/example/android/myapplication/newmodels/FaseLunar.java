package com.example.android.myapplication.newmodels;

/**
 * Created by Sacha on 04/10/2017.
 */

public class FaseLunar {

    private int recursoImagen;
    private String imageURL;
    private String nombre;
    private String nombreAlternativo;
    private String descripcion;
    private String ville;
    private String heure;
    private String date;
    private String state;
    private String description;



    public FaseLunar(int imgRes, String imageURL, String n, String altN,String desc, String vil, String houre, String dat, String etat,String descr){
        recursoImagen = imgRes;
        this.imageURL = imageURL;
        nombre = n;
        nombreAlternativo = altN;
        descripcion = desc;
        ville = vil;
        heure = houre;
        date = dat;
        state = etat;
        description =  descr;
    }

    public FaseLunar(String imageURL, String n, String altN,String desc, String vil, String houre, String dat, String etat,String descr){
        recursoImagen = 0;
        this.imageURL = imageURL;
        nombre = n;
        nombreAlternativo = altN;
        descripcion = desc;
        ville = vil;
        heure = houre;
        date = dat;
        state = etat;
        description =  descr;
    }

    public int getImageResource() {
        return recursoImagen;
    }

    public String getImageURL() { return imageURL; }

    public String getVille() {
        return ville;
    }

    public String getName() {
        return nombre;
    }

    public String getAltName() {
        return nombreAlternativo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHeure() {
        return heure;
    }

    public String getDate() {
        return date;
    }

    public String getState() {
        return state;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        return "FaseLunar{" +
                "recursoImagen=" + recursoImagen +
                ", imageURL='" + imageURL + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nombreAlternativo='" + nombreAlternativo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ville='" + ville + '\'' +
                ", heure='" + heure + '\'' +
                ", date='" + date + '\'' +
                ", state='" + state + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
