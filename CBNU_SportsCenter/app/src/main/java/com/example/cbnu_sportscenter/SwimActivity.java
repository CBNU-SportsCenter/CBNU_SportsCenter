package com.example.cbnu_sportscenter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class SwimActivity extends AppCompatActivity {
    TextView swimperson,swimletter;
    Button swimbutton;
    String str1;
    Integer num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swim);
        setTitle("수 영");
        swimperson=(TextView)findViewById(R.id.swimperson);
        swimletter=(TextView)findViewById(R.id.swimletter);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Glide.with(this).load(R.raw.swimmer).circleCrop().into(imageView);

        str1=swimperson.getText().toString();
        num=Integer.parseInt(str1);
        if(num<20)
        {
            swimletter.setText("혼잡도 : 원활");
            swimletter.setTextColor(Color.parseColor("#0000ff"));
        }
        else if(num<30)
        {
            swimletter.setText("혼잡도 : 보통");
            swimletter.setTextColor(Color.parseColor("#ff7f00"));
        }
        else
        {
            swimletter.setText("혼잡도 : 혼잡");
            swimletter.setTextColor(Color.parseColor("#ff0000"));
        }
    }
}
