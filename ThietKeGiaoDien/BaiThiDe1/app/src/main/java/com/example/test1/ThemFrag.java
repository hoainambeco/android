package com.example.test1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;


public class ThemFrag extends Fragment {

    AndroidControl androidControl;
    TextInputEditText ids;
    TextInputEditText tens;
    TextInputEditText loais;
    Button add;
    DanhSachAdapter danhSachAdapter;
    boolean values;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.them,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ids = view.findViewById(R.id.ids);
        tens = view.findViewById(R.id.tens);
        loais = view.findViewById(R.id.loais);
        add = view.findViewById(R.id.them);

        androidControl = new AndroidControl(getContext());
        loais.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Calendar calendar  = Calendar.getInstance();
                DatePickerDialog datePickerDialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Toast.makeText(getContext(),"" +year +"-" + (month+1)+"-"+ day, Toast.LENGTH_SHORT).show();
                        loais.setText(day +"-" + (month+1)+"-"+ year);
                    }
                },calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Android android = new Android();
                android.id = ids.getText().toString();
                android.ten = tens.getText().toString();
                android.ngay = loais.getText().toString();
                if(ids.getText().toString().length()== 0){
                    TextInputLayout t = view.findViewById(R.id.TextInputLayout);
                    t.setError("Bạn chưa nhập ID");
                    values = false;
                }else{
                    TextInputLayout t = view.findViewById(R.id.TextInputLayout);
                    t.setError("");
                    values = true;
                }

                if(tens.getText().toString().length()== 0){
                    TextInputLayout t = view.findViewById(R.id.TextInputLayout2);
                    t.setError("Bạn chưa nhập dữ liệu");
                    values = false;
                }else{
                    TextInputLayout t = view.findViewById(R.id.TextInputLayout2);
                    t.setError("");
                    values = true;
                }

                if(loais.getText().toString().length()== 0){
                    TextInputLayout t = view.findViewById(R.id.TextInputLayout3);
                    t.setError("Bạn chưa nhập ngày tháng");
                    values = false;
                }else{
                    TextInputLayout t = view.findViewById(R.id.TextInputLayout3);
                    t.setError("");
                    values = true;
                }
                if (values){
                    if(androidControl.Insert(android) < 0){
                        Toast.makeText(getContext(),"Insert That Bai" ,Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getContext(),"Insert Thanh Cong"  ,Toast.LENGTH_LONG).show();
                        ids.setText("");
                        tens.setText("");
                        loais.setText("");
                        danhSachAdapter = new DanhSachAdapter(androidControl.Select(),getContext());
                        danhSachAdapter.notifyDataSetChanged();
                        Intent intent  = new Intent(getContext(), MainActivity2.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
