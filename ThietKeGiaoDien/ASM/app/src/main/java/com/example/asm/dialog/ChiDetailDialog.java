package com.example.asm.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.asm.R;
import com.example.asm.entity.Chi;
import com.example.asm.ui.chi.KhoanChiFragment;
import com.example.asm.ui.chi.KhoanChiViewModel;

public class ChiDetailDialog {
    private KhoanChiViewModel mviewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDaDialog;

    private TextView tvID, tvName,tvSotien, tvNote;

    public ChiDetailDialog(final Context context, KhoanChiFragment fragment, Chi chi) {
        mviewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_detail_khoan_thu,null);
        tvID = view.findViewById(R.id.tvid);
        tvName = view.findViewById(R.id.tvName1);
        tvNote = view.findViewById(R.id.tvNote);
        tvSotien = view.findViewById(R.id.tvSotien);
        tvID.setText(""+chi.tid);
        tvName.setText(chi.ten);
        tvSotien.setText("" + chi.sotien);
        tvNote.setText(chi.ghichu);
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setView(view).setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDaDialog.dismiss();
            }
        });
        mDaDialog = builder.create();
    }
    public void show(){
        mDaDialog.show();
    }
}
