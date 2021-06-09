package com.example.lap3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bai1 extends AppCompatActivity {
    Button btnDangnhap;
    EditText txtuser, txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDangnhap = findViewById(R.id.btnDangnhap);
        txtuser = findViewById(R.id.txtuser);
        txtpass = findViewById(R.id.txtpass);

    }

    public void Dangnhap(View view) {
        if (txtuser.getText().toString().equals("admin") && txtpass.getText().toString().equals("admin")){
            Toast toast = Toast.makeText(getApplicationContext(),"Đăng nhập thành công", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),"Đăng nhập thất bại", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}