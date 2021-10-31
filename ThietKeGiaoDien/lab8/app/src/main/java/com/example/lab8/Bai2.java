package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Bai2 extends AppCompatActivity {
    RecyclerView r;
    List<Muc> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        r = findViewById(R.id.RecyclerView);
        list.add(new Muc(R.drawable.girl,"Ngắm  Gái"));
        list.add(new Muc(R.drawable.wallhaven,"Nam Hoài Nguyễn"));
        list.add(new Muc(R.drawable.wallh,"Bài 2"));
        list.add(new Muc(R.drawable.girl,"Ngắm  Gái"));
        list.add(new Muc(R.drawable.wallhaven,"Nam Hoài Nguyễn"));
        list.add(new Muc(R.drawable.wallh,"Bài 2"));
        list.add(new Muc(R.drawable.girl,"Ngắm  Gái"));
        list.add(new Muc(R.drawable.wallhaven,"Nam Hoài Nguyễn"));
        list.add(new Muc(R.drawable.wallh,"Bài 2"));

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        r.setLayoutManager(mLayoutManager);
        adapter adapter = new adapter(list, this);
        r.setAdapter(adapter);

    }
}