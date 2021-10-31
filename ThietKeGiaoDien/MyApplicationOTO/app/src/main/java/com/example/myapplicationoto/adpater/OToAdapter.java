package com.example.myapplicationoto.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplicationoto.R;
import com.example.myapplicationoto.dao.OToDAO;
import com.example.myapplicationoto.dto.OTo;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class OToAdapter extends RecyclerView.Adapter<OToViewHodel> {
    Context context;
    ArrayList<OTo> arrOto;
    OToDAO oToDAO;
    LayoutInflater layoutInflater;
    public OToAdapter(Context context, ArrayList<OTo> arrOto) {
        this.context = context;
        this.arrOto = arrOto;
    }


    @NonNull
    @Override
    public OToViewHodel onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewItem = inflater.inflate(R.layout.item_oto, parent, false);
        OToViewHodel oToViewHodel = new OToViewHodel(viewItem);
        return oToViewHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull  OToViewHodel holder, int position) {
        OTo oTo = arrOto.get(position);
        holder.tv_id_oto.setText(oTo.getId_oto());
        holder.tv_ma_oto.setText(oTo.getMa_oto());
        holder.tv_gia_oto.setText(oTo.getGia_oto());

        oToDAO = new OToDAO(context);
        holder.img_xoa_oto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.img_xoa_oto );

                popupMenu.inflate(R.menu.menu_delete);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_xoa:
                                oToDAO.xoa_oto(oTo);
                                arrOto.remove(oTo);
                                notifyDataSetChanged();
                                Snackbar.make(holder.itemView, "Xoa thành công", Snackbar.LENGTH_LONG)
                                        .setAction("CLOSE", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                            }
                                        })
                                        .show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrOto.size();
    }
}
