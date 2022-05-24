package com.example.cbnu_sportscenter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
    private static final String COLUMN_PROGRAM="program";
    private static final String COLUMN_ENTER="enter";




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
                COLUMN_PROGRAM+" TEXT, "+
                COLUMN_ENTER+" TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    long addAccount(String studentid, String password, String name,String major, String program
                    ,String enter
                ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STUDENTID, studentid);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_MAJOR, major);
        cv.put(COLUMN_PROGRAM, program);
        cv.put(COLUMN_ENTER, enter);


        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            return result;
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
            return result;
        }
    }


    long updateAccount(String studentid, String password, String name, String major, String program){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_STUDENTID, studentid);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_MAJOR, major);
        cv.put(COLUMN_PROGRAM, program);

        long result = db.update(TABLE_NAME, cv, "studentid=?", new String[]{studentid});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            return result;
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
            return result;
        }

    }


    public Boolean checkuserstudentid(String studentid) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from UserAccount where studentid = ?", new String[]{studentid});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkstudentidpassword(String studentid, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from UserAccount where studentid = ? and password = ?",
                new String[] {studentid,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public String getName(String studentid){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from UserAccount where studentid = ?",new String[] {studentid});

        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            return cursor.getString(3);
        }

        else{
            return "error";
        }
    }

    public String getMajor(String studentid){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from UserAccount where studentid = ?",new String[] {studentid});

        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            return cursor.getString(4);
        }

        else{
            return "error";
        }
    }

    public String getProgram(String studentid){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from UserAccount where studentid = ?",new String[] {studentid});

        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            return cursor.getString(5);
        }

        else{
            return "error";
        }
    }
    public String getPassword(String studentid){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from UserAccount where studentid = ?",new String[] {studentid});

        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            return cursor.getString(2);
        }

        else{
            return "error";
        }
    }


    public String getEnter(String studentid){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from UserAccount where studentid = ?",new String[] {studentid});

        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            return cursor.getString(6);
        }

        else{
            return "error";
        }
    }

}
