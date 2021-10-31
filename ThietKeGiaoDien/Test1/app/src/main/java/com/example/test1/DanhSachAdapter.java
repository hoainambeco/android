package com.example.test1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DanhSachAdapter extends RecyclerView.Adapter<DanhSachHolder> {

    SachControl sachControl;
    Context context;
    List<Sach> list;
    public DanhSachAdapter(List<Sach> list,Context context){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DanhSachHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dsadapter,parent,false);
        return new DanhSachHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  DanhSachHolder holder, int position) {
         sachControl = new SachControl(context);
         list = sachControl.Select();
         holder.sach = list.get(position);
         holder.idht.setText(holder.sach.id);
         holder.tenht.setText(holder.sach.ten);
         holder.loaiht.setText(holder.sach.loai);
         holder.edit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Dialog dialog = new Dialog(v.getContext());
                 dialog.setContentView(R.layout.dialogedit);

                 TextView idm = (TextView)  dialog.findViewById(R.id.idm);
                 EditText tenm = (EditText) dialog.findViewById(R.id.tenm);
                 EditText loaim = (EditText) dialog.findViewById(R.id.loaim);
                 Button editm = (Button) dialog.findViewById(R.id.ok);
                 Button cancel = (Button) dialog.findViewById(R.id.cancel);

                 idm.setText(holder.sach.id);
                 tenm.setText(holder.sach.ten);
                 loaim.setText(holder.sach.loai);

                 editm.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                        holder.sach.ten = tenm.getText().toString();
                        holder.sach.loai = loaim.getText().toString();
                        if(sachControl.Edit(holder.sach) < 0){
                            Toast.makeText(idm.getContext(), "EDIT THAT BAI",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(idm.getContext(), "EDIT THANH CONG",Toast.LENGTH_LONG).show();
                            notifyDataSetChanged();
                        }
                        dialog.dismiss();
                     }
                 });
                 cancel.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         dialog.dismiss();
                     }
                 });
                 dialog.show();
             }
         });

         holder.delete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 AlertDialog.Builder builder =
                         new AlertDialog.Builder(v.getContext());
                 builder.setTitle("DO YOU WANT TO DELETE ");
                 builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         sachControl.Delate(holder.sach);
                         list.remove(position);
                         notifyItemRemoved(position);
                         notifyItemRangeChanged(position,list.size());
                     }
                 });
                 builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                     }
                 });
                 builder.show();
             }
         });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
