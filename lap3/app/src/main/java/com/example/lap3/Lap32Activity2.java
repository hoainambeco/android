package com.example.lap3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Lap32Activity2 extends AppCompatActivity {
    TextView lblKetqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap322);
        lblKetqua = findViewById(R.id.lblKetqua);

        Intent intent = getIntent();

        double a = Double.parseDouble(intent.getExtras().getString("HSA"));
        double b = Double.parseDouble(intent.getExtras().getString("HSB"));
        double c = Double.parseDouble(intent.getExtras().getString("HSC"));

        double delta = b*b-(4*a*c);
        if (delta <0){
            lblKetqua.setText("Phương trình vô Nghiệm");
        }
        else if(delta == 0){
            lblKetqua.setText("Phương trình có nghiệm kép x= "+ ((-b)/(2*a)));
        }
        else {
            double x1= (-b + Math.sqrt(delta))/(2*a);
            double x2= (-b - Math.sqrt(delta))/(2*a);
            lblKetqua.setText("phương trình có 2 nghiệm phân biệt \n"+"x1= "+ x1 + "\nx2= "+x2 );
        }
    }
}