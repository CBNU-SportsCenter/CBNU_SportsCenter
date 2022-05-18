package com.example.cbnu_sportscenter;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class test extends AppCompatActivity {

    TextView textview;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        textview=findViewById(R.id.textView5);
        setInfo();
    }

    public void setInfo(){
        MyDatabaseHelper dbHelper=new MyDatabaseHelper(this);
        SQLiteDatabase MyDB = dbHelper.getWritableDatabase();

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String studentid=bundle.getString("studentid");
        String password=bundle.getString("password");



        Cursor cursor = MyDB.rawQuery("Select * from UserAccount where studentid = ?",
                new String[] {studentid});

        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            textview.setText(cursor.getString(0)+"/"+cursor.getString(1)+"/"+cursor.getString(2)+"/"+
                    cursor.getString(3)+"/"+cursor.getString(4)+"/"+cursor.getString(5));

        }
        else{
            Toast.makeText(test.this, "all the fields"+cursor.getCount(), Toast.LENGTH_SHORT).show();

        }



    }
}
