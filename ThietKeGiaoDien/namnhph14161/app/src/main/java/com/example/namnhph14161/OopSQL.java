package com.example.namnhph14161;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class OopSQL extends SQLiteOpenHelper {
//    private Context context;
    public static final String DB_NAME = "OopSQL";
    public static int VERSION = 1;

    public OopSQL(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(OopControl.SQL_TABLE_OOP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + OopControl.TABLE_NAME);
    }
}
