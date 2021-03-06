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
import com.example.asm.adapter.LoaiChiSpinnerAdapter;
import com.example.asm.entity.Chi;
import com.example.asm.entity.LoaiChi;
import com.example.asm.ui.chi.KhoanChiFragment;
import com.example.asm.ui.chi.KhoanChiViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class ChiDialog {
    private KhoanChiViewModel mviewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDaDialog;
    private TextInputEditText edID, adName, etSoTien, etNote;
    private Spinner spType;
    private boolean mEditMode;
    private LoaiChiSpinnerAdapter mAdapter;

    public ChiDialog(Context context, KhoanChiFragment fragment, Chi...chi) {
        mviewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_chi,null);
        edID = view.findViewById(R.id.txtID);
        adName = view.findViewById(R.id.edName);
        etSoTien = view.findViewById(R.id.etSotien);
        etNote = view.findViewById(R.id.etNote);
        spType = view.findViewById(R.id.spType);
        mAdapter = new LoaiChiSpinnerAdapter(fragment.getActivity());
        mviewModel.getAllLoaiChi().observe(fragment.getActivity(), new Observer<List<LoaiChi>>() {
            @Override
            public void onChanged(List<LoaiChi> loaiChis) {
                mAdapter.setList(loaiChis);
            }
        });
        spType.setAdapter(mAdapter);
        if (chi != null && chi.length>0){
            edID.setText(""+chi[0].tid);
            adName.setText(chi[0].ten);
            etSoTien.setText(""+ chi[0].sotien);
            etNote.setText(chi[0].ghichu);
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
                Chi  chi = new Chi();
                chi.ten = adName.getText().toString();
                try{
                    chi.sotien = Integer.parseInt(etSoTien.getText().toString());
                    chi.ghichu = etNote.getText().toString();
                    chi.ltid = ((LoaiChi) mAdapter.getItem(spType.getSelectedItemPosition())).lid;
                    if (mEditMode){
                        chi.tid = Integer.parseInt(edID.getText().toString());
                        mviewModel.update(chi);
                        Toast.makeText(context,"C???p nh???t th??nh c??ng", Toast.LENGTH_SHORT).show();
                    }else {
                        mviewModel.insert(chi);
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
