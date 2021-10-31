package com.example.namnhph14161;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class OopControl {
    //cần đổi theo đề
    public static final String SQL_TABLE_OOP =
            "CREATE TABLE Sach(c varchar primary key , CanNang varchar  , date Date )";
    public static final  String TABLE_NAME = "Oop";
    public OopSQL oopSQL;
    public SQLiteDatabase db;
    private Context context;

    public OopControl(Context context) {
        this.context = context;
        oopSQL = new OopSQL(context);
        db = oopSQL.getWritableDatabase();
    }
    public int Insert(Oop oop){
        ContentValues values = new ContentValues();
        values.put("id",oop.id);
        values.put("CanNang" , oop.CanNang);
        values.put("date" , oop.date);
        if(db.insert(TABLE_NAME , null , values) < 0){
            return -1;
        }else{
            return 1;
        }
    }

    public List<Oop> Select(){
        List<Oop> list = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME , null, null , null , null , null , null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            Oop oop = new Oop();
            oop.id= (cursor.getString(0));
            oop.CanNang = Float.parseFloat((cursor.getString(1)));
            oop.date = (cursor.getString(2));
            list.add(oop);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public int Delate(Oop oop){
        if(db.delete(TABLE_NAME , "id=?" , new String[]{oop.date}) < 0){
            return -1;
        }else{
            return 1;
        }
    }

    public int Edit(Oop oop){
        ContentValues values = new ContentValues();
        values.put("id" , oop.id);
        values.put("CanNang" , oop.CanNang);
        values.put("date" , oop.date);
        if(db.update(TABLE_NAME , values , "id=?" , new String[]{oop.date}) < 0){
            return -1;
        }else{
            return 1;
        }
    }
}
