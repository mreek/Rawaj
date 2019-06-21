package com.example.android.myapplication.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.android.myapplication.utils.MYSQLiteOpenHelper;

public class AccesLocal
{

     // propriétés
    private String nomBase = "dbCoach.sqlite";
    private Integer VersionBase = 1;
    private MYSQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;


    /**
     * constructeur
     * @param context
     */
    private AccesLocal(Context context){

    accesBD = new MYSQLiteOpenHelper(context,nomBase,null,VersionBase);


    }

    /**
     * ajout d'une annonceold dans la base de donnee pour lafficher au favoris
     *
     * @param annonceold
     * @param compte
     * @param sous_categorie
     * @param categorie
     */
    public void ajout(Annonceold annonceold, Compte compte, sous_Categorie sous_categorie, Categorie categorie){

    bd = accesBD.getWritableDatabase();

        String req = "Insert into favoris(id_annonce) values";
        req += "(" + annonceold.getId_annonce()+ ",";
/*

        String req = "Insert into favoris(id_annonce,id_compte,id_souscategorie,id_categorie) values";
            req += "(" +annonceold.getId_annonce()+ "," +compte.getId_compte()+ "," +sous_categorie.getId_souscategorie()+ "," +categorie.getId_categorie()+  ",";
*/

            // if we add date its gonna be a String , and we need to add "" but within the string not in the request
        //   \"

     bd.execSQL(req);

    }


  public Annonceold recup(){
      bd = accesBD.getReadableDatabase();
      Annonceold annonceold = null;
      String req = "select * from annonce";
      Cursor cursor = bd.rawQuery(req,null);

      // not sure if we must initialise the cursor position , TODO : test this
      cursor.moveToFirst();

      while( !cursor.isLast()){

          Integer id_annonce = cursor.getInt(0  );
         // Integer id_compte = cursor.getInt(1  );
          //Integer id_souscategorie = cursor.getInt(2  );
          //Integer id_categorie = cursor.getInt(3  );


            //annonceold = new Annonceold(id_annonce);






      }
      //  annonceold =new Annonceold(id_annonce);
      // now that we're done lets just close the cursor
        cursor.close();
        return annonceold;
  }


}
