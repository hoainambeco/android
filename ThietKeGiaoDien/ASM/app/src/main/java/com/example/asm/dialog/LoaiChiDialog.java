package com.example.asm.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.asm.R;
import com.example.asm.entity.LoaiChi;
import com.example.asm.ui.chi.LoaiChiFragment;
import com.example.asm.ui.chi.LoaiChiViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiChiDialog {
    private LoaiChiViewModel mviewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDaDialog;

    private TextInputEditText edID, adName;
    private boolean mEditMode;

    public LoaiChiDialog(Context context, LoaiChiFragment fragment, LoaiChi ...loaiThu) {
        mviewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_loai_chi,null);
        edID = view.findViewById(R.id.txtID);
        adName = view.findViewById(R.id.edName);
        if (loaiThu != null && loaiThu.length>0){
            edID.setText(""+loaiThu[0].lid);
            adName.setText(loaiThu[0].ten);
            mEditMode = true;
        }
        else{
            mEditMode = false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setView(view).setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDaDialog.dismiss();
            }
        }).setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LoaiChi lc = new LoaiChi();
                lc.ten = adName.getText().toString();
                if (mEditMode){
                    lc.lid = Integer.parseInt(edID.getText().toString());
                    mviewModel.update(lc);
                }else {

                    mviewModel.insert(lc);
                    Toast.makeText(context,"lưu thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mDaDialog = builder.create();
    }
    public void show(){
        mDaDialog.show();
    }
}
