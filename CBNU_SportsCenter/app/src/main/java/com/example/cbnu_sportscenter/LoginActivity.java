package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    Button btn_signup,btn_login;
    TextInputLayout Studentid, Password;
    MyDatabaseHelper DB;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Studentid=findViewById(R.id.Studentid);
        Password=findViewById(R.id.Password);
        DB = new MyDatabaseHelper(this);
        btn_signup=findViewById(R.id.btn_signup);
        btn_login=findViewById(R.id.btn_login);




        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  String studentid=Studentid.getEditText().getText().toString();
                  String password=Password.getEditText().getText().toString();

                if(studentid.equals("")||password.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkstudentidpassword(studentid, password);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        ( (Studentid)getApplication()).setData(studentid); //해당 아이디로 들어왔을때 아이디를 유지하기위해 선언
                        //System.out.println(( (Studentid)getApplication()).getData()); //아이디 값이 잘 넘어오는것을 확인
                        Intent intent  = new Intent(getApplicationContext(), MainPageActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });





    }
}
