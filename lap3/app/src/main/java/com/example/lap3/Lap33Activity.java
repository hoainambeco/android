package com.example.lap3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Lap33Activity extends AppCompatActivity {
    ListView lvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap33);
        lvList = findViewById(R.id.lvList);
        hienthi();

    }
    public void hienthi(){
        String[] arr = new String[]{"Android cơ bản", "Android nâng cao", "Thiết kế giao diện Android", "Test và triển khai ứng dụng Android","NodeJS","Game 2D"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arr);
        lvList.setAdapter(adapter);
    }
}