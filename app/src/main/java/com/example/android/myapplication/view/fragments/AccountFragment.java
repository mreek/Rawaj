package com.example.android.myapplication.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.myapplication.view.activity.Main2Activity;

import com.example.android.myapplication.R;
public class AccountFragment extends Fragment {


    private Button seconnecter;
    public static AccountFragment newInstance() {
        AccountFragment fragment = new AccountFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_account, container, false);

        //declarer les composants hnaya

        //exemple
        seconnecter =v.findViewById(R.id.seconnecter);

        seconnecter.setOnClickListener(new Button.OnClickListener()
                                       {
                                           public void onClick(View v)
                                           {
                                               Intent myIntent = new Intent(v.getContext(), Main2Activity.class);
                                               startActivity(myIntent);
                                           }
                                       }
        );

        return v;
    }
}
