package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<SinhVien> list;
    SVAdapter svAdapter;
    SVControl svControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rc);

        list = new ArrayList<>();
        SinhVien sv1 = new SinhVien("sv01","Nguyễn Hoài Nam","1");
        SinhVien sv2 = new SinhVien("sv02","Nguyễn Hoài Nam1","2");
        SinhVien sv3 = new SinhVien("sv03","Nguyễn Hoài Nam2","3");
        SinhVien sv4 = new SinhVien("sv04","Nguyễn Hoài Nam3","4");
        SinhVien sv5 = new SinhVien("sv05","Nguyễn Hoài Nam4","5");
        svControl = new SVControl(this);
        svControl.InsertSV(sv1);
        svControl.InsertSV(sv2);
        svControl.InsertSV(sv3);
        svControl.InsertSV(sv4);
        svControl.InsertSV(sv5);
        list = svControl.SelectSV();

        svAdapter = new SVAdapter(list,this);
        recyclerView.setAdapter(svAdapter);
          RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
          recyclerView.setLayoutManager(layoutManager);

    }
}