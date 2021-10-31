package com.example.test1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AndroidSQL extends SQLiteOpenHelper {
    private Context context;
    public static final String DB_NAME = "AndroidSQL";
    public static int VERSION = 1;

    public AndroidSQL(Context context){
        super(context, DB_NAME , null , VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AndroidControl.SQL_TABLE_ANDROID);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + AndroidControl.TABLE_NAME);
    }
}
