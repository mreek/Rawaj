package com.example.android.myapplication.view.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NoCache;
import com.example.android.myapplication.R;
import com.example.android.myapplication.newmodels.FaseLunar;
import com.example.android.myapplication.view.activity.MainActivity;
import com.example.android.myapplication.adapter.FasesLunaresAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainFragment extends Fragment {



    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;
    private ListView mLista;

    private final String API_URL = "http://192.168.2.14/api/annonce/read.php";

    private FasesLunaresAdapter fasesLunaresAdapter;

    private ArrayList<FaseLunar> mList = new ArrayList<>();
    private MainActivity mActivity;
    RequestQueue requestQueue;


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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Cache cache = new NoCache();

// Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);

// Start the queue
        requestQueue.start();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, API_URL, null, new Response.Listener<JSONObject>() {

            ArrayList<FaseLunar> result = new ArrayList<>();

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray faselunar = response.getJSONArray("records");
                    for (int i = 0; i < faselunar.length(); i++) {
                        JSONObject object = faselunar.getJSONObject(i);
                        String mDrawableName = object.getString("photo_principale");
                        String mDescription = object.getString("description");
                        String mAlias = object.getString("prix");
                        String mFase = object.getString("titre_annonce");
                        String ville = object.getString("id_quartier");
                        String date = object.getString("date");
                        String heure = object.getString("heure");
                        String state = object.getString("etat");
                        String description = object.getString("description");
                        FaseLunar FL = new FaseLunar(mDrawableName, mFase, mAlias, mDescription, ville, date, heure, state, description);
                        result.add(FL);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("RESPONSE", "onResponse: " + result.size());
                mList = result;
                fasesLunaresAdapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error

            }
        });
        requestQueue.add(jsonObjectRequest);
        fasesLunaresAdapter = getNewFasesLunaresAdapter();
        mLista.setAdapter(fasesLunaresAdapter);
//        new JsonTask().execute(API_URL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mFragment =inflater.inflate(R.layout.main_fragment, container, false);

    //    View mFragment = inflater.inflate(R.layout.main_fragment, null);
        mLista = (ListView) mFragment.findViewById(R.id.listView1);

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
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "open second fragment",
                        Toast.LENGTH_LONG).show();

                /*
                String s=al.get(position);
                MainActivity mn1 =(MainActivity) getActivity();
                mn1.fl(s);

*/
            }
        });


        return mFragment;
    }


    public ArrayList<FaseLunar> getFaseLunarItems(String JSONData) {
        ArrayList<FaseLunar> result = new ArrayList<>();
        //Method without JSON
       /* mFaseLunar.add(new FaseLunar(R.drawable.luna_nueva, "Luna nueva", "Novilunio", "Luna Nueva o Novilunio, también llamada \"Luna Nueva Astronómica\" o \"Luna Negra\", corresponde a la Luna Nueva Verdadera; esta fase de la Luna normalmente es imposible verla a simple vista ya que se encuentra oculta tras el resplandor solar, sólo es posible observarla cuando ocurre un eclipse total de Sol, los cuales acontecen durante esta fase lunar sólo cuando las condiciones dadas son las adecuadas."));
        mFaseLunar.add(new FaseLunar(R.drawable.creciente_iluminante, "Creciente iluminante", null, "Luna Creciente, también llamada Nueva Visible, corresponde a la Luna Nueva Tradicional y es la primera aparición de la Luna en el cielo, 18 o 30 horas después de haberse producido la posición de \"Luna Nueva Astronómica\". Esta fase de la Luna se podrá ver en el cielo hacia el oeste, una vez ya ocultado el Sol, justo por encima del crepúsculo aún restante. Tiene forma de pequeña guadaña o cuerno. Esta fase de la Luna es la que se utiliza para dar comienzo al primer día de cada mes lunar."));
        mFaseLunar.add(new FaseLunar(R.drawable.cuarto_creciente, "Cuarto creciente", "Primer cuarto", "Cuarto Creciente. Tiene su salida en el horizonte por el este a las 12 del mediodía (hora astronómica local, no necesariamente hora oficial), su cenit se produce a las 6 de la tarde y su ocaso a las 12 de la medianoche. La parte luminosa de la Luna durante esta fase tiene la forma de un círculo partido justo a la mitad (semi-círculo)."));
        mFaseLunar.add(new FaseLunar(R.drawable.gibosa_iluminante, "Gibosa iluminante", null, "Luna Gibosa Creciente, una vez ya pasada la fase del Cuarto Creciente, la Luna va tomando progresivamente día tras día, una forma convexa por ambos lados en su parte luminosa, perdiendo ese lado recto que poseía durante la fase Cuarto Creciente."));
        mFaseLunar.add(new FaseLunar(R.drawable.luna_llena, "Luna llena", "Plenilunio", "Luna Llena o Plenilunio, es cuando la concavidad de la parte luminosa de la Luna se logra completar en su totalidad hasta formar un círculo. Su salida en el horizonte es aproximadamente a las 6:00 p.m., el cenit lo alcanza aproximadamente durante la medianoche y se oculta cerca de las 6:00 de la mañana. La Luna Llena viene a marcar justo lo que es la mitad del mes lunar (14 días, 18 horas, 21 minutos 36 segundos)."));
        mFaseLunar.add(new FaseLunar(R.drawable.gibosa_menguante, "Gibosa menguante", null, "Luna Gibosa Menguante, pasada ya la fase correspondiente a la Luna Llena, la parte luminosa de la Luna comenzará a menguar con el correr de los días, tomando así de nuevo —igual como en la Luna Gibosa creciente— una apariencia de una Luna-Cóncava (gibosa) esta vez en su fase decreciente."));
        mFaseLunar.add(new FaseLunar(R.drawable.cuarto_menguante, "Cuarto menguante", "Último cuarto", "Cuarto Menguante, exactamente igual que el Cuarto Creciente, pero en sentido contrario. Además, tiene su salida en el horizonte a las 12 de la medianoche, alcanza el cenit en el cielo a las 6 de la mañana y su ocaso se produce a las 12 del mediodía, es decir, esta fase lunar corresponde al periodo de días durante el cual es posible observar a la Luna en el cielo durante las horas de la mañana."));
        mFaseLunar.add(new FaseLunar(R.drawable.creciente_menguante, "Creciente menguante", null, "Luna Menguante, conocida también como \"Creciente Menguante\" o \"Luna Vieja\" (este último término poco conocido) ya que es idéntica a la Luna Nueva Visible, pero en sentido opuesto. La Luna Menguante sólo es posible verla de madrugada, hacia el Este, justo por encima de la Aurora o Alba y antes de que salga el Sol. Tiene apariencia de pequeña guadaña."));
*/

        //Method with JSON
        try {
            JSONObject data = new JSONObject(JSONData);
//            JSONObject data = new JSONObject(loadJSONFromAPI());
            JSONArray faselunar = data.getJSONArray("records");
            for (int i = 0; i < faselunar.length(); i++) {
                JSONObject object = faselunar.getJSONObject(i);
                String mDrawableName = object.getString("photo_principale");
                String mDescription = object.getString("description");
                String mAlias = object.getString("prix");
                String mFase = object.getString("titre_annonce");
                String ville = object.getString("id_quartier");
                String date = object.getString("date");
                String heure = object.getString("heure");
                String state = object.getString("etat");
                String description = object.getString("description");
                FaseLunar FL = new FaseLunar(mDrawableName, mFase, mAlias, mDescription, ville, date, heure, state, description);
                result.add(FL);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }//getFaseLunarItems

    private FasesLunaresAdapter getNewFasesLunaresAdapter() {

//        mList = getFaseLunarItems();
        return new FasesLunaresAdapter(mList, getActivity(), FasesLunaresAdapter.ADAPTER_MODE_LISTVIEW);
    }

//    private ArrayList<FaseLunar> getFaseLunarItems() {
//        return mActivity.getFaseLunarItems();
//    }

    public FasesLunaresAdapter getFasesLunaresAdapter(){
        return this.fasesLunaresAdapter;
    }

    class JsonTask extends AsyncTask<String, String, String> {

        private String result;

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                    //Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)
                }

                Log.d("SUCCESS, Object : ", buffer.toString());
                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Log.d("FAILURE, Object : ", "NULL");
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            mList = getFaseLunarItems(result);
            fasesLunaresAdapter.notifyDataSetChanged();
        }
    }

}
