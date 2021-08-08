package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Bai2 extends AppCompatActivity {
    Button check;
    TextInputEditText name,email,pass;
    boolean val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        check = findViewById(R.id.btncheck);
        name = findViewById(R.id.txtName);
        email = findViewById(R.id.txtEmail);
        pass = findViewById(R.id.txtPasss);
        
        
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().length() == 0){
                    TextInputLayout t=(TextInputLayout) findViewById(R.id.textInputLayout);
                    t.setError("nhập dùm cái tên");
                    val = false;
                }
                else {
                    TextInputLayout t=(TextInputLayout) findViewById(R.id.textInputLayout);
                    t.setError("");
                    val= true;
                }
                if (email.getText().toString().length() == 0){
                    TextInputLayout t=(TextInputLayout) findViewById(R.id.textInputLayout2);
                    t.setError("nhập dùm cái email");
                    val = false;
                }else if (!email.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-zA]+.[a-zA]+")) {
                    TextInputLayout t=(TextInputLayout) findViewById(R.id.textInputLayout2);
                    t.setError("email sai định dạng");
                    val = false;
                }else{
                    TextInputLayout t=(TextInputLayout) findViewById(R.id.textInputLayout2);
                    t.setError("");
                    val= true;
                }
                if (pass.getText().toString().length() <6 ){
                    TextInputLayout t=(TextInputLayout) findViewById(R.id.textInputLayout3);
                    t.setError("nhập dùm cái pass lớn hơn 6 ký tự");
                    val = false;
                }else {
                    TextInputLayout t=(TextInputLayout) findViewById(R.id.textInputLayout3);
                    t.setError("");
                    val= true;
                }
                if (val){
                    Toast.makeText(Bai2.this,"tất cả đều đúng",Toast.LENGTH_SHORT).show();
                }
        }});
    };
}