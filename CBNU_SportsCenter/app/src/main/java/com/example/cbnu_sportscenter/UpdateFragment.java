package com.example.cbnu_sportscenter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;


public class UpdateFragment extends Fragment {


    Button btn_back,btn_update;
    TextInputLayout Password1, Password2,
            Major, Name;
    MyDatabaseHelper DB;
    Spinner Spn;
    ArrayAdapter arrayAdapter;
    TextView userprogram;
    String studentid,password,name,major,program;
    Bundle bundle;
    MypageFragment mypagefragment;
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

        btn_update=view.findViewById(R.id.btn_update);
        btn_back=view.findViewById(R.id.btn_back);
        Password1=view.findViewById(R.id.Password1);
        Password2=view.findViewById(R.id.Password2);
        Name=view.findViewById(R.id.Name);
        Major=view.findViewById(R.id.Major);
        Spn=view.findViewById(R.id.spn);
        DB = new MyDatabaseHelper(getActivity().getApplicationContext());
        bundle=new Bundle();
        mypagefragment=new MypageFragment();

        setViews();


        Bundle bundle=getArguments();

        if(bundle!=null){
            MyDatabaseHelper dbHelper=new MyDatabaseHelper(getActivity().getApplicationContext());
            studentid=bundle.getString("studentid");
            password=dbHelper.getPassword(studentid);
            name=dbHelper.getName(studentid);
            major=dbHelper.getMajor(studentid);
            program=dbHelper.getProgram(studentid);



            Password1.getEditText().setText(password);
            Password2.getEditText().setText(password);
            Name.getEditText().setText(name);
            Major.getEditText().setText(major);



            ArrayAdapter myAdap = (ArrayAdapter) Spn.getAdapter(); //cast to an ArrayAdapter
            int spinnerPosition = myAdap.getPosition(program);
            Spn.setSelection(spinnerPosition);
        }

        else {
            Toast.makeText(container.getContext(), "bundle count null", Toast.LENGTH_SHORT).show();
        }


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password1=Password1.getEditText().getText().toString().trim();
                String password2=Password2.getEditText().getText().toString().trim();
                String name=Name.getEditText().getText().toString().trim();
                String major=Major.getEditText().getText().toString().trim();
                String program=Spn.getSelectedItem().toString();

                if(studentid.equals("") || password1.equals("") || password2.equals("") ||
                        name.equals("") || major.equals("") )
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(password1.equals(password2)){

                            long result=DB.updateAccount(studentid,password1, name, major, program);
                            if(result!=-1)
                            {
                                bundle.putString("studentid", studentid);
                                mypagefragment.setArguments(bundle);
                                ((MainPageActivity)getActivity()).getSupportFragmentManager().
                                        beginTransaction().replace(R.id.frameLayout, mypagefragment).commit();;
                            }
                    }else{
                        Toast.makeText(getActivity().getApplicationContext(), "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("studentid", studentid);
                mypagefragment.setArguments(bundle);
                ((MainPageActivity)getActivity()).getSupportFragmentManager().
                        beginTransaction().replace(R.id.frameLayout, mypagefragment).commit();;

            }
        });



        return view;
    }

    public void setViews(){
        arrayAdapter=ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.programs,android.R.layout.simple_spinner_dropdown_item);
        Spn.setAdapter(arrayAdapter);
    }
}