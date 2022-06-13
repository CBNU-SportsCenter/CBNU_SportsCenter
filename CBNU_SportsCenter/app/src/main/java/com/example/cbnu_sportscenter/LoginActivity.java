package com.example.cbnu_sportscenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        Studentid = findViewById(R.id.Studentid);
        Password = findViewById(R.id.Password);
        DB = new MyDatabaseHelper(this);
        btn_signup = findViewById(R.id.btn_signup);
        btn_login = findViewById(R.id.btn_login);


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String studentid = Studentid.getEditText().getText().toString();
                String password = Password.getEditText().getText().toString();
                int id;
                if (studentid.equals("") || password.equals(""))
                    Toast.makeText(LoginActivity.this, "입력을 확인해주세요!", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkstudentidpassword(studentid, password);
                    if (checkuserpass == true) {
                        Intent intent = new Intent(getApplicationContext(), MainPageActivity.class);
                        MyDatabaseHelper dbHelper = new MyDatabaseHelper(LoginActivity.this);
                        SQLiteDatabase MyDB = dbHelper.getWritableDatabase();

                        Cursor cursor = MyDB.rawQuery("Select * from UserAccount where studentid = ?",
                                new String[]{studentid});
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();


                            if (cursor.getCount() > 0) {
                                cursor.moveToFirst();


                                //intent.putExtra("id",cursor.getInt(0));
                                intent.putExtra("studentid",cursor.getString(1));
                              /*  intent.putExtra("password",cursor.getString(2));
                                intent.putExtra("name",cursor.getString(3));
                                intent.putExtra("major",cursor.getString(4));
                                intent.putExtra("program",cursor.getString(5));

                            */


                            }
                           else {

                                Toast.makeText(LoginActivity.this, "LoginPageActivity cursor 0", Toast.LENGTH_SHORT).show();
                            }


                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "cursor count 0", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
                        ((Studentid)getApplication()).setData(studentid); //해당 아이디로 들어왔을때 아이디를 유지하기위해 선언
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "로그인 실패!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

