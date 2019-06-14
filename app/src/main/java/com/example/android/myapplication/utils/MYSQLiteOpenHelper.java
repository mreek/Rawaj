package com.example.android.myapplication.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MYSQLiteOpenHelper extends SQLiteOpenHelper {


    // propriétés
    private String creation ="CREATE TABLE favoris ("
                   +" id_annonce int PRIMARY KEY ,"
                   +" id_compte int NOT NULL,"
                   +" id_souscategorie int NOT NULL,"
                   +" id_categorie int NOT NULL ,";
    // + date TEXT NOT NULL,  // maybe we'll need the date for now i think id_annonce is just enough to go




    /**
     * contructeur
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MYSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    /**
     *  si changement de base de donnee
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(creation);

    }

    /** si changement de version
     *
     * @param db
     * @param oldVersion   numero d'encienne version
     * @param newVersion    nouvelle version
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
