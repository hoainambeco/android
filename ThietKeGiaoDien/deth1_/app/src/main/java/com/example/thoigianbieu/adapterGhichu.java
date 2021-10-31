package com.example.thoigianbieu;

import android.content.Context;
import android.content.DialogInterface;
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
        holder.tv_tg.setText("Thời Gian : " + ghichu.getThoigian());

        holder.img_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có muốn xóa không");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long result= daOghichu.delete(ghichu);
                        if(result>0){
                            ghichuArrayList.clear();
                            ghichuArrayList.addAll(daOghichu.getall());
                            notifyDataSetChanged();
                            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                        else {
                            Toast.makeText(context, "xóa thất bại", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
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
