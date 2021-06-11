package com.example.studenrmanager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "SVManager";
    public static final int version_DB = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, version_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CLASSROOM = "CREATE TABLE ClassRoom(MaLop text primary key,TenLop text)";
        String SQL_STUDENT = "CREATE TABLE student(name text,NgaySinh text, idClass text)";
        db.execSQL(SQL_CLASSROOM);
        db.execSQL(SQL_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ClassRoom");
        onCreate(db);
    }
}
