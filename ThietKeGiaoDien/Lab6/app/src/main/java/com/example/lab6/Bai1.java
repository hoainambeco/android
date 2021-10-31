package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bai1 extends AppCompatActivity {

    Button login;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai1);

        login = findViewById(R.id.btn1);
        signup = findViewById(R.id.btn2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                B1_Frag1 fragment = new B1_Frag1();
                transaction.replace(R.id.frag2, fragment);
                transaction.commit();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                B2_frag1 fragment = new B2_frag1();
                transaction.replace(R.id.frag2, fragment);
                transaction.commit();
            }
        });
    }

}