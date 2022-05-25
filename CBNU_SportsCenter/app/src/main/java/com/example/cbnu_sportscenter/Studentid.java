package com.example.cbnu_sportscenter;

import android.app.Application;

public class Studentid extends Application {
    private String Id;
    private Integer Swim;
    private boolean info;
    private boolean database;
    public Studentid() {
        Id = "";
        Swim = 0;
        info=false;
        database=false;
    }
    public String getData()
    {
        return Id;
    }
    public void setData(String Id)
    {
        this.Id = Id;
    }
    public  Integer SwimgetData(){return Swim;}
    public void SwimsetData(Integer Swim){ this.Swim = Swim;}
    public boolean getuseData(){return  info;}
    public  void setuseData(boolean info){this.info=info;}

    public boolean getdatabase(){return database;}
    public void setdatabase(boolean database){this.database=database;}
}
