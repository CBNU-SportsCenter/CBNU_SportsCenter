package com.example.cbnu_sportscenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;


public class SignupActivity extends AppCompatActivity {



    Button btn_back,btn_signup;
    TextInputLayout StudentId, Password1, Password2,
            Major, Name;
    MyDatabaseHelper DB;
    Spinner Spn;
    ArrayAdapter arrayAdapter;

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
        Spn=findViewById(R.id.spn);
        DB = new MyDatabaseHelper(this);



        setViews();








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
                String studentid=StudentId.getEditText().getText().toString().trim();
                String password1=Password1.getEditText().getText().toString().trim();
                String password2=Password2.getEditText().getText().toString().trim();
                String name=Name.getEditText().getText().toString().trim();
                String major=Major.getEditText().getText().toString().trim();
                String program=Spn.getSelectedItem().toString();

                if(studentid.equals("") || password1.equals("") || password2.equals("") ||
                        name.equals("") || major.equals("") )
                    Toast.makeText(SignupActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(password1.equals(password2)){
                        Boolean checkstudentid = DB.checkuserstudentid(studentid);
                        if(checkstudentid==false){
                           /* MyDatabaseHelper myDB=new MyDatabaseHelper(SignupActivity.this);
                            myDB.AddAccount(studentid,password1, name, major, phone, email);*/
                        long result=DB.addAccount(studentid,password1, name, major, program);
                        if(result!=-1)
                        {
                            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);
                        }

                        }
                        else{
                            Toast.makeText(SignupActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignupActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }

    public void setViews(){
        arrayAdapter=ArrayAdapter.createFromResource(this,R.array.programs,android.R.layout.simple_spinner_dropdown_item);
        Spn.setAdapter(arrayAdapter);
    }

}
