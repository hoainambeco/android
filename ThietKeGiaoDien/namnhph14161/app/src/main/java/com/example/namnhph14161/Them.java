package com.example.namnhph14161;

import android.app.DatePickerDialog;
import android.app.Dialog;
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

import java.util.Calendar;

public class Them extends Fragment {
    OopControl oopControl;
    TextInputEditText id;
    TextInputEditText CanNang;
    EditText date;
    Button add;
    DanhSachAdapter danhSachAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.them,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        id = view.findViewById(R.id.id);
        CanNang = view.findViewById(R.id.txtCanNang);
        date = view.findViewById(R.id.editTextDate);
        add = view.findViewById(R.id.btnThem);
        //ấn vào date sẽ có ngày tháng

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar  = Calendar.getInstance();
                DatePickerDialog datePickerDialog= new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Toast.makeText(getContext(),"" +year +"-" + (month+1)+"-"+ day, Toast.LENGTH_SHORT).show();
                        date.setText(day +"-" + (month+1)+"-"+ year);
                    }
                },calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        oopControl = new OopControl(getContext());

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Oop oop = new Oop();
                oop.id = id.getText().toString();
                oop.CanNang = Float.parseFloat(CanNang.getText().toString());
                oop.date = date.getText().toString();
                Dialog dialog = new Dialog(view.getContext());
                if(oopControl.Insert(oop) < 0){
                    Toast.makeText(getContext(),"Thêm Thất Bại",Toast.LENGTH_LONG).show();
                }else{
                    id.setText("");
                    CanNang.setText("");
                    date.setText("");
                    danhSachAdapter = new DanhSachAdapter(getContext(), oopControl.Select());
                    danhSachAdapter.notifyDataSetChanged();
                    Toast.makeText(getContext(),"Thêm Thành Công",Toast.LENGTH_LONG).show();
//                    oopControl.Insert(oop);
//                    Toast.makeText(getContext(),"Thêm Thành Công",Toast.LENGTH_LONG).show();
                    danhSachAdapter.notifyDataSetChanged();
                }
                dialog.dismiss();
            }
        });
    }
}
