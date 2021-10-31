package com.example.test1;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ThemFrag extends Fragment {

    SachControl sachControl ;
    EditText ids;
    EditText tens;
    EditText loais;
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
        ids = view.findViewById(R.id.ids);
        tens = view.findViewById(R.id.tens);
        loais = view.findViewById(R.id.loais);
        add = view.findViewById(R.id.them);

        sachControl = new SachControl(getContext());

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sach sach = new Sach();
                sach.id = ids.getText().toString();
                sach.ten = tens.getText().toString();
                sach.loai = loais.getText().toString();
                if(sachControl.Insert(sach) < 0){
                    Toast.makeText(getContext(),"Insert That Bai" + sachControl.Select().size(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(),"Insert Thanh Cong"  + sachControl.Select().size(),Toast.LENGTH_LONG).show();
                    ids.setText("");
                    tens.setText("");
                    loais.setText("");
                    danhSachAdapter = new DanhSachAdapter(sachControl.Select(),getContext());
                    danhSachAdapter.notify();
                }
            }
        });
    }
}
