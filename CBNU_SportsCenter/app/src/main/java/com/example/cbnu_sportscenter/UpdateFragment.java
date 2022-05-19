package com.example.cbnu_sportscenter;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class UpdateFragment extends Fragment {

    TextView program;

    /*
    // TODO: Rename and change types and number of parameters
    public static MypageFragment newInstance(String param1, String param2) {
        MypageFragment fragment = new MypageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);
        view.findViewById(R.id.update);

        //program=view.findViewById(R.id.update);

        Bundle bundle=getArguments();

        if(bundle!=null){
            program.setText("프로그램: "+bundle.getString("program"));
        }

/*
        BarChart barChart = view.findViewById(R.id.barchart);

        //샘플 데이터
        ArrayList<BarEntry> visitors = new ArrayList<>();
        visitors.add(new BarEntry(2014, 420));
        visitors.add(new BarEntry(2015, 450));
        visitors.add(new BarEntry(2016, 520));
        visitors.add(new BarEntry(2017, 620));
        visitors.add(new BarEntry(2018, 540));
        visitors.add(new BarEntry(2019, 720));
        visitors.add(new BarEntry(2020, 920));

        BarDataSet barDataSet = new BarDataSet(visitors, "hello");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart Example");
        barChart.animateY(2000);
*/

        return view;
    }
}