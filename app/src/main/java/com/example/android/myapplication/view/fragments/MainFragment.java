package com.example.android.myapplication.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.myapplication.R;
import com.example.android.myapplication.view.activity.MainActivity;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.main_fragment, container, false);
        lv =v.findViewById(R.id.list1);
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

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s=al.get(position);
                MainActivity mn1 =(MainActivity) getActivity();
                mn1.fl(s);

            }
        });
        return v;
    }
}
