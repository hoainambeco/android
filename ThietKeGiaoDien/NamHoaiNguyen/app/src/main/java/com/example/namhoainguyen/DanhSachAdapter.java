package com.example.namhoainguyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class DanhSachAdapter extends RecyclerView.Adapter<FragmentDanhsachViewModel> {

    Control control;
    Context context;
    List<DoiTuong> list;

    public DanhSachAdapter(Context context, List<DoiTuong> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FragmentDanhsachViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_danh_sach_adapter,parent,false);
        return new FragmentDanhsachViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentDanhsachViewModel holder, int position) {
        control = new Control(context);
        list = control.Select();
        holder.doiTuong=list.get(position);
        holder.TieuDe.setText(holder.doiTuong.TieuDe);
        holder.NoiDung.setText(holder.doiTuong.NoiDung);
        holder.ThoiGian.setText(holder.doiTuong.ThoiGian);

        holder.Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("BẠN CHẮC CHẮN MUỐN XÓA");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        control.Delete(holder.doiTuong);
                        list.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,list.size());
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}