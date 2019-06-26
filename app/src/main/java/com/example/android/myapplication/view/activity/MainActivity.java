package com.example.android.myapplication.view.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.myapplication.newmodels.FaseLunar;
import com.example.android.myapplication.view.fragments.AccountFragment;
import com.example.android.myapplication.view.fragments.DetailsFragment;
import com.example.android.myapplication.view.fragments.ChatFragment;
import com.example.android.myapplication.view.fragments.MainFragment;
import com.example.android.myapplication.R;
import com.example.android.myapplication.view.fragments.Myfrag2;
import com.example.android.myapplication.view.fragments.NotificationFragment;
import com.example.android.myapplication.view.fragments.SellFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private TextView appBarTV;


    //R
    private String URLstring = "http://www.json-generator.com/api/json/get/bUHZAmDgvC?indent=2";

// need to connect to api and fetch these and do the parsing instead of loading the shit from a local json file

    // http://192.168.1.118/api/annonce/read.php
    //  http://localip/api/ville/read.php
    //  http://localIP/api/quartier/read.php



    private String mDrawableName;
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CharSequence mDrawerTitle;
    private ArrayList<FaseLunar> mFaseLunar;
    private int resID;
    private CharSequence mTitle;
    private String mAlias;
    private String mFase;
    private String mDescription;
    private String ville;
    private String heure;
    private String date;
    private String state;
    private String description;


    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*  transaction of fragments
// connection between fragment and activity
        FragmentManager manager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction  t=manager.beginTransaction();
        MainFragment m1=new MainFragment(); // fragment object
            t.add(R.id.f_container)

*/

        // launch the introActivity
        Intent intent= new Intent(this,IntroActivity.class);
        startActivity(intent);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        appBarTV = findViewById(R.id.appbar_text_view);

        ImageButton menuRight = findViewById(R.id.leftRight);
        menuRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = MainFragment.newInstance();
                               // Log.v(TAG, "lwl" );
                                break;
                            case R.id.action_item2:
                                selectedFragment = DetailsFragment.newInstance();
                                //Log.v(TAG, "tani" );
                                break;
                            case R.id.action_item3:
                                selectedFragment = SellFragment.newInstance();
                                //Log.v(TAG, "talet" );
                                break;

                            case R.id.action_item4:
                                selectedFragment = ChatFragment.newInstance();
                                //Log.v(TAG, "talet" );
                                break;

                            case R.id.action_item5:
                                selectedFragment = NotificationFragment.newInstance();
                                //Log.v(TAG, "talet" );
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.f_container, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.f_container, MainFragment.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.closeDrawers();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camera) {
           // appBarTV.setText("Main Page");
            MainFragment fragment = new MainFragment();
            ft.replace(R.id.f_container, fragment);
            ft.commit();

        } else if (id == R.id.nav_gallery) {
            //appBarTV.setText("Fragment With Tabs");
            ChatFragment fragment = new ChatFragment();
            ft.replace(R.id.f_container, fragment);
            ft.commit();

        } else if (id == R.id.nav_slideshow) {
            //appBarTV.setText("Slideshow Page");
            //DetailsFragment
            //Toast.makeText(this, "Slideshow", Toast.LENGTH_SHORT).show();
            DetailsFragment fragmentTab = new DetailsFragment();
            ft.replace(R.id.f_container, fragmentTab);
            ft.commit();
        } else if (id == R.id.nav_manage) {
            //appBarTV.setText("Tools Page");
           // Toast.makeText(this, "Contactez_nous Activity", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {
            //appBarTV.setText("Share Page");
            Toast.makeText(this, "Partager", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {
            //appBarTV.setText("Send");
            Toast.makeText(this, "Rate 5 stars", Toast.LENGTH_SHORT).show();
        }  else if (id == R.id.nav_login) {
            //appBarTV.setText("Fragment With Tabs");
            AccountFragment fragment = new AccountFragment();
            ft.replace(R.id.f_container, fragment);
            ft.commit();
        }

    //nav_login

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//

    // TODO: send data mn fragment lttani

    public void fl(String s) {
        //FaseLunar
        // sending data to frag2 when an item is clicked
        FragmentManager manager1=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction t1=manager1.beginTransaction();
        Myfrag2 m22=new Myfrag2();
        Bundle b2=new Bundle();
        b2.putString("s",s);
        m22.setArguments(b2);
        t1.replace(R.id.f_container,m22);
        t1.addToBackStack(null).commit();  //added back stack in the transaction from mainfragment to frag2

    }



    public ArrayList<FaseLunar> getFaseLunarItems() {
        mFaseLunar = new ArrayList<FaseLunar>();
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
            JSONObject data = new JSONObject(loadJSONFromAsset());
            JSONArray faselunar = data.getJSONArray("records");
            for (int i = 0; i < faselunar.length(); i++) {
                JSONObject object = faselunar.getJSONObject(i);
                mDrawableName = object.getString("photo_principale");
                resID = getResources().getIdentifier(mDrawableName,"drawable",getPackageName());
                mDescription = object.getString("description");
                mAlias = object.getString("prix");
                mFase = object.getString("titre_annonce");
                ville = object.getString("id_quartier");
                date = object.getString("date");
                heure = object.getString("heure");
                state = object.getString("etat");
                description = object.getString("description");
                FaseLunar FL = new FaseLunar(resID,mFase,mAlias,mDescription,ville,date,heure,state,description);
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
        AssetManager assetManager = getAssets();
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
