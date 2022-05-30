package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FacilityMenuActivity extends AppCompatActivity {

    TextView toFloor0, toFloor1, toFloor2, toFloor3, toFloor4;
    ImageView directionImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_menu);

        toFloor0 = findViewById(R.id.toFloor0);
        toFloor1 = findViewById(R.id.toFloor1);
        toFloor2 = findViewById(R.id.toFloor2);
        toFloor3 = findViewById(R.id.toFloor3);
        toFloor4 = findViewById(R.id.toFloor4);

        directionImage = findViewById(R.id.directionImage);
        toFloor0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directionImage.setImageResource(R.drawable.fl0);
            }
        });

        toFloor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directionImage.setImageResource(R.drawable.fl1);
            }
        });

        toFloor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directionImage.setImageResource(R.drawable.fl2);
            }
        });

        toFloor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directionImage.setImageResource(R.drawable.fl3);
            }
        });

        toFloor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directionImage.setImageResource(R.drawable.fl4);
            }
        });


    }
}