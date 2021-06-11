package com.example.lap5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Context context;
    SQL sqLiteHelper;
    SQLiteDatabase db;
    public static final String CREATEBASE_TABLE_PRODUCT
            ="CREATE TABLE PRODUCT(Id text primary key,Name text,Price text)";
    public ProductDAO(Context context){
        sqLiteHelper = new SQL(context);
        db=sqLiteHelper.getWritableDatabase();
    }
    public int insertProduct(Product product)
    {
        ContentValues values=new ContentValues();
        values.put("Id",product.getId());
        values.put("Name",product.getName());
        values.put("Price",product.getPrice());
        if(db.insert("PRODUCT",null,values)<0)
        {
            return -1;
        }
        return 1;
    }

    public int updateProduct(Product product)
    {
        ContentValues values=new ContentValues();
        values.put("Id",product.getId());
        values.put("Name",product.getName());
        values.put("Price",product.getPrice());
        if(db.update("PRODUCT",values,"Id=?",new String[]{product.getId()})<0)
        {
            return -1;
        }
        return 1;
    }

    public int deleteProduct(String ID )
    {
        int kq=db.delete("PRODUCT","Id=?",new String[]{ID});
        if(kq<=0)
        {
            return -1;
        }
        return 1;
    }

    public List<String > getAllMalop()
    {
        List<String> ls=new ArrayList<>();
        // khai báo con trỏ đọc dữ liệu
        Cursor cursor = db.query("PRODUCT",null,null,null,
                null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false)
        {
            Product product =new Product();
            product.setId(cursor.getString(0));
            product.setName(cursor.getString(1));
            product.setPrice(cursor.getString(2));
            ls.add("Mã SP: " + product.getId()+"\nTên SP: "+product.getName()+"\nGiá: "+product.getPrice());
            cursor.moveToNext();
        }
        cursor.close();
        return ls;
    }
}
