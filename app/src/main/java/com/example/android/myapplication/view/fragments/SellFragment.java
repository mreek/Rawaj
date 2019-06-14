// sell Fragment

package com.example.android.myapplication.view.fragments;

import android.Manifest;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.features.ReturnMode;
import com.esafirm.imagepicker.model.Image;
import com.example.android.myapplication.view.activity.PhotoSelectActivity;
import com.example.android.myapplication.R;
import com.example.android.myapplication.view.activity.PhotoSelectActivity;

import com.example.android.myapplication.view.fragments.MainFragment;
import java.util.ArrayList;
import java.util.List;


public class SellFragment extends Fragment {
    private Button button ;
    private ImageView imageView;
    private Spinner mType;
    private Spinner  mVille;
    private Spinner  mQuartier;
    public static final int  REQUEST_WRITE_PERMISSION =10;

    String [] values =
            {"Immobilier","villas","appartements","Electronique","Telephone","Tablette","Vehicules","Voiture","bicyclette","table","Fournitures","Chaise"};

    String [] ville =
            {"Afourar","Afourar","Agdz","Aghbala","Agouraï","Aguelmous","Ahfir","Aïn Bni Mathar","Ain Cheggag","Aïn Dorij",
                    "Aïn El Aouda","Aïn Erreggada","Aïn Harrouda","Aïn Jemaa","","Aïn Karma","Aïn Leuh","Aïn Taoujdate","Aïn Baha","Aïn Boubidmane","Aïn Daoud","Aïn Iaaza","Aïn Ishaq","Aïn  Melloul","Aït Ourir"};


    String [] region =
            {"Tanger-Tétouan-Al Hoceïm","Oriental","Fès-Meknès","Rabat-Salé-Kénitra","Béni Mellal-Khénifra","Casablanca-Settat","Marrakech-Safi","Drâa-Tafilalet","Souss-Massa","Guelmim-Oued Noun","Laâyoune-Sakia El Hamra","Dakhla-Oued Ed-Dahab"};

    public static SellFragment newInstance() {
        SellFragment fragment = new SellFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_sell, container, false);
        //imageview  pickimage
        imageView = v.findViewById(R.id.imageview);
        button = v.findViewById(R.id.pickimage);
        mType = v.findViewById(R.id.spinner);
        mVille = v.findViewById(R.id.spinner2);
        mQuartier = v.findViewById(R.id.spinner3);

        //
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mType.setAdapter(adapter);


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, ville);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mVille.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, region);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mQuartier.setAdapter(adapter3);


        ImagePicker.create(this) // Activity or Fragment
                .start();


        v.findViewById(R.id.pickimage)
                .setOnClickListener(view1 -> {
                    ImagePicker.create(SellFragment.this)
                            .returnMode(ReturnMode.ALL) // set whether pick action or camera action should return immediate result or not. Only works in single mode for image picker
                            .folderMode(true) // set folder mode (false by default)
                            .single()
                            //.multi()
                            .toolbarFolderTitle("Folder") // folder selection title
                            .toolbarImageTitle("Tap to select")
                            //.toolbarDoneButtonText("DONE") // done button text
                            .start(0); // image selection title
                });

        v.findViewById(R.id.button_close)


                .setOnClickListener(view12 -> getFragmentManager().beginTransaction()
                        .replace(R.id.f_container,new MainFragment())
                        // .remove(SellFragment.this)
                        //.attach(MainFragment,this);//*ft.show(bFragment);
                        .commitAllowingStateLoss());





/*
        // set spinner content
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add(getString(R.string.category1));
        spinnerArray.add(getString(R.string.category2));
        spinnerArray.add(getString(R.string.category3));
        spinnerArray.add(getString(R.string.category4));
        spinnerArray.add(getString(R.string.category5));
        spinnerArray.add(getString(R.string.category6;
        spinnerArray.add(getString(R.string.category7));
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(
          //      this, v.R.layout.spinner_row_style, spinnerArray);
        //mType.setAdapter(adapter);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.spinner_row_style, spinnerArray);
                mType.setAdapter(adapter);


*/
        return v;

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        List<Image> images = ImagePicker.getImages(data);
        if (images != null && !images.isEmpty()) {
            imageView.setImageBitmap(BitmapFactory.decodeFile(images.get(0).getPath()));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
