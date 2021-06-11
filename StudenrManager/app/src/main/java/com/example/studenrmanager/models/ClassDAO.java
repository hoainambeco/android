package com.example.studenrmanager.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.studenrmanager.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    public static List<ClassManager> list = new ArrayList<>();
    private SQLiteDatabase db;
    private static String TABLE_NAME="ClassRoom";
    public ClassDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void setList(List<ClassManager> list) {
        this.list = list;
    }
    public int add(ClassManager cls){
        ContentValues values = new ContentValues();
        values.put("MaLop",cls.getId());
        values.put("TenLop",cls.getName());
        try {
            if (db.insert(TABLE_NAME,null,values) == -1){
                return -1;
            }
        }catch (Exception e){
            Log.e("Lỗi",e.toString());
        }
        return 1;
    }
    public int update(ClassManager cls){
        ContentValues values = new ContentValues();
        values.put("MaLop",cls.getId());
        values.put("TenLop",cls.getName());
        try {
            if (db.update(TABLE_NAME,values,"MaLop=?",new String[]{cls.getId()}) == -1){
                return -1;
            }
        }catch (Exception e){
            Log.e("Lỗi",e.toString());
        }
        return 1;
    }
    public int delete(String id){
        int pos = db.delete(TABLE_NAME,"MaLop=?",new String[]{id});
        if (pos == 0) {
            return -1;
        }
        return 1;
    }
    public int FindByID(String id){
        for (int i = 0; i < getList().size(); i++) {
            ClassManager cls = list.get(i);
            if (cls.getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
    public List<ClassManager> getList() {
        List<ClassManager> LS = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            ClassManager cls = new ClassManager();
            cls.setId(cursor.getString(0));
            cls.setName(cursor.getString(1));
            LS.add(cls);
            cursor.moveToNext();
        }
        return LS;
    }
}
