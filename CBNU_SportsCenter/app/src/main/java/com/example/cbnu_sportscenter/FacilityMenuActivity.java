package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FacilityMenuActivity extends AppCompatActivity {

    TextView toFloor0, toFloor1, toFloor2, toFloor3, toFloor4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_menu);

        toFloor0 = findViewById(R.id.toFloor0);
        toFloor1 = findViewById(R.id.toFloor1);
        toFloor2 = findViewById(R.id.toFloor2);
        toFloor3 = findViewById(R.id.toFloor3);
        toFloor4 = findViewById(R.id.toFloor4);

        toFloor0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        toFloor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        toFloor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        toFloor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        toFloor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}