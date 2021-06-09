package com.example.lap4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bai1 extends AppCompatActivity {
    EditText txtSoA,txtSoB;
    Button btnBSCNN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSoA = findViewById(R.id.txtSoA);
        txtSoB = findViewById(R.id.txtSoB);
        btnBSCNN = findViewById(R.id.btnBSCNN);
        btnBSCNN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai1.this, activity2.class);
                Bundle bundle = new Bundle();
                bundle.putInt("SoA",Integer.parseInt(txtSoA.getText().toString()));
                bundle.putInt("SoB",Integer.parseInt(txtSoB.getText().toString()));
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
    }

}