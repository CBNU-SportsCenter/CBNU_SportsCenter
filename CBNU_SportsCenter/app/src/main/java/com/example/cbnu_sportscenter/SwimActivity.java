package com.example.cbnu_sportscenter;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class SwimActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView swimperson=(TextView)findViewById(R.id.swimperson);
        TextView swimletter=(TextView)findViewById(R.id.swimletter);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swim);
        setTitle("수 영");

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Glide.with(this).load(R.raw.swimmer).circleCrop().into(imageView);


    }
}
