package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        new Handler().postDelayed(new Runnable() {

            @Override

            public void run() {

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                finish();

            }

        }, 3000);





    }
}