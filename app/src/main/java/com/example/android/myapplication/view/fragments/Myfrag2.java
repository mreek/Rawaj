package com.example.android.myapplication.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Myfrag2 extends Fragment {

    TextView t;

    public Myfrag2() {
        // Required empty public constructor
    }
    //


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_myfrag2, container, false);
        //t=v.findViewById(R.id.text1);
        t=(TextView) v.findViewById(R.id.text1);
        Bundle b=getArguments();


        if (b!= null ){
            String s=b.getString("s");
            t.setText(s);
        }

        return v;
    }




}
