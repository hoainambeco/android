package com.example.myapplicationoto.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplicationoto.database.Database;
import com.example.myapplicationoto.dto.OTo;

import java.util.ArrayList;

public class OToDAO {
    SQLiteDatabase sqLiteDatabase;
    Context context;
    Database database;

    public OToDAO(Context context) {
        this.context = context;
        database = new Database(context);
        sqLiteDatabase = database.getWritableDatabase();
    }
    public static final String TABLE_NAME_OTO = Database.TABLE_NAME_OTO;

    public long them_oto(OTo oTo){
        ContentValues values = new ContentValues();
        values.put("id_oto", oTo.getId_oto());
        values.put("ma_oto", oTo.getMa_oto());
        values.put("gia_oto", oTo.getGia_oto());
        long kq = sqLiteDatabase.insert(TABLE_NAME_OTO,null,values);
        if(kq >0){
            Log.e("Them", "thanh cong");
        }else {
            Log.e("Them", " khong thanh cong");
        }
        return kq;
    }

    public long sua_oto(OTo oTo){
        ContentValues values = new ContentValues();
        values.put("ma_oto", oTo.getMa_oto());
        values.put("gia_oto", oTo.getGia_oto());
        long kq = sqLiteDatabase.update(TABLE_NAME_OTO,values, "id_oto=?",new String[]{oTo.getId_oto() + ""});
        if(kq >0){
            Log.e("sua", "thanh cong");
        }else {
            Log.e("sua", " khong thanh cong");
        }
        return kq;
    }

    public long xoa_oto(OTo oTo){
        ContentValues values = new ContentValues();
        long kq = sqLiteDatabase.delete(TABLE_NAME_OTO,"id_oto=?",new String[]{oTo.getId_oto() + ""});
        if(kq >0){
            Log.e("sua", "thanh cong");
        }else {
            Log.e("sua", " khong thanh cong");
        }
        return kq;
    }

    public ArrayList<OTo> danh_sach_oto() {
        ArrayList<OTo> list_oto = new ArrayList<OTo>();
        String getAll = "select*from " + TABLE_NAME_OTO;
        Cursor cursor = sqLiteDatabase.rawQuery(getAll, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id_oto = cursor.getString(0);
                String ma_oto = cursor.getString(1);
                String gia_oto = cursor.getString(2);

                OTo oTo = new OTo(id_oto, ma_oto, gia_oto);
                list_oto.add(oTo);
                cursor.moveToNext();
            }
        }
        return list_oto;
    }

}
