package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class IntroductionActivity2 extends AppCompatActivity {

    ImageView centerImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction2);

        centerImage = findViewById(R.id.centerimage);

    }
}