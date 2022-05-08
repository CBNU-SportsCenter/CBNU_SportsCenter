package com.example.cbnu_sportscenter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME="Sportscenter.db";
    private static final int DATABASE_VERSION=1;

    private static final String TABLE_NAME="UserAccount";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_STUDENTID="studentid";
    private static final String COLUMN_PASSWORD="password";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_MAJOR="major";
    private static final String COLUMN_PHONE="phone";
    private static final String COLUMN_EMAIL="email";



    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_STUDENTID+" TEXT, "+
                COLUMN_PASSWORD+" TEXT, "+
                COLUMN_NAME+" TEXT, "+
                COLUMN_MAJOR+" TEXT, "+
                COLUMN_PHONE+" TEXT, "+
                COLUMN_EMAIL+" TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    void AddAccount(String studentid, String password, String name,String major,
                String phone, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STUDENTID, studentid);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_MAJOR, major);
        cv.put(COLUMN_PHONE, phone);
        cv.put(COLUMN_EMAIL, email);

        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

}
