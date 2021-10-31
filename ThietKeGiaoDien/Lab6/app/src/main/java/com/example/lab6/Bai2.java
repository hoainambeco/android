package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai2 extends AppCompatActivity {

    TextView tv1;
    EditText edt;
    Button button;
    String ht;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2);

        tv1 = findViewById(R.id.tv1);
        edt = findViewById(R.id.edt1);
        button = findViewById(R.id.sub);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ht = edt.getText().toString();
                tv1.setText(ht);
            }
        });
    }
}