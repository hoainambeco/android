package com.example.namnhph14161;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

public class DanhSachAdapter extends RecyclerView.Adapter<DanhSachHolder> {
    OopControl oopControl;
    Context context;
    List<Oop> list;

    public DanhSachAdapter(Context context, List<Oop> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DanhSachHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.danhsach_adapter,parent,false);

        return new DanhSachHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhSachHolder holder, int position) {
        oopControl = new OopControl(context);
        list = oopControl.Select();
        holder.oop = list.get(position);
        holder.ID.setText(holder.oop.id);
        holder.cannang.setText(holder.oop.CanNang.toString());
        holder.date.setText(holder.oop.date);
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialogedit);

                EditText tenm = (EditText) dialog.findViewById(R.id.txtCanNang);
                EditText loaim = (EditText) dialog.findViewById(R.id.editTextDate);

                loaim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Calendar calendar  = Calendar.getInstance();
                        DatePickerDialog datePickerDialog= new DatePickerDialog(dialog.getContext(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                loaim.setText(day +"-" + (month+1)+"-"+ year);
                            }
                        },calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.MONTH),
                                calendar.get(Calendar.DAY_OF_MONTH));
                        datePickerDialog.show();
                    }
                });
                Button editm = (Button) dialog.findViewById(R.id.ok);
                Button cancel = (Button) dialog.findViewById(R.id.cancel);

                tenm.setText(holder.oop.CanNang.toString());
                loaim.setText(holder.oop.date);

                editm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.oop.CanNang = Float.parseFloat(tenm.getText().toString());
                        holder.oop.date = loaim.getText().toString();
                        if(oopControl.Edit(holder.oop) < 0){
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
                        oopControl.Delate(holder.oop);
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