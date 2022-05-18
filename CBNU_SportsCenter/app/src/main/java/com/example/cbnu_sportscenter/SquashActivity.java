package com.example.cbnu_sportscenter;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class SquashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squash);
        setTitle("스 쿼 시");

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Glide.with(this).load(R.raw.swimmer).circleCrop().into(imageView);

    }
}
