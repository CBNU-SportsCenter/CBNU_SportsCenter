package com.example.cbnu_sportscenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class SportlistActivity extends Fragment {

    Button weight,swim,squash;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_sportlist, container, false);

        swim=view.findViewById(R.id.button1);
        weight=view.findViewById((R.id.button2));
        squash=view.findViewById(R.id.button3);

        swim.setOnClickListener(new View.OnClickListener() { //버튼에서 페이지 이동 하기
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SwimActivity.class);
                startActivity(intent);
            }
        });
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), WeightActivity.class);
                startActivity(intent);
            }
        });
        squash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SquashActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}

