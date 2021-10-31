package com.example.namhoainguyen;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class ThemFragment extends Fragment {
    Control control;
    TextInputEditText ids;
    TextInputEditText tens;
    TextInputEditText NoiDung;
    TextInputEditText ThoiGian;
    Button add;
    DanhSachAdapter danhSachAdapter;
    boolean values;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_them, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ids = view.findViewById(R.id.ids);
        tens = view.findViewById(R.id.tens);
        NoiDung = view.findViewById(R.id.NoiDungs);
        ThoiGian = view.findViewById(R.id.Ngays);
        add = view.findViewById(R.id.them);
        control = new Control(getContext());

        ThoiGian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Calendar calendar  = Calendar.getInstance();
                DatePickerDialog datePickerDialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Toast.makeText(getContext(),"" +year +"-" + (month+1)+"-"+ day, Toast.LENGTH_SHORT).show();
                        ThoiGian.setText(day +"-" + (month+1)+"-"+ year);
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
                DoiTuong doiTuong = new DoiTuong();
                doiTuong.id = Integer.parseInt(ids.getText().toString());
                doiTuong.TieuDe = tens.getText().toString();
                doiTuong.NoiDung = NoiDung.getText().toString();
                doiTuong.ThoiGian = ThoiGian.getText().toString();
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

                if(ThoiGian.getText().toString().length()== 0){
                    TextInputLayout t = view.findViewById(R.id.TextInputLayout3);
                    t.setError("Bạn chưa nhập ngày tháng");
                    values = false;
                }else{
                    TextInputLayout t = view.findViewById(R.id.TextInputLayout3);
                    t.setError("");
                    values = true;
                }
                if (values){
                    if(control.Insert(doiTuong) < 0){
                        control.Edit(doiTuong);
                        MainActivity2.class.notifyAll();
                        danhSachAdapter.notifyDataSetChanged();
                        Intent intent  = new Intent(getContext(), MainActivity2.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getContext(),"Insert Thanh Cong"  ,Toast.LENGTH_LONG).show();
                        ids.setText("");
                        tens.setText("");
                        ThoiGian.setText("");
                        danhSachAdapter = new DanhSachAdapter(getContext(), control.Select());
                        danhSachAdapter.notifyDataSetChanged();
                        Intent intent  = new Intent(getContext(), MainActivity2.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}