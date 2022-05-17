package com.example.cbnu_sportscenter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class NoticeFragment extends Fragment {
    cbnuNotice cbnuNotice;
    gymNotice gymNotice;
    Button btncbnu,btngym;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notice, container, false);
        btncbnu=(Button) view.findViewById(R.id.btnCbnu);
        btngym=(Button) view.findViewById(R.id.btnGym);

        //프레그먼트
        cbnuNotice=new cbnuNotice();
        gymNotice=new gymNotice();

        btncbnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(cbnuNotice);
            }
        });
        btngym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(gymNotice);
            }
        });

        return view;
    }
    //프레그먼트 교체
    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        //화면변경
        fragmentTransaction.replace(R.id.NoticeframeLayout,fragment).commit();
    }
}

