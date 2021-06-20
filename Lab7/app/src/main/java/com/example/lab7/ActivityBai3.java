package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityBai3 extends AppCompatActivity {
    Button btnDangNhap;
    EditText txtUser,txtPass;
    CheckBox cbrGhiNho;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        find();
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        txtUser.setText(sharedPreferences.getString("TaiKhoan",""));
        txtPass.setText(sharedPreferences.getString("MatKhau",""));
        cbrGhiNho.setChecked(sharedPreferences.getBoolean("Check",false));
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = txtUser.getText().toString().trim();
                String Password = txtPass.getText().toString().trim();
                if (userName.equals("Beco") && Password.equals("1234")){
                    Toast.makeText(ActivityBai3.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    if (cbrGhiNho.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("TaiKhoan",userName);
                        editor.putString("MatKhau",Password);
                        editor.putBoolean("Check",true);
                        editor.commit();
                    }
                    else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("TaiKhoan");
                        editor.remove("MatKhau");
                        editor.remove("Check");
                        editor.commit();
                    }
                }
                else {
                    Toast.makeText(ActivityBai3.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void find() {
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtPass);
        cbrGhiNho =(CheckBox) findViewById(R.id.cbrGhiNho);
    }
}
