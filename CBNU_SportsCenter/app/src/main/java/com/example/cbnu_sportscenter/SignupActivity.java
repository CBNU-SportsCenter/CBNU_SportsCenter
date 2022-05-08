package com.example.cbnu_sportscenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;


public class SignupActivity extends AppCompatActivity {



    Button btn_back,btn_signup;
    TextInputLayout StudentId, Password1, Password2,
            Major, Name, Telephone,Email;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn_signup=findViewById(R.id.btn_signup);
        btn_back=findViewById(R.id.btn_back);
        StudentId=findViewById(R.id.StudentId);
        Password1=findViewById(R.id.Password1);
        Password2=findViewById(R.id.Password2);
        Name=findViewById(R.id.Name);
        Major=findViewById(R.id.Major);
        Telephone=findViewById(R.id.Telephone);
        Email=findViewById(R.id.Email);








        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentid=StudentId.getEditText().getText().toString();
                String password1=Password1.getEditText().getText().toString();
                String password2=Password2.getEditText().getText().toString();
                String name=Name.getEditText().getText().toString();
                String major=Major.getEditText().getText().toString();
                String phone=Telephone.getEditText().getText().toString();
                String email=Email.getEditText().getText().toString();



                    MyDatabaseHelper myDB=new MyDatabaseHelper(SignupActivity.this);
                   myDB.AddAccount(studentid,password1, name, major, phone, email);


            }
        });

    }
}
