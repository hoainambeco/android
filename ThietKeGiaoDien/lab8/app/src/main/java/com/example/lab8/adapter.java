package com.example.lab8;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ViewHoler>{
    private List<Muc> list;
    private Context context;
    public adapter(List<Muc> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHoler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        holder.img.setImageResource(list.get(position).getHinh());
        holder.txt.setText(list.get(position).getChuoi());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHoler extends RecyclerView.ViewHolder{
        ImageView img1 , img2, img;
        TextView txt;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            img =itemView.findViewById(R.id.imageView6);
            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);
            txt = itemView.findViewById(R.id.txtName);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "đã sao chép thông tin thành công",Snackbar.LENGTH_LONG).setActionTextColor(Color.RED).show();
                }
            });

            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Gửi thành công",Snackbar.LENGTH_LONG).setActionTextColor(Color.RED).show();
                }
            });

            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Chia sẻ thành công",Snackbar.LENGTH_LONG).setActionTextColor(Color.RED).show();
                }
            });
        }
    }
}
