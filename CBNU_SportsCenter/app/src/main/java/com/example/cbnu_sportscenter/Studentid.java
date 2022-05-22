package com.example.cbnu_sportscenter;

import android.app.Application;

public class Studentid extends Application {
    private String Id;
    public String getData()
    {
        return Id;
    }
    public void setData(String Id)
    {
        this.Id = Id;
    }
}
