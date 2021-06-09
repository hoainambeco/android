package com.example.lap3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lap32Activity1 extends AppCompatActivity {
    Button btnketqua;
    TextView txtA, txtB,txtC;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap32);
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtC = findViewById(R.id.txtC);
    }

    public void ketqua(View view) {
        Intent intent = new Intent(Lap32Activity1.this,Lap32Activity2.class);
        intent.putExtra("HSA",txtA.getText().toString());
        intent.putExtra("HSB",txtB.getText().toString());
        intent.putExtra("HSC",txtC.getText().toString());
        startActivity(intent);
    }

}