package com.example.namhoainguyen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Control {
    public static final String SQL_TABLE = "CREATE TABLE DoiTuong(id varchar primary key , TieuDe varchar ,NoiDung varchar, ThoiGian date )";
    public static final String TABLE_NAME ="DoiTuong";
    public DoiTuongSQL sql;
    public SQLiteDatabase sqLiteDatabase;
    private Context context;

    public Control(Context context) {
        this.context = context;
        sql = new DoiTuongSQL(context);
        sqLiteDatabase =  sql.getWritableDatabase();
    }
    public int Insert(DoiTuong doiTuong){
        ContentValues values = new ContentValues();
        values.put("id", doiTuong.id);
        values.put("TieuDe", doiTuong.TieuDe);
        values.put("NoiDung", doiTuong.NoiDung);
        values.put("ThoiGian", doiTuong.ThoiGian);
        if (sqLiteDatabase.insert(TABLE_NAME, null, values) < 0){
            return -1;
        }
        else return 1;
    }

    public List<DoiTuong> Select(){
        List<DoiTuong> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null, null, null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            DoiTuong doiTuong = new DoiTuong();
            doiTuong.id = Integer.parseInt(cursor.getString(0));
            doiTuong.TieuDe=(cursor.getString(1));
            doiTuong.NoiDung=(cursor.getString(2));
            doiTuong.ThoiGian=(cursor.getString(3));
        }
        cursor.close();
        return list;
    }

    public int Delete(DoiTuong doiTuong){
        if(sqLiteDatabase.delete(TABLE_NAME , "id=?" , new String[]{String.valueOf(doiTuong.id)}) < 0){
            return -1;
        }else{
            return 1;
        }
    }

    public int Edit(DoiTuong doiTuong){
        ContentValues values = new ContentValues();
        values.put("id", doiTuong.id);
        values.put("TieuDe", doiTuong.TieuDe);
        values.put("NoiDung", doiTuong.NoiDung);
        values.put("ThoiGian", doiTuong.ThoiGian);
        if(sqLiteDatabase.update(TABLE_NAME , values , "id=?" , new String[]{String.valueOf(doiTuong.id)}) < 0){
            return -1;
        }else{
            return 1;
        }
    }
}
