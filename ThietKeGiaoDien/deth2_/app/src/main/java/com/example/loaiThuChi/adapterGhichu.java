package com.example.loaiThuChi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class adapterGhichu extends RecyclerView.Adapter<adapterGhichu.GhichuViewHolder> {

    private Context context;
    DAOghichu daOghichu;
    ArrayList<Ghichu> ghichuArrayList;

    public adapterGhichu(Context context, ArrayList<Ghichu> ghichuArrayList) {
        this.context = context;
        this.ghichuArrayList = ghichuArrayList;
        daOghichu=new DAOghichu(context);
    }

    @Override
    public GhichuViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_ghichu,null);
        return new GhichuViewHolder(view);
    }

    @Override
    public void onBindViewHolder( adapterGhichu.GhichuViewHolder holder, int position) {
        Ghichu ghichu= ghichuArrayList.get(position);
        holder.tv_td.setText("Tiêu đề: "+ ghichu.getTitle());
        holder.tv_nd.setText("Nội Dung: " + ghichu.getNoidung());
        holder.tv_tg.setText(ghichu.getLoaiThuChi() + "\n"+ ghichu.getId());


        holder.img_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                View view=LayoutInflater.from(context).inflate(R.layout.dialogxoa,null);
                builder.setView(view);
                AlertDialog dialog= builder.create();
                dialog.show();

                Button btnxoa_gchu=view.findViewById(R.id.btnxoa_gchu);
                btnxoa_gchu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        long result= daOghichu.delete(ghichu.getId());
                        if(result>0){
                            ghichuArrayList.clear();
                            ghichuArrayList.addAll(daOghichu.getall());
                            notifyDataSetChanged();
                            Toast.makeText(context, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                        else {
                            Toast.makeText(context, "Xoa that bai", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return ghichuArrayList.size();
    }

    public  class GhichuViewHolder extends RecyclerView.ViewHolder{

        TextView tv_td;
        TextView tv_nd;
        TextView tv_tg;
        ImageView img_xoa;
        public GhichuViewHolder(View itemView) {
            super(itemView);
            tv_td=itemView.findViewById(R.id.tv_td);
            tv_nd=itemView.findViewById(R.id.tv_nd);
            tv_tg=itemView.findViewById(R.id.tv_tg);
            img_xoa=itemView.findViewById(R.id.img_xoa);
        }
    }
}
