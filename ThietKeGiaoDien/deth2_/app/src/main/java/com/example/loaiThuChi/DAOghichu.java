package com.example.loaiThuChi;

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
        values.put("id", ghichu.getId());
        values.put("title" , ghichu.getTitle());
        values.put("noidung",ghichu.getNoidung());
        values.put("loaiThuChi",ghichu.getLoaiThuChi());

        long result= database.insert("ghichu",null,values);
        return result;
    }
    public long update(Ghichu ghichu){
        SQLiteDatabase database=sqldata.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("title" , ghichu.getTitle());
        values.put("noidung",ghichu.getNoidung());
        values.put("loaiThuChi",ghichu.getLoaiThuChi());

        long result= database.update("ghichu",values,"id=?",new String[]{String.valueOf(ghichu.getId())});

        return result;
    }
    public long delete(int id){
        SQLiteDatabase database=sqldata.getWritableDatabase();

        long result= database.delete("ghichu","id=?",new String[]{String.valueOf(id)});

        return result;
    }
    public ArrayList<Ghichu> getall(){
        SQLiteDatabase database=sqldata.getReadableDatabase();
        ArrayList<Ghichu> list=new ArrayList<>();
        Cursor cursor= database.rawQuery(" SELECT * FROM ghichu ",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id=cursor.getInt(0);
            String title= cursor.getString(2);
            String nd = cursor.getString(3);
            String time = cursor.getString(1);

            Ghichu ghichu=new Ghichu(id,title,nd,time);
            list.add(ghichu);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
