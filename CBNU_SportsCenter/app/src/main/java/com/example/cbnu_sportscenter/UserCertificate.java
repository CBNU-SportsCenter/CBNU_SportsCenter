package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class UserCertificate extends AppCompatActivity {

    TextView userMajor, studentCode, userName, currentTime, university;
    ImageView profileImage, reNew, qrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_certificate);

        userMajor = findViewById(R.id.userMajor);
        studentCode = findViewById(R.id.studentCode);
        userName = findViewById(R.id.userName);
        currentTime = findViewById(R.id.currentTime);
        university = findViewById(R.id.university);

        profileImage = (ImageView)findViewById(R.id.profileImage);
        reNew = (ImageView)findViewById(R.id.reNew);
        qrCode = (ImageView)findViewById(R.id.qrCode);
        

    }
}