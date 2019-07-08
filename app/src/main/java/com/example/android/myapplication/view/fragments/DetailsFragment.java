package com.example.android.myapplication.view.fragments;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.myapplication.R;
import com.example.android.myapplication.adapter.FasesLunaresAdapter;
import com.example.android.myapplication.newmodels.FaseLunar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class DetailsFragment extends Fragment {

    private ArrayList<FaseLunar> mList;

    public static DetailsFragment newInstance() {
        DetailsFragment fragment = new DetailsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mFragment = inflater.inflate(R.layout.fragment_details, container, false);

        //    View mFragment = inflater.inflate(R.layout.main_fragment, null);
        ListView mLista = (ListView) mFragment.findViewById(R.id.listView1);
        mLista.setAdapter(getFasesLunaresAdapter());



        mLista.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Removed from favorites, ID : " + id,
                        Toast.LENGTH_LONG).show();


                try{
                    JSONArray favorites;
                    Log.d("FAVORITE", "FilesDir : " + getContext().getFilesDir().getAbsolutePath());
                    File file = new File(getContext().getFilesDir(), "favorites.json");

                    if(file.exists()){
                        LineNumberReader r = new LineNumberReader(new FileReader(file));
                        String result = "";
                        while(r.ready()){
                            result += r.readLine();
                        }
                        r.close();
                        favorites = new JSONArray(result);
                    } else {
                        file.createNewFile();
                        favorites = new JSONArray();
                    }


                    Log.d("FAVORITE", "Adding " + id + "to : " + favorites);

                    JSONArray tmpFav = new JSONArray();
                    for(int i = 0; i < favorites.length(); i++){
                        if(favorites.getInt(i) != id) tmpFav.put(favorites.getInt(i));
                    }

                    Log.d("FAVORITES", "onItemClick: " + favorites.toString());

                    Writer output = null;
                    output = new BufferedWriter(new FileWriter(file));
                    output.write(favorites.toString());
                    output.close();

                } catch (JSONException e) {
                    Log.d("Favorites exception", "JSON exception");
                } catch (IOException e) {
                    Log.d("Favorites exception", "IOException");
                }

//                String s=al.get(position);
//                MainActivity mn1 =(MainActivity) getActivity();
//                mn1.fl(s);

            }
        });



        return mFragment;
    }

    private FasesLunaresAdapter getFasesLunaresAdapter() {

        mList = getFaseLunarFavoritesItems();
        return new FasesLunaresAdapter(mList, getActivity(), FasesLunaresAdapter.ADAPTER_MODE_LISTVIEW, true);
    }

    private ArrayList<FaseLunar> getFaseLunarFavoritesItems() {
        ArrayList<FaseLunar> favoritesItems = new ArrayList<>();
        JSONArray favorites = new JSONArray();
        try {
            File file = new File(getContext().getFilesDir(), "favorites.json");

            if (file.exists()) {
                LineNumberReader r = new LineNumberReader(new FileReader(file));
                String result = "";
                while (r.ready()) {
                    result += r.readLine();
                }
                r.close();
                favorites = new JSONArray(result);
            } else {
                file.createNewFile();
                favorites = new JSONArray();
            }
        }catch(Exception e){
            Log.e("Error", "getFaseLunarItems: ");
        }

        ArrayList<FaseLunar> items = getFaseLunarItems();

        Log.d("FAVORITE", favorites.toString());

        for(FaseLunar item : items){
            for(int i = 0; i < favorites.length(); i++){
                try {
                    if (item.getId() == favorites.getInt(i)) favoritesItems.add(item);
                }catch (Exception e){
                    Log.d("FAVORITE", "Loading exception");
                }
            }
        }

        return favoritesItems;

    }
    public ArrayList<FaseLunar> getFaseLunarItems() {
        ArrayList<FaseLunar> mFaseLunar = new ArrayList<FaseLunar>();
        //Method with JSON
        try {
            JSONObject data = new JSONObject(loadJSONFromAsset());
            JSONArray faselunar = data.getJSONArray("records");
            for (int i = 0; i < faselunar.length(); i++) {
                JSONObject object = faselunar.getJSONObject(i);
                int id = object.getInt("id_annonce");
                String mDrawableName = object.getString("photo_principale");
                int resID = getResources().getIdentifier(mDrawableName,"drawable",getContext().getPackageName());
                String mDescription = object.getString("description");
                String mAlias = object.getString("prix");
                String mFase = object.getString("titre_annonce");
                String ville = object.getString("id_quartier");
                String date = object.getString("date");
                String heure = object.getString("heure");
                String state = object.getString("etat");
                String description = object.getString("description");
                FaseLunar FL = new FaseLunar(id, resID,mDrawableName,mFase,mAlias,mDescription,ville,date,heure,state,description);
                mFaseLunar.add(FL);
            }
        } catch(JSONException e){
            e.printStackTrace();
        }
        return mFaseLunar;
    }//getFaseLunarItems

    //JSON Handler Best Practice
    private String loadJSONFromAsset(){
        String json = null;
        AssetManager assetManager = getContext().getAssets();
        try{
            InputStream IS = assetManager.open("Annances.json");
            int size = IS.available();
            byte[] buffer = new byte[size];
            IS.read(buffer);
            IS.close();
            json = new String(buffer,"UTF-8");

        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}
