package com.example.test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AndroidControl {
    public static final String SQL_TABLE_ANDROID = "CREATE TABLE Android(id varchar primary key , ten varchar , ngay date )";
    public static final String TABLE_NAME = "Android";
    public AndroidSQL androidSQL;
    public SQLiteDatabase db;
    private Context context;
    public AndroidControl(Context context){
        this.context = context;
        androidSQL = new AndroidSQL(context);
        db = androidSQL.getWritableDatabase();
    }

    public int Insert(Android android){
        ContentValues values = new ContentValues();
        values.put("id" , android.id);
        values.put("ten" , android.ten);
        values.put("ngay" , android.ngay);
        if(db.insert(TABLE_NAME , null , values) < 0){
            return -1;
        }else{
            return 1;
        }
    }

    public List<Android> Select(){
        List<Android> list = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME , null, null , null , null , null , null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            Android android = new Android();
            android.id = (cursor.getString(0));
            android.ten = (cursor.getString(1));
            android.ngay = (cursor.getString(2));
            list.add(android);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public int Delate(Android android){
        if(db.delete(TABLE_NAME , "id=?" , new String[]{android.id}) < 0){
            return -1;
        }else{
            return 1;
        }
    }

    public int Edit(Android android){
        ContentValues values = new ContentValues();
        values.put("id" , android.id);
        values.put("ten" , android.ten);
        values.put("ngay" , android.ngay);
        if(db.update(TABLE_NAME , values , "id=?" , new String[]{android.id}) < 0){
            return -1;
        }else{
            return 1;
        }
    }
}
