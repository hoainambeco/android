package com.example.myapplicationoto.adpater;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationoto.R;

public class OToViewHodel extends RecyclerView.ViewHolder {
    TextView tv_id_oto, tv_ma_oto, tv_gia_oto;
    ImageView img_xoa_oto;
    public OToViewHodel(@NonNull  View itemView) {
        super(itemView);
        tv_id_oto = itemView.findViewById(R.id.tv_id_oto);
        tv_ma_oto = itemView.findViewById(R.id.tv_ma_oto);
        tv_gia_oto = itemView.findViewById(R.id.tv_gia_oto);
        img_xoa_oto = itemView.findViewById(R.id.img_xoa_oto);
    }
}
