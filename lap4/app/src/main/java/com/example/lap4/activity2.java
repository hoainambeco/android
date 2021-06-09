package com.example.lap4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {
    TextView lblKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        lblKetQua = findViewById(R.id.lblKetQua);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        int a = bundle.getInt("SoA");
        int b = bundle.getInt("SoB");
        int bscnn =  BSCNN(a,b);
        lblKetQua.setText(String.valueOf(bscnn));
    }
    public int USCLN(int a, int b){
        if (b==0){
            return a;
        }
        else{
            return USCLN(b,a%b);
        }
    }
    public int BSCNN(int a, int b){
        return (a*b)/USCLN(a,b);
    }
}