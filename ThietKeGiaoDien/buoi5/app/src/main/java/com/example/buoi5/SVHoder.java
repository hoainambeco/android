package com.example.buoi5;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SVHoder extends RecyclerView.ViewHolder{
    public TextView tv;
    public SinhVien sinhVien;
    public SVHoder(@NonNull View itemView){
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}
