package com.example.android.myapplication.view.fragments;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.myapplication.R;
import com.example.android.myapplication.newmodels.FaseLunar;
import com.example.android.myapplication.view.activity.MainActivity;
import com.example.android.myapplication.adapter.FasesLunaresAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

public class MainFragment extends Fragment {



    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;


    private ArrayList<FaseLunar> mList;
    private MainActivity mActivity;


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mFragment =inflater.inflate(R.layout.main_fragment, container, false);

    //    View mFragment = inflater.inflate(R.layout.main_fragment, null);
        ListView mLista = (ListView) mFragment.findViewById(R.id.listView1);
        mLista.setAdapter(getFasesLunaresAdapter());


        // lv = mFragment.findViewById(R.id.listView1);

        /*


        al =new ArrayList<String>();
        aa =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,al);
        lv.setAdapter(aa);
        al.add("first ad");
        al.add("second ad");
        al.add("third ad");
        al.add("fourth ad");
        al.add("fifth ad");
        al.add("sixth ad");
        al.add("second ad");
        al.add("third ad");
        al.add("fourth ad");
        al.add("fifth ad");
        al.add("sixth ad");
        al.add("second ad");
        al.add("third ad");
        al.add("fourth ad");
        al.add("fifth ad");
        al.add("sixth ad");
        al.add("second ad");
        al.add("third ad");
        al.add("fourth ad");
        al.add("fifth ad");
        al.add("sixth ad");
        al.add("second ad");
        al.add("third ad");
        al.add("fourth ad");
        al.add("fifth ad");
        al.add("sixth ad");
  */
        mLista.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            // TO-DO : show favorites page and display favorites by loading ids and searching in annonces' list

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Added to favorites, ID : " + id,
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
                    favorites.put(id);

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

        mList = getFaseLunarItems();
        return new FasesLunaresAdapter(mList, getActivity(), FasesLunaresAdapter.ADAPTER_MODE_LISTVIEW);
    }

    private ArrayList<FaseLunar> getFaseLunarItems() {
        return mActivity.getFaseLunarItems();
    }
}
