package com.example.asm.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.asm.R;
import com.example.asm.entity.LoaiThu;
import com.example.asm.ui.thu.LoaiThuFragment;
import com.example.asm.ui.thu.LoaiThuViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiThuDialog {
    private LoaiThuViewModel mviewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDaDialog;

    private TextInputEditText edID, adName;
    private boolean mEditMode;

    public LoaiThuDialog(Context context, LoaiThuFragment fragment, LoaiThu ...loaiThu) {
        mviewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_loai_thu,null);
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
                LoaiThu  LT = new LoaiThu();
                LT.ten = adName.getText().toString();
                if (mEditMode){
                    LT.lid = Integer.parseInt(edID.getText().toString());
                    mviewModel.update(LT);
                    Toast.makeText(context,"Cập nhật thành công", Toast.LENGTH_SHORT).show();
                }else {

                    mviewModel.insert(LT);
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
