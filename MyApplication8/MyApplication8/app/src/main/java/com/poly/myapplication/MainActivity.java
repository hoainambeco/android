package com.poly.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Intent IM vs EX
    // Tùy biến giao diện cho ListView
    // bài toán : hiển thị danh sách Sinh Viên lên màn hình
    // Dữ Liệu : lớp SinhVien - String name,number;
    // Danh sách : ArrayList<SinhVien>
    // ListView ở trên activity_main, đặt id là lvList.
    // tham chiếu ở MainActivity findViewByID
    // Khởi tạo class MyAdapter kế thừa BaseAdaper.
    // -> quy định giao diện cho mỗi hàng trên ListView
    // quy định số lượng hàng trên ListView sẽ hiển thị

    ArrayList<SinhVien> arrayList;

    MySqlite mySqlite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySqlite = new MySqlite(MainActivity.this);


        arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mySqlite.themSinhVien
                    (new SinhVien(String.valueOf(i) + System.currentTimeMillis(),
                            "BBB" + i, "123"));
        }

        arrayList = mySqlite.danhSachSinhVien();

        ListView lvList = findViewById(R.id.lvList);

        MyAdapter adapter = new MyAdapter(arrayList);
        lvList.setAdapter(adapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("https://vnexpress.net"));
//                startActivity(intent);
                // lấy ra sinh viên ở vị trí click
                SinhVien sinhVien = arrayList.get(position);
                // thay đổi giá trị name bằng AAAAAA để test
                sinhVien.name = "ASSSSSSSSSSSS";
                mySqlite.suaSinhVien(sinhVien);
                // cap nhat lai giao dien, f5, refresh
                arrayList.get(position).name = sinhVien.name;
                // thong bao voi adapter f5 lai giao dien
                adapter.notifyDataSetChanged();

            }
        });

    }
}