package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    MyDatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        DB = new MyDatabaseHelper(this);

        System.out.println("사용인원데이터베이스생성");
        DB.SportCenterActivity("등록조회","0", "0", "0"); //새롭게 만든다.
        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                finish();
            }
        }, 3000);





    }
}