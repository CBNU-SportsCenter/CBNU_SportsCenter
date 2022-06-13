package com.example.cbnu_sportscenter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class WeightActivity extends Fragment {

    TextView weightperson, weightletter;
    String str1;
    Integer num;
    MyDatabaseHelper DB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_weight, container, false);

        DB = new MyDatabaseHelper(getActivity().getApplicationContext());
        weightperson = (TextView) view.findViewById(R.id.weightperson);
        weightletter = (TextView) view.findViewById(R.id.weightletter);
        str1 = DB.Weighteuser("등록조회");
        num = Integer.parseInt(str1);
        weightperson.setText(num.toString());
        ImageView image = (ImageView) view.findViewById(R.id.imageView);
        //Glide.with(this).load(R.raw.swimmer).circleCrop().into(imageView);
        if (num < 1) {
            weightletter.setText("혼잡도 : 원활");
            weightletter.setTextColor(Color.parseColor("#0000ff"));
            image.setImageResource(R.drawable.cow1);
        } else if (num < 2) {
            weightletter.setText("혼잡도 : 보통");
            weightletter.setTextColor(Color.parseColor("#ff7f00"));
            image.setImageResource(R.drawable.cow2);
        } else {
            weightletter.setText("혼잡도 : 혼잡");
            weightletter.setTextColor(Color.parseColor("#ff0000"));
            image.setImageResource(R.drawable.cow3);
        }


        return view;
    }
}