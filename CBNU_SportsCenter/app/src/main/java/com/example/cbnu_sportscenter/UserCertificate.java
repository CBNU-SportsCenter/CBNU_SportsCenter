package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class UserCertificate extends AppCompatActivity {

    TextView userMajor, studentCode, userName, currentTime, university, remainTime;
    ImageView profileImage, reNew, qrCode;


    private static final long Timer_Duration = 30000L;
    private static final long Timer_Interval = 1000L;

    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_certificate);

        userMajor = findViewById(R.id.userMajor);
        studentCode = findViewById(R.id.studentCode);
        userName = findViewById(R.id.userName);
        currentTime = findViewById(R.id.currentTime);
        university = findViewById(R.id.university);
        remainTime = findViewById(R.id.remainTime);

        profileImage = (ImageView)findViewById(R.id.profileImage);
        reNew = (ImageView)findViewById(R.id.reNew);
        qrCode = (ImageView)findViewById(R.id.qrCode);

        Handler handler = new Handler();

        final Runnable r = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,30000);
                mCountDownTimer = new CountDownTimer(Timer_Duration,Timer_Interval) {   //총 30초동안, 매1초씩 줄어듬
                    @Override
                    public void onTick(long l) {
                        remainTime.setText(String.format(Locale.getDefault(),"%d 초",l /Timer_Interval));

                    }
                    @Override
                    public void onFinish() {
                    }
                }.start();
            }
        };

        handler.postDelayed(r,0);



    }
}