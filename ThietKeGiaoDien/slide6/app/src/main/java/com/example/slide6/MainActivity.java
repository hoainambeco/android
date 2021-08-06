package com.example.slide6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    public String username,password;

    private TabLayout tabs;
    private ViewPager pagers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = findViewById(R.id.tabs);
        pagers= findViewById(R.id.pagers);
        ThuChiAdapter thuChiAdapter = new ThuChiAdapter(getSupportFragmentManager());
        pagers.setAdapter(thuChiAdapter);
        //gán tablayout và viewpager
        tabs.setupWithViewPager(pagers);
    }
    public void themFragment(View view) {
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        Blank1Fragment fragment = new Blank1Fragment();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}