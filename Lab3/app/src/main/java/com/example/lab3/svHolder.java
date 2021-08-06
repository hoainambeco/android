package com.example.lab3;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class svHolder extends RecyclerView.ViewHolder {
    public TextView id;
    public TextView name;
    public TextView diem;
    public Button xoa;
    public Button sua;
    public SinhVien sv;

    public svHolder(@NonNull  View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.id);
        name = itemView.findViewById(R.id.name);
        diem = itemView.findViewById(R.id.diem);
        xoa = itemView.findViewById(R.id.xoa);
        sua = itemView.findViewById(R.id.sua);
    }
}
