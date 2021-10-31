package com.example.thoigianbieu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity3 extends AppCompatActivity {

    DAOghichu daOghichu;
    adapterGhichu adapterGhichu;
    ArrayList<Ghichu> ghichuArrayList;

    TextInputEditText title;
    TextInputEditText noidung;
    TextInputEditText time;
    Button addnew;

    private boolean values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        title = findViewById(R.id.te_td);
        noidung = findViewById(R.id.te_nd);
        time = findViewById(R.id.te_tg);
        addnew = findViewById(R.id.add);

        daOghichu = new DAOghichu(MainActivity3.this);
        ghichuArrayList = daOghichu.getall();
        adapterGhichu = new adapterGhichu(MainActivity3.this, ghichuArrayList);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int gio = calendar.get(Calendar.HOUR_OF_DAY);
                int phut = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity3.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay + ":" + minute);
                        Toast.makeText(MainActivity3.this, ""+ hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
                    }
                }, gio, phut, false);
                timePickerDialog.show();
            }
        });
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ghichu ghichu = new Ghichu();
                ghichu.setTitle(title.getText().toString());
                ghichu.setNoidung(noidung.getText().toString());
                ghichu.setThoigian(time.getText().toString());

                if (title.getText().toString().length() == 0 || title.getText().toString().trim() == ""){
                    TextInputLayout t = findViewById(R.id.td);
                    t.setError("Bạn chưa nhập tiêu đề");
                    values = false;
                }
                else {
                    TextInputLayout t = findViewById(R.id.td);
                    t.setError("");
                    values = true;
                }

                if (noidung.getText().toString().length() == 0){
                    TextInputLayout t = findViewById(R.id.nd);
                    t.setError("Bạn chưa nhập nội dung");
                    values = false;
                }
                else {
                    TextInputLayout t = findViewById(R.id.nd);
                    t.setError("");
                    values = true;
                }

                if (time.getText().toString().length() == 0){
                    TextInputLayout t = findViewById(R.id.tg);
                    t.setError("Bạn chưa chọn thời gian");
                    values = false;
                }
                else {
                    TextInputLayout t = findViewById(R.id.tg);
                    t.setError("");
                    values = true;
                }
                if (values){
                    if (daOghichu.insert(ghichu) <0){
                        Toast.makeText(MainActivity3.this, "Thêm Thất Bại", Toast.LENGTH_SHORT).show();

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                        builder.setMessage("Bạn có muốn sửa theo tiêu đề không");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ghichu.setTitle(title.getText().toString());
                                ghichu.setNoidung(noidung.getText().toString());
                                ghichu.setThoigian(time.getText().toString());

                                daOghichu.update(ghichu);
                                adapterGhichu = new adapterGhichu(MainActivity3.this, daOghichu.getall());
                                adapterGhichu.notifyDataSetChanged();
                                Toast.makeText(MainActivity3.this, "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.show();
                    }else {
                        ghichuArrayList.clear();
                        ghichuArrayList.addAll(daOghichu.getall());
                        adapterGhichu = new adapterGhichu(MainActivity3.this, daOghichu.getall());
                        adapterGhichu.notifyDataSetChanged();
                        Toast.makeText(MainActivity3.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}