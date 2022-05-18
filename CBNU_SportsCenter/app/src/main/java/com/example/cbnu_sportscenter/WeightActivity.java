package com.example.cbnu_sportscenter;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class WeightActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        setTitle("헬 스");

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Glide.with(this).load(R.raw.swimmer).circleCrop().into(imageView);

    }
}
