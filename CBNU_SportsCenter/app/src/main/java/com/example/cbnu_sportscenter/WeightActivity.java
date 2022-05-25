package com.example.cbnu_sportscenter;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
public class WeightActivity extends AppCompatActivity {

    TextView weightperson,weightletter;
    String str1;
    Integer num;
    MyDatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DB = new MyDatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        weightperson=(TextView)findViewById(R.id.weightperson);
        weightletter=(TextView)findViewById(R.id.weightletter);
        str1=DB.Weighteuser("등록조회");
        num=Integer.parseInt(str1);
        weightperson.setText(num.toString());
        setTitle("헬 스");
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Glide.with(this).load(R.raw.swimmer).circleCrop().into(imageView);
        if(num<20)
        {
            weightletter.setText("혼잡도 : 원활");
            weightletter.setTextColor(Color.parseColor("#0000ff"));
        }
        else if(num<30)
        {
            weightletter.setText("혼잡도 : 보통");
            weightletter.setTextColor(Color.parseColor("#ff7f00"));
        }
        else
        {
            weightletter.setText("혼잡도 : 혼잡");
            weightletter.setTextColor(Color.parseColor("#ff0000"));
        }
    }
}
