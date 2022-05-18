package com.example.cbnu_sportscenter;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;


public class UserCertificate extends Fragment {

    BackGroundThread backgroundThread;
    TextView userMajor, studentCode, userName, currentTime, university, remainTime;
    ImageView profileImage, reNew, qrCode;


    int[] images = new int[]{R.drawable.qrex1,R.drawable.qrex2,R.drawable.qrex3,R.drawable.qrex4,
            R.drawable.qrex5,R.drawable.qrex6,R.drawable.qrex7,R.drawable.qrex8,R.drawable.qrex9,R.drawable.qrex10};

    private static final long Timer_Duration = 30000L;
    private static final long Timer_Interval = 1000;

    private CountDownTimer mCountDownTimer;
    Random random = new Random();
    int imageId = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_user_certificate,container,false);

        userMajor = view.findViewById(R.id.userMajor);
        studentCode = view.findViewById(R.id.studentCode);
        userName = view.findViewById(R.id.userName);
        currentTime = view.findViewById(R.id.currentTime);
        university = view.findViewById(R.id.university);
        remainTime = view.findViewById(R.id.remainTime);

        profileImage = (ImageView)view.findViewById(R.id.profileImage);
        reNew = (ImageView)view.findViewById(R.id.reNew);
        qrCode = (ImageView)view.findViewById(R.id.qrCode);
        qrCode.setBackgroundResource(images[imageId]);
        Bundle bundle=getArguments();

        if(bundle!=null){
            userName.setText(bundle.getString("name"));
            studentCode.setText(bundle.getString("studentid"));
            userMajor.setText(bundle.getString("major"));
        }







        Handler handler = new Handler();

        TimeZone timeZone;
        DateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss",Locale.KOREAN);
        timeZone = TimeZone.getTimeZone("Asia/Seoul");
        dateFormat.setTimeZone(timeZone);
        Date date = new Date();
        currentTime.setText(dateFormat.format(date));

        final Runnable r = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,Timer_Duration);
                mCountDownTimer = new CountDownTimer(Timer_Duration,Timer_Interval) {   //총 30초동안, 매1초씩 줄어듬
                    @Override
                    public void onTick(long l) {
                        remainTime.setText(String.format(Locale.getDefault(),"%d 초",(Math.round((double)l /Timer_Interval)-1)));  //시간 오류 해결
                    }

                    @Override
                    public void onFinish() {   //종료된다면
                        int newimageId = random.nextInt(images.length);

                        while(imageId == newimageId){
                            newimageId = random.nextInt(images.length);
                        }
                        qrCode.setBackgroundResource(images[newimageId]);
                        imageId = newimageId;
                    }

                }.start();
            }
        };

        handler.postDelayed(r,0);

        reNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(handler!=null) {  //만약 handler 있다면 취소
                    handler.removeCallbacksAndMessages(null);
                    mCountDownTimer.cancel();
                }

                int newimageId = random.nextInt(images.length);  //새로 이미지 설정

                while(imageId == newimageId){
                    newimageId = random.nextInt(images.length);
                }
                qrCode.setBackgroundResource(images[newimageId]);
                imageId = newimageId;

                final Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        handler.postDelayed(this,Timer_Duration);
                        mCountDownTimer = new CountDownTimer(Timer_Duration,Timer_Interval) {   //총 30초동안, 매1초씩 줄어듬
                            @Override
                            public void onTick(long l) {
                                remainTime.setText(String.format(Locale.getDefault(),"%d 초",(Math.round((double)l /Timer_Interval)-1)));
                            }

                            @Override
                            public void onFinish() {
                                int newimageId = random.nextInt(images.length);

                                while(imageId == newimageId){
                                    newimageId = random.nextInt(images.length);
                                }

                                qrCode.setBackgroundResource(images[newimageId]);
                                imageId = newimageId;
                            }

                        }.start();
                    }
                };
                handler.postDelayed(r,0);
            }

        });
        return view;
    }

    private final TimeHandler timeHandler = new TimeHandler(this);

    private static class TimeHandler extends Handler{
        private final WeakReference<UserCertificate> userCertificate;
        public TimeHandler(UserCertificate activity){
            userCertificate = new WeakReference<UserCertificate>(activity);
        }

        @Override
        public void handleMessage(Message msg){
            UserCertificate activity = userCertificate.get();
            if(activity!=null){
                activity.handleMessage(msg);
            }
        }
    }

    private void handleMessage(Message msg) {
        TimeZone timeZone;
        DateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss",Locale.KOREAN);
        timeZone = TimeZone.getTimeZone("Asia/Seoul");
        dateFormat.setTimeZone(timeZone);
        Date date = new Date();
        currentTime.setText(dateFormat.format(date));
        //currentTime.setText(now);
        //currentTime.setText(DateFormat.getDateTimeInstance().format(new Date()));
    }

    @Override
    public void onStart(){
        super.onStart();

        backgroundThread = new BackGroundThread();
        backgroundThread.setRunning(true);
        backgroundThread.start();
    }

    @Override
    public void onStop(){
        super.onStop();

        boolean retry = true;
        backgroundThread.setRunning(false);
        while (retry){
            try{
                backgroundThread.join();
                retry = false;
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public class BackGroundThread extends Thread{
        boolean running = false;
        void setRunning(boolean b){
            running = b;
        }

        @Override
        public void run(){
            while(running){
                try{
                    sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                timeHandler.sendMessage(timeHandler .obtainMessage());
            }
        }
    }



}

