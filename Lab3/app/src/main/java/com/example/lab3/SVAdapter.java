package com.example.lab3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SVAdapter extends RecyclerView.Adapter<svHolder> {

    Context context;
    SVControl svControl;
    List<SinhVien> list;
    public SVAdapter(List<SinhVien> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public svHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new svHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull svHolder holder, int position) {
        holder.sv = list.get(position);
        holder.id.setText(holder.sv.id);
        holder.name.setText(holder.sv.name);
        holder.diem.setText(String.valueOf(holder.sv.number));
        svControl = new SVControl(context);
        holder.xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svControl.DeleteSV(holder.sv);
                notifyItemRemoved(position-1);
                Log.e("aa","aa  "+position);
            }
        });
        holder.sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainActivity2.class);
                Bundle bundle = new Bundle();
                int a = position;
                bundle.putInt("Vitri" , a);
                intent.putExtra("Data" , bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
