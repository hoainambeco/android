package com.example.studenrmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnClass,btnStudent;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClass = (Button) findViewById(R.id.btnClass);
        btnStudent = (Button) findViewById(R.id.btnStudent);

    }
    public void Class(View view){
        intent = new Intent(MainActivity.this,ClassActivity.class);
        startActivity(intent);
    }
    public void SV(View view){
        intent = new Intent(MainActivity.this,StudentAtivity.class);
        startActivity(intent);
    }
}