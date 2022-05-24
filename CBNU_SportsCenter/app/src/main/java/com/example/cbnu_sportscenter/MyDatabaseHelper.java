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
    //스포츠센터 이용인원
    private static final String TABLE_NAME1 ="USERDATABASE";
    private static final String COLUMN_ID1 ="id";
    private static final String COLUMN_TITLE="Title";
    private static final String COLUMN_SWIM="Swimcount";
    private static final String COLUMN_HEALTH="Healthcount";
    private static final String COLUMN_SQUASH="Squashcount";



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
                COLUMN_PROGRAM+" TEXT);";
        db.execSQL(query);
        String query1="CREATE TABLE "+TABLE_NAME1+
                " ("+COLUMN_ID1+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_TITLE+" TEXT, "+
                COLUMN_SWIM+" TEXT, "+
                COLUMN_HEALTH+" TEXT, "+
                COLUMN_SQUASH+" TEXT);";
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    long AddAccount(String studentid, String password, String name,String major, String program
                ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STUDENTID, studentid);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_MAJOR, major);
        cv.put(COLUMN_PROGRAM, program);


        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            return result;
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
            Toast.makeText(context, "result is"+result, Toast.LENGTH_SHORT).show();
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
    public String SportCenterUsage(String studentid){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from UserAccount where studentid = ?", //해당 studentid에 대한 행을 가져온다.
                new String[] {studentid});
        cursor.moveToFirst(); //첫번째 행을 가리킨다.-->id가 중복되게 만들지 않아서 행은 하나만 나온다.
        System.out.println(cursor.getString(5));
        return cursor.getString(5); //입력 id에 대한 신청 종목 string을 리턴한다.
    }
    long SportCenterActivity(String title,String Swimcount, String Healthcount, String Squashcount)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_TITLE,title);
        cv.put(COLUMN_SWIM, Swimcount);
        cv.put(COLUMN_HEALTH, Healthcount);
        cv.put(COLUMN_SQUASH, Squashcount);

        db.insert(TABLE_NAME1,null, cv);

        long result = db.insert(TABLE_NAME1,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            return result;
        }else {
            Toast.makeText(context, "이용조회 데이터베이스 성공", Toast.LENGTH_SHORT).show();
            Toast.makeText(context, "result is"+result, Toast.LENGTH_SHORT).show();
            return result;
        }
    }
    public Boolean checkuserdatabase(String Title) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from USERDATABASE where Title = ?", new String[]{Title});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    //각각 등록수 반환
    public String Swimeuser(String Title) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from USERDATABASE where Title = ?", new String[]{Title});
        cursor.moveToFirst(); //첫번째 행을 가리킨다.-->id가 중복되게 만들지 않아서 행은 하나만 나온다.
        return cursor.getString(2); //swim에 대한 string을 저장
    }
    public String Healtheuser(String Title) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from USERDATABASE where Title = ?", new String[]{Title});
        cursor.moveToFirst(); //첫번째 행을 가리킨다.-->id가 중복되게 만들지 않아서 행은 하나만 나온다.
        return cursor.getString(3); //헬스에 대한 string을 저장
    }
    public String Squasheuser(String Title) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from USERDATABASE where Title = ?", new String[]{Title});
        cursor.moveToFirst(); //첫번째 행을 가리킨다.-->id가 중복되게 만들지 않아서 행은 하나만 나온다.
        return cursor.getString(4); //스쿼시에 대한 string을 저장
    }
    public void UpdateSwimer(String tableName,String name,Integer num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        System.out.println("수영인원 "+num);
        ContentValues cv=new ContentValues();
        String nameArr[]={name};
        num++;
        cv.put(COLUMN_SWIM,(num).toString());
        //update
        int result=db.update(tableName,cv,"Title= ? ",nameArr); //수영 이름에 대한 이용인원 숫자 증가 update
        System.out.println("업데이트 성공! : "+num);
    }
}
