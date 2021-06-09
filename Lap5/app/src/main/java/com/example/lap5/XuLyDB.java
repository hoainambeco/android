package com.example.lap5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class XuLyDB {
    private Context context;
    SQLiteOpenHelper helper;
    SQLiteDatabase db;
    public static final String SQL_TaoBang
            ="CREATE TABLE Contact(Id text primary key,Name text,Price real, Image)";
    public XuLyDB(Context context, SQLiteOpenHelper helper, SQLiteDatabase db) {
        this.context = context;
        this.helper = helper;
        this.db = db;
    }

}
