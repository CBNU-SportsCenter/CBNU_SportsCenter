package com.example.cbnu_sportscenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SportlistActivity extends Fragment {

    TextView weight,swim,squash;
    //Fragment
    SwimActivity swimActivity;
    WeightActivity weightActivity;
    SquashActivity squashActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_sportlist, container, false);

        swim=view.findViewById(R.id.swim);
        weight=view.findViewById((R.id.weight));
        squash=view.findViewById(R.id.squash);

        //Framework
        swimActivity=new SwimActivity();
        weightActivity=new WeightActivity();
        squashActivity=new SquashActivity();


        swim.setOnClickListener(new View.OnClickListener() { //버튼에서 페이지 이동 하기
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,swimActivity).commit();}
        });
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,weightActivity).commit();}
        });
        squash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,squashActivity).commit();}

        });


        return view;
    }
}

