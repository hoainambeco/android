package com.example.asm.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.asm.R;
import com.example.asm.entity.Thu;
import com.example.asm.ui.thu.KhoanThuFragment;
import com.example.asm.ui.thu.KhoanThuViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class KhoanThuDialog {
    private KhoanThuViewModel mviewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDaDialog;

    private TextInputEditText edID, adName, etSoTien, etNote;
    private boolean mEditMode;

    public KhoanThuDialog(Context context, KhoanThuFragment fragment, Thu ...thu) {
        mviewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_thu,null);
        edID = view.findViewById(R.id.txtID);
        adName = view.findViewById(R.id.edName);
        etSoTien = view.findViewById(R.id.etSotien);
        etNote = view.findViewById(R.id.etNote);
        if (thu != null && thu.length>0){
            edID.setText(""+thu[0].tid);
            adName.setText(thu[0].ten);
            etSoTien.setText(thu[0].sotien);
            etNote.setText(thu[0].ghichu);
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
                Thu LT = new Thu();
                LT.ten = adName.getText().toString();
                if (mEditMode){
                    LT.tid = Integer.parseInt(edID.getText().toString());
                    LT.ten = adName.getText().toString();
                    LT.sotien = Integer.parseInt(etSoTien.getText().toString());
                    LT.ghichu = etNote.getText().toString();
                    mviewModel.update(LT);
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
