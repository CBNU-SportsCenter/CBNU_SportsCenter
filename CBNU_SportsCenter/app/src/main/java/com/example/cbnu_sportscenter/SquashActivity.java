package com.example.cbnu_sportscenter;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class SquashActivity extends Fragment {
    TextView squashperson,squashletter;
    String str1;
    Integer num;
    MyDatabaseHelper DB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_squash, container, false);

        squashperson=(TextView)view.findViewById(R.id.squashperson);
        squashletter=(TextView)view.findViewById(R.id.squashletter);
        DB = new MyDatabaseHelper(getActivity().getApplicationContext());
        str1=DB.Squasheuser("등록조회");
        num=Integer.parseInt(str1);
        squashperson.setText(num.toString());
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        Glide.with(this).load(R.raw.swimmer).circleCrop().into(imageView);
        if(num<20)
        {
            squashletter.setText("혼잡도 : 원활");
            squashletter.setTextColor(Color.parseColor("#0000ff"));
        }
        else if(num<30)
        {
            squashletter.setText("혼잡도 : 보통");
            squashletter.setTextColor(Color.parseColor("#ff7f00"));
        }
        else
        {
            squashletter.setText("혼잡도 : 혼잡");
            squashletter.setTextColor(Color.parseColor("#ff0000"));
        }

        return view;
    }
}
