package com.example.cbnu_sportscenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

public class FacilityMenuActivity extends Fragment {

    TextView toFloor0, toFloor1, toFloor2, toFloor3, toFloor4;
    PhotoView directionImage;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_facility_menu, container, false);

        toFloor0 = view.findViewById(R.id.toFloor0);
        toFloor1 = view.findViewById(R.id.toFloor1);
        toFloor2 = view.findViewById(R.id.toFloor2);
        toFloor3 = view.findViewById(R.id.toFloor3);
        toFloor4 = view.findViewById(R.id.toFloor4);

        PhotoView directionImage = view.findViewById(R.id.directionImage);
        toFloor0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directionImage.setImageResource(R.drawable.fl0);
            }
        });

        toFloor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directionImage.setImageResource(R.drawable.fl1);
            }
        });

        toFloor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directionImage.setImageResource(R.drawable.fl2);
            }
        });

        toFloor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directionImage.setImageResource(R.drawable.fl3);
            }
        });

        toFloor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directionImage.setImageResource(R.drawable.fl4);
            }
        });


        return view;
    }
}