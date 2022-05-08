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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {



    Button btn_back,btn_signup;
    private FirebaseAuth mFirebaseAuth; //파이어베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스
    TextInputLayout ID,Password1, Password2,
            StudentId,Major,Telephone,Email;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btn_signup=findViewById(R.id.btn_signup);
        btn_back=findViewById(R.id.btn_back);
        ID=findViewById(R.id.ID);
        Password1=findViewById(R.id.Password1);
       /* Password2=findViewById(R.id.Password2);
        StudentId=findViewById(R.id.StudentId);
        Major=findViewById(R.id.Major);
        Telephone=findViewById(R.id.Telephone);
        Email=findViewById(R.id.Email);*/
        mFirebaseAuth=FirebaseAuth.getInstance();
       // mDatabaseRef=FirebaseDatabase.getInstance().getReference("sangdroid");

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
                String id=ID.getEditText().getText().toString();
                String password=Password1.getEditText().getText().toString();


                mFirebaseAuth.createUserWithEmailAndPassword(id,password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"할로우",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"노할로우",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}
