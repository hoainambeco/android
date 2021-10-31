package com.example.namhoainguyen;

import android.view.View;
import androidx.cardview.widget.CardView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentDanhsachViewModel extends RecyclerView.ViewHolder {
    TextView TieuDe, NoiDung, ThoiGian;
    ImageButton Xoa, Them;
    public DoiTuong doiTuong;
    public CardView cardView;

    public FragmentDanhsachViewModel(@NonNull View itemView) {
        super(itemView);
        TieuDe = itemView.findViewById(R.id.TieuDe);
        NoiDung = itemView.findViewById(R.id.NoiDungs);
        ThoiGian = itemView.findViewById(R.id.ThoiGian);
        Xoa = itemView.findViewById(R.id.delete);
        cardView=itemView.findViewById(R.id.card);
    }
}