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
            ="CREATE TABLE Contact(Id text primary key,Name text,Price real, Image text)";
    public ProductDAO(Context context){
        sqLiteHelper = new SQL(context);
        db=sqLiteHelper.getWritableDatabase();
    }
    public int insertProduct(Product product)
    {
        ContentValues values=new ContentValues();
        values.put("ID",product.getId());
        values.put("Ten",product.getName());
        values.put("Price",product.getPrice());
        values.put("Image",product.getImage());
        if(db.insert("Contact",null,values)<0)
        {
            return -1;
        }
        return 1;
    }

    public int updateProduct(Product product)
    {
        ContentValues values=new ContentValues();
        values.put("ID",product.getId());
        values.put("Ten",product.getName());
        values.put("Price",product.getPrice());
        values.put("Image",product.getImage());
        if(db.update("ID",values,"ID=?",new String[]{product.getId()})<0)
        {
            return -1;
        }
        return 1;
    }

    public int deleteProduct(String ID )
    {
        int kq=db.delete("ID","ID=?",new String[]{ID});
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
        Cursor cursor = db.query("Contact",null,null,null,
                null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false)
        {
            Product product =new Product();
            product.setId(cursor.getString(0));
            product.setName(cursor.getString(1));
            product.setPrice(Double.parseDouble(cursor.getString(1)));
            ls.add(product.getId()+"-"+product.getName()+" - "+product.getPrice());
            cursor.moveToNext();
        }
        cursor.close();
        return ls;
    }
}
