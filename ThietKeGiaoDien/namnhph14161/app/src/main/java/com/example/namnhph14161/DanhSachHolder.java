package com.example.namnhph14161;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DanhSachHolder extends RecyclerView.ViewHolder {
    public TextView ID,cannang, date;
    public Button edit;
    public Button delete;
    public Oop oop;
    public DanhSachHolder(@NonNull View itemView) {
        super(itemView);
        ID = itemView.findViewById(R.id.ID);
        cannang = itemView.findViewById(R.id.Cannang);
        date = itemView.findViewById(R.id.NgayThang);
        edit = itemView.findViewById(R.id.edit);
        delete = itemView.findViewById(R.id.delete);
    }
}
