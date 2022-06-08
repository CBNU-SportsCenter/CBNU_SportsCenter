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
    //스포츠센터 이용인원
    private static final String TABLE_NAME1 ="USERDATABASE";
    private static final String COLUMN_ID1 ="id";
    private static final String COLUMN_TITLE="Title";
    private static final String COLUMN_SWIM="Swimcount";
    private static final String COLUMN_HEALTH="Healthcount";
    private static final String COLUMN_SQUASH="Squashcount";

    private static final String TABLE_NAME2="ExerciseTime";
    private static final String COLUMN_ID2="id";
    private static final String COLUMN_STUDENTID2="studentid";
    private static final String COLUMN_YEAR="year";
    private static final String COLUMN_MONTH="month";
    private static final String COLUMN_DAY="day";
    private static final String COLUMN_TIME="time";



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

        String query2="CREATE TABLE "+TABLE_NAME2+" ("+COLUMN_ID2+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_STUDENTID2+" TEXT, "+
                COLUMN_YEAR+" TEXT, "+
                COLUMN_MONTH+" TEXT, "+
                COLUMN_DAY+" TEXT, "+
                COLUMN_TIME+" TEXT);";


        db.execSQL(query2);
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
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME2);
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME1);
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
            Toast.makeText(context, "회원가입 실패!", Toast.LENGTH_SHORT).show();
            return result;
        }else {
            Toast.makeText(context, "회원가입 성공!", Toast.LENGTH_SHORT).show();
            return result;
        }
    }

    long addExerciseTime(String studentid, String year, String month,String day, String time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STUDENTID2, studentid);
        cv.put(COLUMN_YEAR, year);
        cv.put(COLUMN_MONTH, month);
        cv.put(COLUMN_DAY, day);
        cv.put(COLUMN_TIME, time);






        long result = db.insert(TABLE_NAME2,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            return result;
        }else {
            Toast.makeText(context, "운동시간 등록!", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(context, "수정 실패!", Toast.LENGTH_SHORT).show();
            return result;
        }else {
            Toast.makeText(context, "수정 완료!", Toast.LENGTH_SHORT).show();
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
            //Toast.makeText(context, "이용조회 데이터베이스 성공", Toast.LENGTH_SHORT).show();
            //Toast.makeText(context, "result is"+result, Toast.LENGTH_SHORT).show();
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
    public String Weighteuser(String Title) {
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
        System.out.println("수영입장 성공! : "+num);
    }
    public void DownGradeSwimer(String tableName,String name,Integer num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        System.out.println("수영인원 "+num);
        ContentValues cv=new ContentValues();
        String nameArr[]={name};
        num--;
        cv.put(COLUMN_SWIM,(num).toString());
        //update
        int result=db.update(tableName,cv,"Title= ? ",nameArr); //수영 이름에 대한 이용인원 숫자 증가 update
        System.out.println("수영퇴실 성공! 수영인원 : "+num);
    }
    public void UpdateWeigther(String tableName,String name,Integer num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        System.out.println("헬스인원 "+num);
        ContentValues cv=new ContentValues();
        String nameArr[]={name};
        num++;
        cv.put(COLUMN_HEALTH,(num).toString());
        //update
        int result=db.update(tableName,cv,"Title= ? ",nameArr); //수영 이름에 대한 이용인원 숫자 증가 update
        System.out.println("헬스입장 성공!  헬스인원: "+num);
    }
    public void DownGradeWeigther(String tableName,String name,Integer num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        System.out.println("헬스인원 "+num);
        ContentValues cv=new ContentValues();
        String nameArr[]={name};
        num--;
        cv.put(COLUMN_HEALTH,(num).toString());
        //update
        int result=db.update(tableName,cv,"Title= ? ",nameArr); //수영 이름에 대한 이용인원 숫자 증가 update
        System.out.println("헬스퇴실 성공! 헬스인원: "+num);
    }
    public void UpdateSquasher(String tableName,String name,Integer num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        System.out.println("스쿼시인원 "+num);
        ContentValues cv=new ContentValues();
        String nameArr[]={name};
        num++;
        cv.put(COLUMN_SQUASH,(num).toString());
        //update
        int result=db.update(tableName,cv,"Title= ? ",nameArr); //수영 이름에 대한 이용인원 숫자 증가 update
        System.out.println("스쿼시입장 성공! 스쿼시 인원: "+num);
    }
    public void DownGradeSquasher(String tableName,String name,Integer num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        System.out.println("스쿼시인원 "+num);
        ContentValues cv=new ContentValues();
        String nameArr[]={name};
        num--;
        cv.put(COLUMN_SQUASH,(num).toString());
        //update
        int result=db.update(tableName,cv,"Title= ? ",nameArr); //수영 이름에 대한 이용인원 숫자 증가 update
        System.out.println("스쿼시입장 성공! : "+num);
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
    public void EnterUpdate(String tableName,String name,Integer enter1)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        System.out.println("입장");
        ContentValues cv=new ContentValues();
        String nameArr[]={name};
        enter1=1;
        cv.put(COLUMN_ENTER,(enter1).toString());
        //update
        int result=db.update(tableName,cv,"studentid= ? ",nameArr); //수영 이름에 대한 이용인원 숫자 증가 update
        System.out.println("입장 성공! : "+enter1);
    }

    public void ExitUpdate(String tableName,String name,Integer enter1)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        System.out.println("퇴실");
        ContentValues cv=new ContentValues();
        String nameArr[]={name};
        enter1=0;
        cv.put(COLUMN_ENTER,(enter1).toString());
        //update
        int result=db.update(tableName,cv,"studentid= ? ",nameArr); //수영 이름에 대한 이용인원 숫자 증가 update
        System.out.println("퇴실 성공! : "+enter1);
    }


    public Cursor getExerciseInfo(String studentid){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from ExerciseTime where studentid = ?",new String[] {studentid});
            return cursor;


    }

}
