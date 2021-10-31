package com.example.test2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TestContronl {
    public static final String SQL_TABLE_TEST2 = "CREATE TABLE Test(cannang varchar , date Date )";
    public static final  String TABLE_NAME = "Test";
    public TestSQL testSQL;
    public SQLiteDatabase db;
    private Context context;

    public TestContronl(Context context) {
        this.context = context;
        testSQL = new TestSQL(context);
        db = testSQL.getWritableDatabase();
    }
    public int Insert(test2 test2){
        ContentValues values = new ContentValues();
        values.put("cannang" , test2.CanNang);
        values.put("date" , test2.date);
        if(db.insert(TABLE_NAME , null , values) < 0){
            return -1;
        }else{
            return 1;
        }
    }

    public List<test2> Select(){
        List<test2> list = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME , null, null , null , null , null , null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            test2 test = new test2();
            test.CanNang = Float.parseFloat((cursor.getString(0)));
            test.date = (cursor.getString(1));
            list.add(test);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public int Delate(test2 test){
        if(db.delete(TABLE_NAME , "date=?" , new String[]{test.date}) < 0){
            return -1;
        }else{
            return 1;
        }
    }

    public int Edit(test2 test2){
        ContentValues values = new ContentValues();
        values.put("cannang" , test2.CanNang);
        values.put("date" , test2.date);
        if(db.update(TABLE_NAME , values , "date=?" , new String[]{test2.date}) < 0){
            return -1;
        }else{
            return 1;
        }
    }
}
