package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class IntroductionActivity extends AppCompatActivity {

    TextView toIntroduction,toFacilities,toDirection;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        toIntroduction = findViewById(R.id.toIntroduction);
        toFacilities = findViewById(R.id.toFacilities);
        toDirection = findViewById(R.id.toDirection);

        viewFlipper = findViewById(R.id.viewFlipper);

        toIntroduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),IntroductionActivity2.class);
                startActivity(intent);
            }
        });

        toFacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),FacilityMenuActivity.class);
                startActivity(intent);
            }
        });

        toDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        int images[]={ R.drawable.centerfacility1,R.drawable.centerfacility2,
                R.drawable.centerfacility3,R.drawable.centerfacility4,R.drawable.centerfacility5,R.drawable.centerfacility6};

        for(int image:images){
            viewflipperimages(image);
        }

    }

    public void viewflipperimages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);     //이미지추가
        viewFlipper.setFlipInterval(3000);  //3초마다
        viewFlipper.setAutoStart(true);     //처음 시작 여부

        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);  //animation
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }
}