package com.example.cbnu_sportscenter;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

public class MainPageActivity extends AppCompatActivity {
    Button btnCer,btnUsage,btnIntro,btnNotice;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCer.findViewById(R.id.Cert);
        btnUsage.findViewById(R.id.Usag);
        btnIntro.findViewById(R.id.Intr);
        btnNotice.findViewById(R.id.Noti);
        

    }
}
