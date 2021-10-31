package com.example.thoigianbieu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAOghichu {
    Sqldata sqldata;

    public DAOghichu(Context context){
        sqldata=new Sqldata(context);
    }
    public long insert(Ghichu ghichu){
        SQLiteDatabase database=sqldata.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("title" , ghichu.getTitle());
        values.put("noidung",ghichu.getNoidung());
        values.put("thoigian",ghichu.getThoigian());

        long result= database.insert("ghichu",null,values);
        return result;
    }
    public long update(Ghichu ghichu){
        SQLiteDatabase database=sqldata.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("title" , ghichu.getTitle());
        values.put("noidung",ghichu.getNoidung());
        values.put("thoigian",ghichu.getThoigian());

        long result= database.update("ghichu",values,"title=?",new String[]{ghichu.getTitle()});

        return result;
    }
    public long delete(Ghichu ghichu){
        SQLiteDatabase database=sqldata.getWritableDatabase();

        long result= database.delete("ghichu","title=?",new String[]{ghichu.getTitle()});

        return result;
    }
    public ArrayList<Ghichu> getall(){
        SQLiteDatabase database=sqldata.getReadableDatabase();
        ArrayList<Ghichu> list=new ArrayList<>();
        Cursor cursor= database.rawQuery(" SELECT * FROM ghichu ",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String title= cursor.getString(1);
            String nd = cursor.getString(2);
            String time = cursor.getString(0);

            Ghichu ghichu=new Ghichu(title,nd,time);
            list.add(ghichu);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
