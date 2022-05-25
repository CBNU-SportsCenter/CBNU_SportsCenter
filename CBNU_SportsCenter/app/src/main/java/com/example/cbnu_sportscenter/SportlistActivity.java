package com.example.cbnu_sportscenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SportlistActivity extends AppCompatActivity {

    Button weight,swim,squash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportlist);
        setTitle("종 목 선 택");

        swim=findViewById(R.id.button1);
        weight=findViewById((R.id.button2));
        squash=findViewById(R.id.button3);

        swim.setOnClickListener(new View.OnClickListener() { //버튼에서 페이지 이동 하기
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SwimActivity.class);
                startActivity(intent);
            }
        });
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WeightActivity.class);
                startActivity(intent);
            }
        });
        squash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SquashActivity.class);
                startActivity(intent);
            }
        });

    }
}