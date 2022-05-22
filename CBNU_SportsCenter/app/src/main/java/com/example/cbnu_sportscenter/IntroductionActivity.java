package com.example.cbnu_sportscenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class IntroductionActivity extends Fragment {

    TextView toIntroduction,toFacilities,toDirection;
    ViewFlipper viewFlipper;
    IntroductionActivity2 introductionActivity2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_introduction,container,false);

        toIntroduction = view.findViewById(R.id.toIntroduction);
        toFacilities = view.findViewById(R.id.toFacilities);
        toDirection = view.findViewById(R.id.toDirection);

        viewFlipper = view.findViewById(R.id.viewFlipper);

        introductionActivity2=new IntroductionActivity2();

        toIntroduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,introductionActivity2).commit();}
        });

        toFacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity().getApplicationContext(),FacilityMenuActivity.class);
                startActivity(intent);
            }
        });

        toDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity().getApplicationContext(),DirectionActivity.class);
                startActivity(intent);
            }
        });

        int images[]={ R.drawable.centerfacility1,R.drawable.centerfacility2,
                R.drawable.centerfacility3,R.drawable.centerfacility4,R.drawable.centerfacility5,R.drawable.centerfacility6};

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