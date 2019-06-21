package com.example.android.myapplication.model;

import android.util.Log;

import com.example.android.myapplication.utils.AccesHTTP;
import com.example.android.myapplication.utils.AsyncResponse;

import org.json.JSONArray;
public class AccesDistant{

/*


public class AccesDistant implements AsyncResponse {

    private static final String SERVERADDR = "http://192.168.182.1/api/product/read.php";

    public AccesDistant(){
        super();
    }
    @Override
    public void processFinish(String output) {
         Log.d("serveur", "****************"+output);
        String[] msg= output.split("%");

        if (msg.length>1){
            if (msg[0].equals("enreg"));
            Log.d("enreg", "****************"+msg[1]);
        }else
        {
            if(msg[0].equals("dernier")){
                Log.d("dernier", "****************"+msg[1]);

            }else{
                if (msg[0].equals("Erreur")){
                    Log.d("Erreur", "****************"+msg[1]);

                }
            }
        }
    }
    public void envoi(String operation , JSONArray lesDonnesJSON){
        AccesHTTP accesDonnes=new AccesHTTP();
        accesDonnes.delegate=this;

        accesDonnes.addParam("operation", operation);
        accesDonnes.addParam("lesdonnes", lesDonnesJSON.toString());
        accesDonnes.execute(SERVERADDR);
    }
}
*/
}