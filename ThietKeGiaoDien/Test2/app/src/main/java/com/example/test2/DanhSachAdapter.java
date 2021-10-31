package com.example.test2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DanhSachAdapter extends RecyclerView.Adapter<DanhSachHolder> {
    TestContronl testContronl;
    Context context;
    List<test2> list;

    public DanhSachAdapter(Context context, List<test2> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DanhSachHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_danh_sach_adapter,parent,false);

        return new DanhSachHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhSachHolder holder, int position) {
        testContronl = new TestContronl(context);
        list = testContronl.Select();
        holder.test2 = list.get(position);
        holder.cannang.setText(holder.test2.CanNang.toString());
        holder.date.setText(holder.test2.date);
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialogedit);

                EditText tenm = (EditText) dialog.findViewById(R.id.txtCanNang);
                EditText loaim = (EditText) dialog.findViewById(R.id.editTextDate);
                Button editm = (Button) dialog.findViewById(R.id.ok);
                Button cancel = (Button) dialog.findViewById(R.id.cancel);

                tenm.setText(holder.test2.CanNang.toString());
                loaim.setText(holder.test2.date);

                editm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.test2.CanNang = Float.parseFloat(tenm.getText().toString());
                        holder.test2.date = loaim.getText().toString();
                        if(testContronl.Edit(holder.test2) < 0){
                            Toast.makeText(tenm.getContext(), "EDIT THẤT BẠI",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(tenm.getContext(), "EDIT THÀNH CÔNG",Toast.LENGTH_LONG).show();
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
                        testContronl.Delate(holder.test2);
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