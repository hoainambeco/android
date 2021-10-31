package com.example.test1;

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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

public class DanhSachAdapter extends RecyclerView.Adapter<DanhSachHolder> {

    AndroidControl androidControl;
    Context context;
    List<Android> list;
    public DanhSachAdapter(List<Android> list, Context context){
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
         androidControl = new AndroidControl(context);
         list = androidControl.Select();
         holder.android = list.get(position);
         holder.idht.setText(holder.android.id);
         holder.tenht.setText(holder.android.ten);
         holder.loaiht.setText(holder.android.ngay);


         holder.cardView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Dialog dialog = new Dialog(v.getContext());
                 dialog.setContentView(R.layout.chi_tiet);

                 TextView idm = (TextView)  dialog.findViewById(R.id.idm);
                 EditText tenm = (EditText) dialog.findViewById(R.id.tenm);
                 EditText loaim = (EditText) dialog.findViewById(R.id.loaim);
                 Button cancel = (Button) dialog.findViewById(R.id.cancel);
                 CardView Card = (CardView) dialog.findViewById(R.id.card);

                 idm.setText(holder.android.id);
                 tenm.setText(holder.android.ten);
                 loaim.setText(holder.android.ngay);

                 cancel.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         dialog.dismiss();
                     }
                 });
                 dialog.show();
             }
         });

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

                 idm.setText(holder.android.id);
                 tenm.setText(holder.android.ten);
                 loaim.setText(holder.android.ngay);

                 loaim.setOnClickListener(new View.OnClickListener(){
                     @Override
                     public void onClick(View view) {
                         Calendar calendar  = Calendar.getInstance();
                         DatePickerDialog datePickerDialog= new DatePickerDialog(dialog.getContext(), new DatePickerDialog.OnDateSetListener() {
                             @Override
                             public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                 Toast.makeText(dialog.getContext(),"" +year +"-" + (month+1)+"-"+ day, Toast.LENGTH_SHORT).show();
                                 loaim.setText(day +"-" + (month+1)+"-"+ year);
                             }
                         },calendar.get(Calendar.YEAR),
                                 calendar.get(Calendar.MONTH),
                                 calendar.get(Calendar.DAY_OF_MONTH));
                         datePickerDialog.show();
                     }
                 });
                 editm.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                        holder.android.ten = tenm.getText().toString();
                        holder.android.ngay = loaim.getText().toString();
                        if(androidControl.Edit(holder.android) < 0){
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
                         androidControl.Delate(holder.android);
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
