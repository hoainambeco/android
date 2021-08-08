package com.example.asm.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.asm.R;
import com.example.asm.entity.LoaiThu;
import com.example.asm.entity.Thu;
import com.example.asm.ui.thu.KhoanThuFragment;
import com.example.asm.ui.thu.KhoanThuViewModel;
import com.example.asm.ui.thu.LoaiThuFragment;
import com.example.asm.ui.thu.LoaiThuViewModel;

public class ThuDetailDialog {
    private KhoanThuViewModel mviewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDaDialog;

    private TextView tvID, tvName,tvSotien, tvNote;

    public ThuDetailDialog(final Context context, KhoanThuFragment fragment, Thu thu) {
        mviewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_detail_khoan_thu,null);
        tvID = view.findViewById(R.id.tvid);
        tvName = view.findViewById(R.id.tvName1);
        tvNote = view.findViewById(R.id.tvNote);
        tvSotien = view.findViewById(R.id.tvSotien);
        tvID.setText(""+thu.tid);
        tvName.setText(thu.ten);
        tvSotien.setText("" + thu.sotien);
        tvNote.setText(thu.ghichu);
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
