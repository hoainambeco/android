package com.example.test2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class ThemFrag extends Fragment{
    EditText edtCanNang, edtDate;
    Button btnThem;
    TestContronl TestContronl;
    DanhSachAdapter danhSachAdapter;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_them_frag,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtCanNang = view.findViewById(R.id.txtCanNang);
        edtDate = view.findViewById(R.id.editTextDate);
        btnThem = view.findViewById(R.id.btnThem);
        edtDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Calendar calendar  = Calendar.getInstance();
                DatePickerDialog datePickerDialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Toast.makeText(getContext(),"" +year +"-" + (month+1)+"-"+ day, Toast.LENGTH_SHORT).show();
                        edtDate.setText(day +"-" + (month+1)+"-"+ year);
                    }
                },calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
        TestContronl = new TestContronl(getContext());
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test2 test2 = new test2();
                test2.CanNang = Float.parseFloat(edtCanNang.getText().toString());
                test2.date = edtDate.getText().toString();
                if(TestContronl.Insert(test2) < 0){
                    Toast.makeText(getContext(),"Thêm Thất Bại",Toast.LENGTH_LONG).show();
                }else{
                    edtCanNang.setText("");
                    edtDate.setText("");
                    danhSachAdapter = new DanhSachAdapter(getContext(), TestContronl.Select());
                    danhSachAdapter.notifyDataSetChanged();
                    Toast.makeText(getContext(),"Thêm Thành Công",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(),MainActivity2.class);
                    startActivity(intent);
                }

            }
        });
    }
}