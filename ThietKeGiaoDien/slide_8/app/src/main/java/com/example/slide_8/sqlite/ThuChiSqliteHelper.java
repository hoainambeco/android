package com.example.slide_8.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ThuChiSqliteHelper extends SQLiteOpenHelper {


    String create_table_thu_chi ="KhoanthuChi";
    String create_table_loai_thu_chi ="LoaithuChi";

    public ThuChiSqliteHelper(Context context) {
        super(context, "sql.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table_loai_thu_chi);
        db.execSQL(create_table_thu_chi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
