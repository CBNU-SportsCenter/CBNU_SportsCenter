package com.example.cbnu_sportscenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class IntroductionActivity2 extends Fragment {

    ViewFlipper viewFlipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_introduction2,container,false);

        viewFlipper = view.findViewById(R.id.viewFlipper);


        int images[]={ R.drawable.sportscenter, R.drawable.sportscenter2, R.drawable.sportscenter3};

        for(int image:images){
            viewflipperimages(image);
        }

        return view;
    }

    public void viewflipperimages(int image){
        ImageView imageView = new ImageView(getActivity().getApplicationContext());
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);     //이미지추가
        viewFlipper.setFlipInterval(3000);  //3초마다
        viewFlipper.setAutoStart(true);     //처음 시작 여부

        viewFlipper.setInAnimation(getActivity().getApplicationContext(),android.R.anim.slide_in_left);  //animation
        viewFlipper.setOutAnimation(getActivity().getApplicationContext(),android.R.anim.slide_out_right);

    }
}