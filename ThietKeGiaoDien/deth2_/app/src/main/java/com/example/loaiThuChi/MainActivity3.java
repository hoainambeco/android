package com.example.loaiThuChi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.loaiThuChi.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    DAOghichu daOghichu;
    adapterGhichu adapterGhichu;
    ArrayList<Ghichu> ghichuArrayList;

    TextInputEditText title;
    TextInputEditText noidung;
    TextInputEditText time;
    EditText id;
    Button addnew, edit;
    RadioButton kt,kc;
    RadioGroup radioGroup;
    private String loaithuchi;
    private boolean values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        title = findViewById(R.id.te_name);
        noidung = findViewById(R.id.te_tien);
        addnew = findViewById(R.id.add);
        edit = findViewById(R.id.edit);
        radioGroup = findViewById(R.id.RadioGroup);
        id = findViewById(R.id.id);
        kt = findViewById(R.id.kt);
        kc = findViewById(R.id.kc);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.kt:
                        TextInputLayout t = findViewById(R.id.name);
                        t.setHint("Tên Khoản Thu");
                        break;
                    case R.id.kc:
                        TextInputLayout t1 = findViewById(R.id.name);
                        t1.setHint("Tên Khoản Chi");
                        break;
                }
            }
        });

        daOghichu = new DAOghichu(MainActivity3.this);
        ghichuArrayList = daOghichu.getall();
        adapterGhichu = new adapterGhichu(MainActivity3.this, ghichuArrayList);

/*        time.setOnClickListener(new View.OnClickListener() {
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


 */
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ghichu ghichu = new Ghichu();
                try {
                    ghichu.setId(Integer.parseInt(id.getText().toString()));
                    ghichu.setTitle(title.getText().toString());
                    ghichu.setNoidung(noidung.getText().toString());
                    if  (kt.isChecked()){
                        loaithuchi = ghichu.setLoaiThuChi(kt.getText().toString());
                    }
                    else{
                        loaithuchi = ghichu.setLoaiThuChi(kc.getText().toString());
                    }
                    ghichu.setLoaiThuChi(loaithuchi);


                    if (title.getText().toString().length() == 0){
                        TextInputLayout t = findViewById(R.id.name);
                        t.setError("Bạn chưa nhập tiêu đề");
                        values = false;
                    }
                    else {
                        TextInputLayout t = findViewById(R.id.name);
                        t.setError("");
                        values = true;
                    }

                    if (noidung.getText().toString().length() == 0){
                        TextInputLayout t = findViewById(R.id.tien);
                        t.setError("Bạn chưa nhập nội dung");
                        values = false;
                    }
                    else {
                        TextInputLayout t = findViewById(R.id.tien);
                        t.setError("");
                        values = true;
                    }

                    if (values){
                        if (daOghichu.insert(ghichu) <0){
                            Toast.makeText(MainActivity3.this, "Thêm Thất Bại", Toast.LENGTH_SHORT).show();
/*
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                            builder.setMessage("Bạn có muốn sửa theo id không");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ghichu.setTitle(title.getText().toString());
                                    ghichu.setNoidung(noidung.getText().toString());
                                    ghichu.setLoaiThuChi(loaithuchi);

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

 */
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
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity3.this, "Bạn nhập id sai. ID phải là số",Toast.LENGTH_LONG).show();
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Ghichu ghichu = new Ghichu();
                try {
                    ghichu.setId(Integer.parseInt(id.getText().toString()));
                    ghichu.setTitle(title.getText().toString());
                    ghichu.setNoidung(noidung.getText().toString());
                    if  (kt.isChecked()){
                        loaithuchi = ghichu.setLoaiThuChi(kt.getText().toString());
                    }
                    else{
                        loaithuchi = ghichu.setLoaiThuChi(kc.getText().toString());
                    }
                    ghichu.setLoaiThuChi(loaithuchi);

                    if (title.getText().toString().length() == 0){
                        TextInputLayout t = findViewById(R.id.name);
                        t.setError("Bạn chưa nhập tiêu đề");
                        values = false;
                    }
                    else {
                        TextInputLayout t = findViewById(R.id.name);
                        t.setError("");
                        values = true;
                    }

                    if (noidung.getText().toString().length() == 0){
                        TextInputLayout t = findViewById(R.id.tien);
                        t.setError("Bạn chưa nhập nội dung");
                        values = false;
                    }
                    else {
                        TextInputLayout t = findViewById(R.id.tien);
                        t.setError("");
                        values = true;
                    }

                    if (values){
                        if (daOghichu.update(ghichu) <0){
                            Toast.makeText(MainActivity3.this, "Sửa Thất Bại", Toast.LENGTH_SHORT).show();
                        }else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                            builder.setMessage("Bạn có muốn sửa theo id không");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ghichu.setTitle(title.getText().toString());
                                    ghichu.setNoidung(noidung.getText().toString());
                                    ghichu.setLoaiThuChi(loaithuchi);

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
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity3.this, "Bạn nhập id sai. ID phải là số",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}