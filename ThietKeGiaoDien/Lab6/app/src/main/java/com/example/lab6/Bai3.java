package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class Bai3 extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager pagers;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai3);

        tv = findViewById(R.id.tv1);
        tabs = findViewById(R.id.tabs);
        pagers = findViewById(R.id.pagers);
        B3Adapter b3Adapter = new B3Adapter(getSupportFragmentManager());
        pagers.setAdapter(b3Adapter);
        // gan tablayout vao viewpager
        tabs.setupWithViewPager(pagers);

    }
}