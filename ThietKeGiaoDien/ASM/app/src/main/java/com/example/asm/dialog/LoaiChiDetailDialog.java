package com.example.asm.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.asm.R;
import com.example.asm.entity.LoaiChi;
import com.example.asm.ui.chi.LoaiChiFragment;
import com.example.asm.ui.chi.LoaiChiViewModel;

public class LoaiChiDetailDialog {
    private LoaiChiViewModel mviewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDaDialog;

    private TextView tvID, tvName;

    public LoaiChiDetailDialog(final Context context, LoaiChiFragment fragment, LoaiChi loaiThu) {
        mviewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_detail_loai_thu,null);
        tvID = view.findViewById(R.id.tvid);
        tvName = view.findViewById(R.id.tvName1);
        tvID.setText(""+loaiThu.lid);
        tvName.setText(loaiThu.ten);
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
