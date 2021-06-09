package com.example.lifecycleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Test","GỌi hàm onCreate");
        Button btn = findViewById(R.id.btn_tong);
        Button btn1 = findViewById(R.id.btn_hieu);
        Button btn2 = findViewById(R.id.btn_tich);
        Button btn3 = findViewById(R.id.btn_thuong);
        TextView var1 = findViewById(R.id.var1);
        TextView var2 = findViewById(R.id.var2);
        TextView textkq = findViewById(R.id.textView3);
        View.OnClickListener tong =
            new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    double so1 = Double.parseDouble(var1.getText().toString());
                    double so2 = Double.parseDouble(var2.getText().toString());
                    double tong = so1 + so2;
                    textkq.setText(String.valueOf(tong));
                }
            };
        View.OnClickListener hieu =
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        double so1 = Double.parseDouble(var1.getText().toString());
                        double so2 = Double.parseDouble(var2.getText().toString());
                        double tong = so1 - so2;
                        textkq.setText(String.valueOf(tong));
                    }
                };
        View.OnClickListener tich =
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        double so1 = Double.parseDouble(var1.getText().toString());
                        double so2 = Double.parseDouble(var2.getText().toString());
                        double tong = so1 * so2;
                        textkq.setText(String.valueOf(tong));
                    }
                };
        View.OnClickListener thuong =
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        double so1 = Double.parseDouble(var1.getText().toString());
                        double so2 = Double.parseDouble(var2.getText().toString());
                        double tong = so1 / so2;
                        textkq.setText(String.valueOf(tong));
                    }
                };
        btn.setOnClickListener(tong);
        btn1.setOnClickListener(hieu);
        btn2.setOnClickListener(tich);
        btn3.setOnClickListener(thuong);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Test","GỌi hàm onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Test","GỌi hàm onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Test","GỌi hàm onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Test","GỌi hàm onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Test","GỌi hàm onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Test","GỌi hàm onRestart");
    }
}