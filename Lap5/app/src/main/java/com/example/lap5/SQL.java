package com.example.lap5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQL extends SQLiteOpenHelper {
    public static final String DBNAME="QLBanHang";
    public static  final int version = 1;
    public static final  String TABLE_NAME = "PRODUCT";
    public SQL(Context context) {
        super(context, DBNAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ProductDAO.CREATEBASE_TABLE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS TABLE_NAME");
        this.onCreate(db);
    }
}
