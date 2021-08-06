package com.example.lab3;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SVHolder extends RecyclerView.ViewHolder {
    public TextView id;
    public TextView name;
    public TextView number;
    public Button sua;
    public Button xoa;
    public SinhVien sv;
    public SVHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.id);
        name = itemView.findViewById(R.id.name);
        number = itemView.findViewById(R.id.number);
        xoa = itemView.findViewById(R.id.xoa);
        sua = itemView.findViewById(R.id.sua);
    }
}
