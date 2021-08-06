package com.example.buoi5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //ListView - tối ưu listview
    // 2. class adapter kế thừa BaseAdapter
    //3. list đối tượng: Sinh viên, oto, xe máy,...

    //recyclerView
    // 1 thẻ recyclerView
    // class Adapter kế thừa adapter của RecyclerView
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv= findViewById(R.id.lv);
        List<SinhVien> sinhVienList = new ArrayList<>();
        for (int i = 0; i<100; i++){
            sinhVienList.add(new SinhVien("ABC" + i));
        }
        SvAdapter svAdapter = new SvAdapter(sinhVienList);
        rv.setAdapter(svAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        layoutManager = new GridLayoutManager(this,5, LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
    }
}