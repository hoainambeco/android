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
import com.example.asm.entity.Chi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChiRecyclerViewAdapter extends RecyclerView.Adapter<ChiRecyclerViewAdapter.ChiViewHolder>{
    private LayoutInflater layoutInflater;
    private List<Chi> mlisst;
    public  static ItemClickListener itemEditClickListener;
    public  static ItemClickListener itemViewClickListener;
    public ChiRecyclerViewAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void setOnItemEditClickListener(ItemClickListener itemEditClickListener) {
        ChiRecyclerViewAdapter.itemEditClickListener = itemEditClickListener;
    }

    public void setOnItemViewClickListener(ItemClickListener itemViewClickListener) {
        ChiRecyclerViewAdapter.itemViewClickListener = itemViewClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public ChiViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view   = layoutInflater.inflate(R.layout.recyclerview_chi_item,parent,false);

        return new ChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChiViewHolder holder, int position) {
        if (mlisst != null){
            holder.txtname.setText(mlisst.get(position).ten);
            holder.tvsotien.setText("" + mlisst.get(position).sotien + " đồng");
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
    public Chi getItem(int position){
        if (mlisst == null || position >=mlisst.size()){
            return null;
        }
        return  mlisst.get(position);
    }
    public void setMlisst(List<Chi> mlisst) {
        this.mlisst = mlisst;
        notifyDataSetChanged();
    }

    public static class ChiViewHolder extends RecyclerView.ViewHolder{
        public TextView txtname,tvsotien;
        public ImageView img1,img2;
        public CardView cv;
        public int position;
        public ChiViewHolder(@NonNull @NotNull View itemView) {

            super(itemView);
            txtname = itemView.findViewById(R.id.txtName);
            tvsotien = itemView.findViewById(R.id.tvSotien);
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
