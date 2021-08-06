package com.example.lab3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SVSQL extends SQLiteOpenHelper {
    private Context context;
    public static final String DB_NAME = "db.dat";
    public static int VERSION =1;
    public SVSQL(Context context){
        super(context, DB_NAME, null, VERSION);
        this.context  = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SVControl.SQL_TABLE_SV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + SVControl.TABLE_NAME);
    }
}
