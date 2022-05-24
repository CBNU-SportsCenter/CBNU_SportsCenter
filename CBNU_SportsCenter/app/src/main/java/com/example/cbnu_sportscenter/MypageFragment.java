package com.example.cbnu_sportscenter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;


public class MypageFragment extends Fragment {

    TextView userprogram,totaltext,todaytext;
    Button btn_update,btn_logout;
    UpdateFragment updatefragment;
    String studentid,program;
    String day,time,today,todaytime,date;
    Bundle bundle;
    Cursor cursor;
    int totaltime=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mypage, container, false);
        view.findViewById(R.id.mypage);

        userprogram=view.findViewById(R.id.userProgram);
        btn_update=view.findViewById(R.id.btn_update);
        btn_logout=view.findViewById(R.id.btn_logout);
        totaltext=view.findViewById(R.id.totaltext);
        todaytext=view.findViewById(R.id.todaytext);
        updatefragment=new UpdateFragment();



        bundle=getArguments();
        Set<String> keys = bundle.keySet();


        if(keys.size()>0){  //정보가 정상적으로 전달되었을때
            MyDatabaseHelper dbHelper=new MyDatabaseHelper(getActivity().getApplicationContext());
            studentid=bundle.getString("studentid");
            program=dbHelper.getProgram(studentid);
            userprogram.setText("프로그램: "+program);
        }


        else{       //정보가 정상적으로 전달되지 않았을때
            Toast.makeText(container.getContext(), "bundle count null", Toast.LENGTH_SHORT).show();
        }

        date=getDate();
        today=date.substring(8,10);
        Toast.makeText(container.getContext(), "today"+today, Toast.LENGTH_SHORT).show();


        BarChart barChart = view.findViewById(R.id.barchart);

        //샘플 데이터
        ArrayList<BarEntry> visitors = new ArrayList<>();

        getExerciseInfo();
        setExerciseInfo(visitors);
/*
        visitors.add(new BarEntry(20, 60));
        visitors.add(new BarEntry(21, 90));
        visitors.add(new BarEntry(22, 80));
        visitors.add(new BarEntry(23, 40));
        visitors.add(new BarEntry(24, 10));*/



        BarDataSet barDataSet = new BarDataSet(visitors, "hello");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart Example");
        barChart.animateY(2000);
        totaltext.setText("총:"+totaltime+"초");


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("studentid", studentid);
                updatefragment.setArguments(bundle);
                ((MainPageActivity)getActivity()).getSupportFragmentManager().
                        beginTransaction().replace(R.id.frameLayout, updatefragment).commit();;
            }
        });

       btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart(getActivity());
            }
        });


        return view;
    }

    private void restart(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
        ComponentName componentName = intent.getComponent();
        Intent mainIntent = Intent.makeRestartActivityTask(componentName);
        context.startActivity(mainIntent);
        Runtime.getRuntime().exit(0);
    }

    public void getExerciseInfo(){
        MyDatabaseHelper dbHelper=new MyDatabaseHelper(getActivity().getApplicationContext());
        cursor=dbHelper.getExerciseInfo(studentid);
    }

    public void setExerciseInfo(ArrayList<BarEntry> visitors){
        for(int i=0; i<cursor.getCount(); i++){
            cursor.moveToNext();
            day=cursor.getString(4);
            time=cursor.getString(5);
            visitors.add(new BarEntry(Integer.parseInt(day), Integer.parseInt(time)));
            totaltime+=Integer.parseInt(time);
            if(today.equals(day)){
                todaytext.setText(time+"초");
            }
        }
    }

    public String getDate(){


        long now = System.currentTimeMillis();


        Date date = new Date(now);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String getTime = sdf.format(date);
        return getTime;
    }

}