package com.example.thoigianbieu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqldata extends SQLiteOpenHelper {

    private Context context;
    public Sqldata( Context context) {
        super(context, "SQL.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tbghichu=" CREATE TABLE ghichu(title text primary key, noidung text ,thoigian text)";
        db.execSQL(tbghichu);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS ghichu");

    }
}
