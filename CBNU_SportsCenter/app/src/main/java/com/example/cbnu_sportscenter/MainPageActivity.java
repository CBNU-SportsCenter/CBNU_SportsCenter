package com.example.cbnu_sportscenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainPageActivity extends AppCompatActivity {
    Toolbar mainToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button cert,usage,intro,notice;
    //프래그먼트 정의
    UserCertificate userCertificate;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //툴바
        mainToolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mainToolbar);

        //네비뷰
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.nav_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //왼쪽버튼 사용
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu); //왼쪽버튼 아이콘
        getSupportActionBar().setTitle("Sports Center");  //해당 액티비티의 툴바에 있는 타이틀을 공백으로 처리
        
        //네비게이션뷰 선택하는 코드
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                String title = menuItem.getTitle().toString();

                if(id == R.id.menu1){
                    replaceFragment(userCertificate);
                }
                else if(id == R.id.menu2){
                    Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu3){
                    Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu4){
                    Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu5){
                    Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        userCertificate=new UserCertificate();
        
        //프레그먼트 이동 버튼
        cert=(Button)findViewById(R.id.Cert);
        usage=(Button)findViewById(R.id.Usag);
        intro=(Button)findViewById(R.id.Intr);
        notice=(Button)findViewById(R.id.Noti);

        replaceFragment(userCertificate);

        cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(userCertificate);
            }
        });
        usage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragmentTransaction.replace(R.id.frameLayout,userCertificate).commit();
                Toast.makeText(getApplicationContext(), "이용조회", Toast.LENGTH_SHORT).show();


            }
        });
        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragmentTransaction.replace(R.id.frameLayout,userCertificate).commit();
                Toast.makeText(getApplicationContext(), "소개", Toast.LENGTH_SHORT).show();
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragmentTransaction.replace(R.id.frameLayout,userCertificate).commit();
                Toast.makeText(getApplicationContext(), "공지", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //프레그먼트 교체
    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        //첫화면 프래그먼트 지정
        fragmentTransaction.replace(R.id.frameLayout,userCertificate).commit();
    }
    @Override //메뉴설정
    public boolean onCreateOptionsMenu(Menu menu) { 
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_toolbar,menu);
        return true;
    }
    //추가된 소스, ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수

    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home: //툴바 왼쪽위 버튼(메뉴)
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

            case R.id.mypage:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "마이페이지 버튼 클릭됨", Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);

        }
    }
    @Override public void onBackPressed() { //뒤로가기 했을 때//
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

}
