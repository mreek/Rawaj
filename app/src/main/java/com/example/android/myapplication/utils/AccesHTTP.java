package com.example.android.myapplication.utils;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AccesHTTP extends AsyncTask<String, Integer, Long> {

    private ArrayList<NameValuePair> paramettres;
    private String ret=null;
    public   AsyncResponse delegate=null;

    public AccesHTTP(){
   paramettres= new ArrayList<NameValuePair>();
    }
  public void addParam(String nom, String valeur){
        paramettres.add(new BasicNameValuePair(nom, valeur));

  }

    @Override
    protected Long doInBackground(String... strings) {
        HttpClient cnxHttp= new DefaultHttpClient();
        HttpPost paramcnx= new HttpPost(strings[0]);

        try {
            paramcnx.setEntity(new UrlEncodedFormEntity(paramettres));

            HttpResponse reponse=cnxHttp.execute(paramcnx);

            ret= EntityUtils.toString(reponse.getEntity());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Long result){

        delegate.processFinish(ret.toString());
    }
}
