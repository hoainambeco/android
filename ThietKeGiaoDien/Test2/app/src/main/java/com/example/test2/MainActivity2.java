package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {
    private TabLayout tab;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tab = findViewById(R.id.tabs);
        pager = findViewById(R.id.pagers);

        Main2Adapter main2Adapter = new Main2Adapter(getSupportFragmentManager());
        pager.setAdapter(main2Adapter);
        tab.setupWithViewPager(pager);
    }


}