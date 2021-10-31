package com.example.test1;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DanhSachHolder extends RecyclerView.ViewHolder {
    public TextView idht;
    public TextView tenht;
    public TextView loaiht;
    public Button edit;
    public Button delete;
    public Sach sach;

    public DanhSachHolder(@NonNull View view){
        super(view);
        idht = view.findViewById(R.id.idht);
        tenht = view.findViewById(R.id.tenht);
        loaiht = view.findViewById(R.id.loaiht);
        edit = view.findViewById(R.id.edit);
        delete = view.findViewById(R.id.delete);
    }
}
