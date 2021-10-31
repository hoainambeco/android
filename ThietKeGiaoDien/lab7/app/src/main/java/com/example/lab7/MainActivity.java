package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button bai1 ,bai2, bai3,bai4,bai5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bai1 = findViewById(R.id.bntbai1);
        bai2 = findViewById(R.id.btn2);
        bai3 = findViewById(R.id.btn3);
        bai4 = findViewById(R.id.btn4);
        bai5 = findViewById(R.id.btn5);

        bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "bạn đã click vào nút bài 1",Snackbar.LENGTH_LONG).setActionTextColor(Color.RED).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        });

        bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Bai2.class);
                startActivity(intent);
            }
        });

        bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,bai3.class);
                startActivity(intent);
            }
        });

        bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Bai4.class);
                startActivity(intent);
            }
        });


        bai5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai5.class);
                startActivity(intent);
            }
        });

    }
}