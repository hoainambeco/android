package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void Bai1(View view){
        Intent intent = new Intent(MainActivity.this, ActivityBai1.class);
        startActivity(intent);
    }

    public void Bai2(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityBai2.class);
        startActivity(intent);
    }
    public void Bai3(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityBai3.class);
        startActivity(intent);
    }
}