package com.example.asm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.R;
import com.example.asm.entity.LoaiChi;
import com.example.asm.entity.LoaiThu;

import java.util.List;

public class LoaiChiRecyclerviewAdapter extends RecyclerView.Adapter<LoaiChiRecyclerviewAdapter.LoaiChiViewHolder> {
    private LayoutInflater layoutInflater;
    private List<LoaiChi> mlisst;
    public  static ItemClickListener itemEditClickListener;
    public  static ItemClickListener itemViewClickListener;
    public LoaiChiRecyclerviewAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void setOnItemEditClickListener(ItemClickListener itemEditClickListener) {
        LoaiChiRecyclerviewAdapter.itemEditClickListener = itemEditClickListener;
    }

    public void setOnItemViewClickListener(ItemClickListener itemViewClickListener) {
        LoaiChiRecyclerviewAdapter.itemViewClickListener = itemViewClickListener;
    }

    @NonNull
    @Override
    public LoaiChiRecyclerviewAdapter.LoaiChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view   = layoutInflater.inflate(R.layout.recyclerview_loai_chi_item,parent,false);

        return new LoaiChiRecyclerviewAdapter.LoaiChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiChiRecyclerviewAdapter.LoaiChiViewHolder holder, int position) {
        if (mlisst != null){
            holder.txtname.setText(mlisst.get(position).ten);
            holder.position= position;
        }
    }

    @Override
    public int getItemCount() {
        if (mlisst == null){
            return 0;
        }
        return mlisst.size();
    }
    public LoaiChi getItem(int position){
        if (mlisst == null || position >=mlisst.size()){
            return null;
        }
        return  mlisst.get(position);
    }
    public void setMlisst(List<LoaiChi> mlisst) {
        this.mlisst = mlisst;
        notifyDataSetChanged();
    }

    public class LoaiChiViewHolder extends RecyclerView.ViewHolder {
        public TextView txtname;
        public ImageView img1,img2;
        public CardView cv;
        public int position;
        public LoaiChiViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtName);
            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);
            cv = (CardView) itemView;
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemViewClickListener != null){
                        itemViewClickListener.onItemClick(position);
                    }
                }
            });
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemEditClickListener != null){
                        itemEditClickListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
