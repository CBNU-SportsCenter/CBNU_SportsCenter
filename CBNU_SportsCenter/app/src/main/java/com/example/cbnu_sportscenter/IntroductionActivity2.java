package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class IntroductionActivity2 extends AppCompatActivity {

    ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction2);

        viewFlipper = findViewById(R.id.viewFlipper);


        int images[]={ R.drawable.sportscenter, R.drawable.sportscenter2, R.drawable.sportscenter3};

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