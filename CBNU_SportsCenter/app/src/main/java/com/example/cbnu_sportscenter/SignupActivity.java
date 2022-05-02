package com.example.cbnu_sportscenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {

    private EditText et_id, et_pw, et_pw2, et_name, et_phone, et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button btn_signup=findViewById(R.id.btn_signup);
        Button btn_back=findViewById(R.id.btn_back);
        et_id=findViewById(R.id.et_id);
        et_pw=findViewById(R.id.et_pw);
        et_pw2=findViewById(R.id.et_pw2);
        et_name=findViewById(R.id.et_name);
        et_phone=findViewById(R.id.et_phone);
        et_email=findViewById(R.id.et_email);


        //뒤로가기 버튼 클릭 시 수행
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


        //회원가입 버튼 클릭 시 수행
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //EditText에 현재 입력되어있는 값을 get(가져온다)
                String userID=et_id.getText().toString();
                String userPass=et_pw.getText().toString();
                String userPass2=et_pw2.getText().toString();
                String userName=et_name.getText().toString();
                String userEmail=et_email.getText().toString();
                int userPhone=Integer.parseInt(et_phone.getText().toString());


                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success=jsonObject.getBoolean("success");
                            if(success){    //회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(),"회원등록에 성공하였습니다",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            } else{ //회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(),"회원등록에 실패하였습니다",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 Volley를 이용해서 요청을 함
                RegisterRequest registerRequest=new RegisterRequest(userID, userPass,userName,userEmail,userPhone,responseListener);
                RequestQueue queue= Volley.newRequestQueue(SignupActivity.this);
                queue.add(registerRequest);

            }
        });


    }
}
