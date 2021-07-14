package com.example.lap2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class bai1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai1);
        TextView textView =findViewById(R.id.tv);
        Typeface fonTypeface=Typeface.createFromAsset(getAssets(),"Blazed.ttf");
        textView.setTypeface(fonTypeface);
    }
}