package com.example.lap4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Lap4_Bai3 extends AppCompatActivity {
    ListView listView;
    List<User> ls = new ArrayList<>();
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap4_bai3);
        listView = findViewById(R.id.lvList);
        dumData();
        adapter = new Adapter(ls,Lap4_Bai3.this);
        listView.setAdapter(adapter);
    }

    public void dumData(){
        ls.add(new User("Nguyễn Thế an","03151","an123@gmail.com"));
        ls.add(new User("Nguyễn Hạo an","04242","aadsda@gmail.com"));
        ls.add(new User("Hòa Thị Bích","010424","rsdsf@gmail.com"));
        ls.add(new User("Nguyễn Thế an","0124242","qqq213@gmail.com"));
        ls.add(new User("Nguyễn Thế an","0124242","qqq213@gmail.com"));
        ls.add(new User("Nguyễn Thế an","0124242","qqq213@gmail.com"));
        ls.add(new User("Nguyễn Thế an","0124242","qqq213@gmail.com"));
        ls.add(new User("Nguyễn Thế an","0124242","qqq213@gmail.com"));
        ls.add(new User("Nguyễn Thế an","0124242","qqq213@gmail.com"));
        ls.add(new User("Nguyễn Thế an","0124242","qqq213@gmail.com"));
        ls.add(new User("Nguyễn Thế an","0124242","qqq213@gmail.com"));
        ls.add(new User("Nguyễn Thế an","0124242","qqq213@gmail.com"));
        ls.add(new User("Nguyễn Thế an","0124242","qqq213@gmail.com"));
    }
}