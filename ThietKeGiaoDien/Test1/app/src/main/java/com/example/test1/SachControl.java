package com.example.test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SachControl {
    public static final String SQL_TABLE_SACH =
            "CREATE TABLE Sach(id varchar primary key , ten varchar , loai varchar )";
    public static final String TABLE_NAME = "Sach";
    public SachSQL  sachSQL;
    public SQLiteDatabase db;
    private Context context;
    public SachControl(Context context){
        this.context = context;
        sachSQL = new SachSQL(context);
        db = sachSQL.getWritableDatabase();
    }

    public int Insert(Sach sach){
        ContentValues values = new ContentValues();
        values.put("id" , sach.id);
        values.put("ten" , sach.ten);
        values.put("loai" , sach.loai);
        if(db.insert(TABLE_NAME , null , values) < 0){
            return -1;
        }else{
            return 1;
        }
    }

    public List<Sach> Select(){
        List<Sach> list = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME , null, null , null , null , null , null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            Sach sach = new Sach();
            sach.id = (cursor.getString(0));
            sach.ten = (cursor.getString(1));
            sach.loai = (cursor.getString(2));
            list.add(sach);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public int Delate(Sach sach){
        if(db.delete(TABLE_NAME , "id=?" , new String[]{sach.id}) < 0){
            return -1;
        }else{
            return 1;
        }
    }

    public int Edit(Sach sach){
        ContentValues values = new ContentValues();
        values.put("id" , sach.id);
        values.put("ten" , sach.ten);
        values.put("loai" , sach.loai);
        if(db.update(TABLE_NAME , values , "id=?" , new String[]{sach.id}) < 0){
            return -1;
        }else{
            return 1;
        }
    }
}
