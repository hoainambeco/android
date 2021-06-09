package com.poly.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<SinhVien> arrayList;

    public MyAdapter(ArrayList<SinhVien> arrayList) {
        this.arrayList = arrayList;
    }

    // định nghĩa giao diện cho mỗi hàng trên listview
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.row, parent, false);
        TextView tv1 = view.findViewById(R.id.textView);
        TextView tv2 = view.findViewById(R.id.textView2);
        SinhVien sv = arrayList.get(position);
        tv1.setText(sv.getName());
        tv2.setText(sv.getNumber());

        Button btnXOA = view.findViewById(R.id.button);
        btnXOA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySqlite mySqlite = new MySqlite(parent.getContext());
                mySqlite.xoaSinhVien(sv);
                arrayList.remove(sv);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
