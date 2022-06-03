package com.example.cbnu_sportscenter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SwimActivity extends Fragment {
    TextView swimperson, swimletter;
    Button swimbutton;
    String str1;
    Integer num;
    MyDatabaseHelper DB;
    ImageView image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_swim, container, false);
        DB = new MyDatabaseHelper(getActivity().getApplicationContext());

        swimperson = (TextView) view.findViewById(R.id.swimperson);
        swimletter = (TextView) view.findViewById(R.id.swimletter);
        ImageView image = (ImageView) view.findViewById(R.id.imageView);
//        Glide.with(this).load(R.raw.swimmer).circleCrop().into(imageView);
        str1 = DB.Swimeuser("등록조회");
        num = Integer.parseInt(str1);
        swimperson.setText(num.toString());
        if (num < 1) {
            swimletter.setText("혼잡도 : 원활");
            swimletter.setTextColor(Color.parseColor("#0067a3"));
            image.setImageResource(R.drawable.cow1);

        } else if (num < 2) {
            swimletter.setText("혼잡도 : 보통");
            swimletter.setTextColor(Color.parseColor("#ff7f00"));
            image.setImageResource(R.drawable.cow2);
        } else {
            swimletter.setText("혼잡도 : 혼잡");
            swimletter.setTextColor(Color.parseColor("#ff0000"));
            image.setImageResource(R.drawable.cow2);  //사람이 많으면 우는 우왕이
        }
        return view;
    }
}