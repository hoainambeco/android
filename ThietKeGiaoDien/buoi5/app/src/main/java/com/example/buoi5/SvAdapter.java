package com.example.buoi5;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SvAdapter  extends RecyclerView.Adapter<SVHoder> {

    List<SinhVien> sinhVienList;

    public SvAdapter(List<SinhVien> sinhVienList) {
        this.sinhVienList = sinhVienList;
    }

    @NonNull
    @Override
    public SVHoder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        Log.e("AAA","Create item layout");
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull  SVHoder holder, int position) {
        holder.sinhVien = sinhVienList.get(position);
        holder.tv.setText(holder.sinhVien.toString());
        Log.e("AA","BIND"+position);
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinhVienList.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sinhVienList.size();
    }
}
