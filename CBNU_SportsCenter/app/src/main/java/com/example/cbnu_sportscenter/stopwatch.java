package com.example.cbnu_sportscenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class stopwatch extends AppCompatActivity {


    private ScrollView scrollView;
    private TextView record;
    private Button bt_sta,bt_pause;

    //타이머 시간 값을 저장할 변수
    private long baseTime,pauseTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        //객체화

        scrollView = (ScrollView)findViewById(R.id.scrollView);
        record = (TextView)findViewById(R.id.record);
        bt_sta = (Button)findViewById(R.id.bt_sta);
        bt_pause = (Button)findViewById(R.id.bt_pause);


        bt_sta.setOnClickListener(onClickListener);
        bt_pause.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.bt_sta:
                    staButton();
                    break;
                case R.id.bt_pause:
                    pauseButton();
                    break;
            }


        }
    };



//질문: 왜 위에서 INIT(초기값)을 넣은 status 를 스위치문에서 다시 캐스팅 하는가?
    //대답: 그래야 상태값을 확인할수 있기 때문이다. 즉, 달라지는 상태값을 알기위해선 기준이 되는 초기값이 필요한것!

    private void staButton(){


                //어플리케이션이 실행되고 나서 실제로 경과된 시간...
                baseTime = SystemClock.elapsedRealtime();

                //핸들러 실행
                handler.sendEmptyMessage(0);


                Toast.makeText(getApplicationContext(), "init", Toast.LENGTH_SHORT).show();

    }

    private void pauseButton(){
        Toast.makeText(getApplicationContext(), "pause", Toast.LENGTH_SHORT).show();

        //핸들러 정지
        handler.removeMessages(0);

        //정지 시간 체크
        pauseTime = SystemClock.elapsedRealtime();
        String timeList = record.getText().toString();
        timeList= String.format("%s\n",getTime());
        String hour=timeList.substring(0,2);
        String minute=timeList.substring(3,5);
        Toast.makeText(getApplicationContext(), ""+timeList+"ho"+hour+"/"+minute, Toast.LENGTH_SHORT).show();




    }




    private String getTime(){
        //경과된 시간 체크

        long nowTime = SystemClock.elapsedRealtime();
        //시스템이 부팅된 이후의 시간?
        long overTime = nowTime - baseTime;

        long m = overTime/1000/60;
        long s = (overTime/1000)%60;
        long ms = overTime % 1000;

        String recTime = String.format("%02d:%02d:%03d",m,s,ms);

        return recTime;
    }

    public void Move(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);

    }

    Handler handler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {



            //
            handler.sendEmptyMessage(0);
        }
    };
}
