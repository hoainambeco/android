package com.example.test2;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DanhSachHolder extends RecyclerView.ViewHolder {
    public TextView cannang, date;
    public Button edit;
    public Button delete;
    public test2 test2;
    public DanhSachHolder(@NonNull View itemView) {
        super(itemView);
        cannang = itemView.findViewById(R.id.CanNang);
        date = itemView.findViewById(R.id.NgayThang);
        edit = itemView.findViewById(R.id.edit);
        delete = itemView.findViewById(R.id.delete);
    }
}
