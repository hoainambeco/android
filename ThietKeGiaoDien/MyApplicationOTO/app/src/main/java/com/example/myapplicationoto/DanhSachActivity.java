package com.example.myapplicationoto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplicationoto.adpater.OToAdapter;
import com.example.myapplicationoto.dao.OToDAO;
import com.example.myapplicationoto.database.Database;
import com.example.myapplicationoto.dto.OTo;

import java.util.ArrayList;

public class DanhSachActivity extends AppCompatActivity {

    ArrayList<OTo> arrOto = new ArrayList<>();
    RecyclerView recyclerViewOto;
    OToAdapter oToAdapter;
    OToDAO oToDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);
        recyclerViewOto = findViewById(R.id.recycleView_ds_oto);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewOto.setLayoutManager(layoutManager);

        Database database = new Database(this);
        database.getWritableDatabase();


        oToDAO = new OToDAO(getApplicationContext());
        arrOto = oToDAO.danh_sach_oto();
        oToAdapter = new OToAdapter(this, arrOto);
        recyclerViewOto.setAdapter(oToAdapter);

    }
}