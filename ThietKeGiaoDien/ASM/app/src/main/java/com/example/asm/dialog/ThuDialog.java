package com.example.asm.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.lifecycle.Observer;

import com.example.asm.R;
import com.example.asm.adapter.LoaiThuSpinnerAdapter;
import com.example.asm.entity.LoaiThu;
import com.example.asm.entity.Thu;
import com.example.asm.ui.thu.KhoanThuFragment;
import com.example.asm.ui.thu.KhoanThuViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class ThuDialog {
    private KhoanThuViewModel mviewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDaDialog;
    private TextInputEditText edID, adName, etSoTien, etNote;
    private Spinner spType;
    private boolean mEditMode;
    private LoaiThuSpinnerAdapter mAdapter;

    public ThuDialog(Context context, KhoanThuFragment fragment, Thu ...thu) {
        mviewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_thu,null);
        edID = view.findViewById(R.id.txtID);
        adName = view.findViewById(R.id.edName);
        etSoTien = view.findViewById(R.id.etSotien);
        etNote = view.findViewById(R.id.etNote);
        spType = view.findViewById(R.id.spType);
        mAdapter = new LoaiThuSpinnerAdapter(fragment.getActivity());
        mviewModel.getAllLoaiThu().observe(fragment.getActivity(), new Observer<List<LoaiThu>>() {
            @Override
            public void onChanged(List<LoaiThu> loaiThus) {
                mAdapter.setList(loaiThus);
            }
        });
        spType.setAdapter(mAdapter);
        if (thu != null && thu.length>0){
            edID.setText(""+thu[0].tid);
            adName.setText(thu[0].ten);
            etSoTien.setText(""+ thu[0].sotien);
            etNote.setText(thu[0].ghichu);
            mEditMode = true;
        }
        else{
            mEditMode = false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setView(view).setNegativeButton("????ng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDaDialog.dismiss();
            }
        }).setPositiveButton("L??u", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Thu  thu = new Thu();
                thu.ten = adName.getText().toString();
                try{
                    thu.sotien = Integer.parseInt(etSoTien.getText().toString());
                    thu.ghichu = etNote.getText().toString();
                    thu.ltid = ((LoaiThu) mAdapter.getItem(spType.getSelectedItemPosition())).lid;
                    if (mEditMode){
                        thu.tid = Integer.parseInt(edID.getText().toString());
                        mviewModel.update(thu);
                        Toast.makeText(context,"C???p nh???t th??nh c??ng", Toast.LENGTH_SHORT).show();
                    }else {
                        mviewModel.insert(thu);
                        Toast.makeText(context,"l??u th??nh c??ng", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception exception){
                    Toast.makeText(context,"" + exception,Toast.LENGTH_SHORT).show();
                    System.out.println(exception);
                }

            }
        });
        mDaDialog = builder.create();
    }
    public void show(){
        mDaDialog.show();
    }
}
