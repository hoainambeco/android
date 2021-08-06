package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView idht;
    TextView nameht;
    TextView numberht;
    Button cancel;
    Button sua;
    SVControl svControl;
    SVAdapter svAdapter;
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        idht = findViewById(R.id.idht);
        nameht = findViewById(R.id.nameht);
        numberht = findViewById(R.id.numberht);
        cancel = findViewById(R.id.cancel);
        sua = findViewById(R.id.suaht);
        svControl = new SVControl(MainActivity2.this);
        svAdapter = new SVAdapter(svControl.SelectSV(),this);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("DAta");
        vitri = bundle.getInt("VT");
        SinhVien sv = svControl.SelectSV().get(vitri);
        idht.setText(sv.id);
        nameht.setText(sv.name);
        numberht.setText(String.valueOf(sv.number));

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void sua(View view){
        SinhVien sv = svControl.SelectSV().get(vitri);
        sv.id = idht.getText().toString();
        sv.name = nameht.getText().toString();
        sv.number = numberht.getText().toString();
        if (svControl.EditSV(sv) < 0) {
            Toast.makeText(MainActivity2.this, "Sửa thất bại", Toast.LENGTH_LONG).show();
        } else {
            svAdapter.notifyItemChanged(vitri);
            Toast.makeText(MainActivity2.this, "Sửa thành công", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity2.this,MainActivity.class));
            idht.setText("");
            nameht.setText("");
            numberht.setText("");
        }
    }

}