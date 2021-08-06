package com.example.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SVControl {
    public static final String SQL_TABLE_SV =
            "CREATE TABLE SinhVien(id varchar  primary key , name varchar , diem integer  )";
    public static final String TABLE_NAME = "SinhVien";
    public SVSQL SQlite;
    public SQLiteDatabase db;
    private Context context;
    public SVControl(Context context){
        this.context = context;
        SQlite = new SVSQL(context);
        db = SQlite.getWritableDatabase();
    }

    public int InsertSV(SinhVien sv){
        ContentValues values = new ContentValues();
        values.put("id",sv.id);
        values.put("name",sv.name);
        values.put("diem",sv.number);
        if(db.insert(TABLE_NAME,null,values) < 0){
            return -1;
        }else{
            return  1;
        }
    }

    public List<SinhVien> SelectSV(){
        List<SinhVien> dsSV = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            SinhVien sv = new SinhVien();
            sv.id=(cursor.getString(0));
            sv.name=(cursor.getString(1));
            sv.number=(cursor.getString(2));
            dsSV.add(sv);
            cursor.moveToNext();
        }
        cursor.close();
        return dsSV;
    }

    public int DeleteSV(SinhVien sv){
        if(db.delete(TABLE_NAME,"id=?",new String[]{sv.id}) < 0){
            return -1;
        }else{
            return 1;
        }
    }

    public int EditSV(SinhVien sv) {
        ContentValues values = new ContentValues();
        values.put("id", sv.id);
        values.put("name", sv.name);
        values.put("diem", sv.number);
        if (db.update(TABLE_NAME, values, "id=?", new String[]{sv.id}) < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
