package com.example.studenrmanager.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.studenrmanager.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static List<Student> list = new ArrayList<>();
    private SQLiteDatabase db;
    private static String TABLE_NAME="student";
    public StudentDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }


    public int add(Student st){
        ContentValues values = new ContentValues();
        values.put("name",st.getName());
        values.put("NgaySinh",st.getNgaySinh());
        values.put("idClass",st.getIdClass());
        try {
            if (db.insert(TABLE_NAME,null,values) == -1){
                return -1;
            }
        }catch (Exception e){
            Log.e("Lỗi",e.toString());
        }
        return 1;
    }
    public void setList(List<Student> list) {
        this.list = list;
    }
    public int update(Student st){
        ContentValues values = new ContentValues();
        values.put("name",st.getName());
        values.put("NgaySinh",st.getNgaySinh());
        values.put("idClass",st.getIdClass());
        try {
            if (db.update(TABLE_NAME,values,"MaLop=?",new String[]{st.getIdClass()}) == -1){
                return -1;
            }
        }catch (Exception e){
            Log.e("Lỗi",e.toString());
        }
        return 1;
    }
    public int delete(String ngaysinh){
        int pos = db.delete(TABLE_NAME,"NgaySinh=?",new String[]{ngaysinh});
        if (pos == 0) {
            return -1;
        }
        return 1;
    }
    public int FindByID(String ngaysinh){
        for (int i = 0; i < getlist().size(); i++) {
            Student st = list.get(i);
            if (st.getNgaySinh().equalsIgnoreCase(ngaysinh)) {
                return i;
            }
        }
        return -1;
    }
    public List<Student> getlist() {
        List<Student> LS = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            Student st = new Student();
            st.setName(cursor.getString(0));
            st.setNgaySinh(cursor.getString(1));
            st.setIdClass(cursor.getString(2));
            LS.add(st);
            cursor.moveToNext();
        }
        return LS;
    }
}
