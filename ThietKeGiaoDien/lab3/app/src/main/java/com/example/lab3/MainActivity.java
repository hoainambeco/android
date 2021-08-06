package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<SinhVien> sinhViens;
    SVAdapter svAdapter;
    SVControl svControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        sinhViens = new ArrayList<>();
        SinhVien sv1 = new SinhVien("sv1","Nguyễn Hoài Nam","0384490544");
        SinhVien sv2 = new SinhVien("sv2","Nguyễn Hoài 1","0384490544");
        SinhVien sv3 = new SinhVien("sv3","Nguyễn Hoài 2","0384490544");
        SinhVien sv4 = new SinhVien("sv4","Nguyễn Hoài 3","0384490544");
        SinhVien sv5 = new SinhVien("sv5","Nguyễn Hoài 4","0384490544");
        SinhVien sv6 = new SinhVien("sv6","Nguyễn Hoài 5","0384490544");
        SinhVien sv7 = new SinhVien("sv7","Nguyễn Hoài 6","0384490544");
        SinhVien sv8 = new SinhVien("sv8","Nguyễn Hoài 7","0384490544");
        SinhVien sv9 = new SinhVien("sv9","Nguyễn Hoài 8","0384490544");
        svControl = new SVControl(this);
        svControl.InsertSV(sv1);
        svControl.InsertSV(sv2);
        svControl.InsertSV(sv3);
        svControl.InsertSV(sv4);
        svControl.InsertSV(sv5);
        svControl.InsertSV(sv6);
        svControl.InsertSV(sv7);
        svControl.InsertSV(sv8);
        svControl.InsertSV(sv9);
        sinhViens = svControl.SelectSV();

        svAdapter = new SVAdapter(sinhViens,this);
        recyclerView.setAdapter(svAdapter);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
    }
}