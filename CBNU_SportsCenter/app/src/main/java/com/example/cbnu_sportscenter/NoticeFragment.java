package com.example.cbnu_sportscenter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class NoticeFragment extends Fragment {
    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        //webView
        webView = (WebView) view.findViewById(R.id.wView);

        webView.setWebViewClient(new WebViewClient());  // 새 창 띄우기 않기
        webView.getSettings().setJavaScriptEnabled(true); // 자바스크립트 사용여부
        webView.getSettings().setTextZoom(50);
        webView.loadUrl("https://sports.chungbuk.ac.kr/master.php?pg_idx=145&spg_idx=185");

        return view;
    }
}

