package com.example.cbnu_sportscenter;

import androidx.annotation.DrawableRes;
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

    int[] images = new int[]{R.drawable.qrex1,R.drawable.qrex2,R.drawable.qrex3,R.drawable.qrex4,
            R.drawable.qrex5,R.drawable.qrex6,R.drawable.qrex7,R.drawable.qrex8,R.drawable.qrex9,R.drawable.qrex10};

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

        int imageId = (int)(Math.random()*images.length);

        qrCode.setBackgroundResource(images[imageId]);

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
                        int newimageId = (int)(Math.random()*images.length);

                       while(imageId == newimageId){
                           newimageId = (int)(Math.random()*images.length);
                       }
                       qrCode.setBackgroundResource(images[newimageId]);
                    }

                }.start();
            }
        };

        handler.postDelayed(r,0);



    }
}