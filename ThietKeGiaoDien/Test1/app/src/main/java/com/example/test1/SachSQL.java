package com.example.test1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SachSQL extends SQLiteOpenHelper {
    private Context context;
    public static final String DB_NAME = "SachSQL";
    public static int VERSION = 1;

    public SachSQL(Context context){
        super(context, DB_NAME , null , VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SachControl.SQL_TABLE_SACH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + SachControl.TABLE_NAME);
    }
}
