package com.poly.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MySqlite extends SQLiteOpenHelper {


    Context context;

    // khai báo các hàm override - ghi đè
    // hàm khởi tạo
    public MySqlite(Context context) {
        super(context, "TenCuaFileDB.db", null, 1);
        this.context = context;
        // context. tham số đại diện cho 1 activity. khi gọi hàm này ở đâu thì truyền
        // màn hình hiện tại vào. vd : gọi ở MainActivity thì gõ là MainActivity.this
        // tham số name : là tên của file cơ sở dữ liệu có đuôi là db
        // tham số 3 là interface dùng tùy biến truy vấn. ở bài này ko sử dụng để là null
        // tham số version là phiên bản của csdl . mới tạo lần đầu để là 1.

    }

    // hàm onCreate
    @Override
    public void onCreate(SQLiteDatabase db) {
        // hàm onCreate là hàm đặc biệt. chương trình chỉ gọi vào 1 lần duy nhất khi khai báo class này
        // lần đầu tiên. các lần sau khai báo hoặc mở lại app thì chương trinh ko gọi vào nữa
        // hàm này dùng khai báo và thực thi câu lệnh tạo bảng : create table ......

        // khởi tạo bảng sinh viên có 3 tham số là id, name, number.
        String bang_sv = "Create table SinhVien(id integer primary key,name varchar(50),number text(11))";
        db.execSQL(bang_sv);
        // db là biến ở dòng 24

        String bang_gv = "Create table GiaoVien(id integer primary key,name varchar(50),number text(11))";
        db.execSQL(bang_gv);

    }

    public void themSinhVien(SinhVien sv) {
        // b1 : xin quyen ghi vao csdl
        SQLiteDatabase database = getWritableDatabase();
        // b2 :  ghép cặp giá trị của sinh viên vào cột tương ứng
        // tên cột phân biệt chữ hoa, thường nên cần điền giống như câu lệnh tạo bảng
        // phía onCreate
        ContentValues values = new ContentValues();
        values.put("id", sv.id);
        values.put("name", sv.name);
        values.put("number", sv.number);
        /// b3 : gọi câu lệnh truy vấn và kiểm tra kết quả
        long ketQua = database.insert("SinhVien", null, values);
        // bien context sinh vien truyen vao o ham tao cua MySqlite
        if (ketQua > 0) {
            Toast.makeText(context, "Them thanh cong", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "KHONG thanh cong", Toast.LENGTH_LONG).show();
        }
        // tham số 1 Là tên bảng - lưu ý : tên bảng phân biệt chữ hoa,
        // chữ thường nên cần giống như tên bảng đã dùng ở phía tạo bảng
        // tham số 2 sử dụng trong trường hợp muốn gán giá trị vào 1 cột ko có tên
        // tham số thứ 3 là biến ContentValues đã ghép cặp giá trị cột vs giá trị sv ở phía trên
    }

    public void suaSinhVien(SinhVien sv) {
        // b1 : xin quyen ghi vao csdl
        SQLiteDatabase database = getWritableDatabase();
        // b2 :  ghép cặp giá trị của sinh viên vào cột tương ứng
        // tên cột phân biệt chữ hoa, thường nên cần điền giống như câu lệnh tạo bảng
        // phía onCreate
        ContentValues values = new ContentValues();
        values.put("name", sv.name);
        values.put("number", sv.number);
        /// b3 : gọi câu lệnh truy vấn và kiểm tra kết quả
        long ketQua = database.
                update("SinhVien", values,"id=?",new String[]{sv.id});
        // bien context sinh vien truyen vao o ham tao cua MySqlite
        if (ketQua > 0) {
            Toast.makeText(context, "Them thanh cong", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "KHONG thanh cong", Toast.LENGTH_LONG).show();
        }
        // tham số 1 Là tên bảng - lưu ý : tên bảng phân biệt chữ hoa,
        // chữ thường nên cần giống như tên bảng đã dùng ở phía tạo bảng
        // tham số 2 sử dụng trong trường hợp muốn gán giá trị vào 1 cột ko có tên
        // tham số thứ 3 là biến ContentValues đã ghép cặp giá trị cột vs giá trị sv ở phía trên
    }
    public void xoaSinhVien(SinhVien sv) {
        // b1 : xin quyen ghi vao csdl
        SQLiteDatabase database = getWritableDatabase();
        // b2 :  ghép cặp giá trị của sinh viên vào cột tương ứng
        // tên cột phân biệt chữ hoa, thường nên cần điền giống như câu lệnh tạo bảng
        // phía onCreate
        /// b3 : gọi câu lệnh truy vấn và kiểm tra kết quả
        long ketQua = database.
                delete("SinhVien","id=?",new String[]{sv.id});
        // bien context sinh vien truyen vao o ham tao cua MySqlite
        if (ketQua > 0) {
            Toast.makeText(context, "Xoa thanh cong", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "KHONG thanh cong", Toast.LENGTH_LONG).show();
        }
        // tham số 1 Là tên bảng - lưu ý : tên bảng phân biệt chữ hoa,
        // chữ thường nên cần giống như tên bảng đã dùng ở phía tạo bảng
        // tham số 2 sử dụng trong trường hợp muốn gán giá trị vào 1 cột ko có tên
        // tham số thứ 3 là biến ContentValues đã ghép cặp giá trị cột vs giá trị sv ở phía trên
    }
   /* Cursor  là class dùng để chứa thông tin truy vấn được từ db
            nó chứa các hàng truy vấn đc và các cột được đánh số từ 0,1 ,2 ,3 ....
    muốn đọc đc thông tin trong Cursor, chúng ta phải viết code đọc chủ động đọc từ phần tử đầu tiên mà Cursor chứa
    bằng câu lệnh moveToFirst
    có nhiều cách để đọc Cursor
    ở đây T dùng vòng lặp while
    kiểm tra điều kiện
    isAfterLast trả về là true nếu phần tử đang đọc hiện tại là phần tử cuối cùng
    và ngược lại
    như vậy nếu Cursor chứa nhiều phần tử thì khi đọc giá trị đầu tiên
    thì isAfterLast sẽ là false
    vì vậy để đọc hết thì thêm phủ định cho hàm này
    !cursor.isAfterlast lấy giá trị trong vòng lặp xong thì di chuyển tới vị trí kế tiếp moveToNext*/

    public ArrayList<SinhVien> danhSachSinhVien() {
        ArrayList<SinhVien> list = new ArrayList<>();
        // b1 - xin quyen doc db
        SQLiteDatabase database = getReadableDatabase();
        // b2 - viet cau lenh truy van select * from SinhVien
        String query = "select * from SinhVien";
        // b3 : doc ket qua tu doi tuong Cursor
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(0);
                String name = cursor.getString(1);
                String number = cursor.getString(2);
                SinhVien sv = new SinhVien(id, name, number);
                list.add(sv);
                cursor.moveToNext();
            }
            cursor.close();
        }
        // tham so null la array cot, neu muon lay het cac cot thi dat la null
        // b4 : them phan tu sinhvien vua doc duoc va mang sinh vien . ArrayList<SinhVien>

        return list;
    }


    // hàm onUpgrade
    // được gọi khi chúng ta cần nâng cấp phiên bản db
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
