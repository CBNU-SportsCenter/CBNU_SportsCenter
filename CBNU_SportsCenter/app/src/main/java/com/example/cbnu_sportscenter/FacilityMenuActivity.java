package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FacilityMenuActivity extends AppCompatActivity {

    Button floor0, floor1, floor2, floor3, floor4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_menu);

        floor0 = findViewById(R.id.floor0);
        floor1 = findViewById(R.id.floor1);
        floor2 = findViewById(R.id.floor2);
        floor3 = findViewById(R.id.floor3);
        floor4 = findViewById(R.id.floor4);

        floor0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        floor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        floor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        floor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        floor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}