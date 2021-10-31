package com.example.myapplicationoto.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    Context context;
    public static final String DATABASE_NAME = "thuchanh";
    public  static final int VERSION_DB = 1;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_DB);
        this.context = context;
    }
    public static final String TABLE_NAME_OTO = "oto";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_OTO = "create table " + TABLE_NAME_OTO + "(" +
                "id_oto integer primary key ," +
                "ma_oto integer, " +
                "gia_oto integer)";
        db.execSQL(TABLE_OTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
