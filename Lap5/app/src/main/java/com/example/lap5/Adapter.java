package com.example.lap5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    List<Product> arrlist;
    public MainActivity context;
    public LayoutInflater inflater;

    public Adapter(List<Product> arrlist, MainActivity context) {
        this.arrlist = arrlist;
        this.context = context;
        this.inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrlist.size();
    }

    @Override
    public Object getItem(int position) {
        return arrlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class viewHolder{
        TextView txtImage;
        TextView txtID;
        TextView txtName;
        TextView txtPrice;


    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView == null){
            holder = new viewHolder();
            convertView = inflater.inflate(R.layout.icon_listview,null);
            holder.txtImage = convertView.findViewById(R.id.txtImage);
            holder.txtName = convertView.findViewById(R.id.txtName);
            holder.txtID = convertView.findViewById(R.id.txtID);
            holder.txtPrice = convertView.findViewById(R.id.txtPrice);
            convertView.setTag(holder);

        }
        else {
            holder = (viewHolder) convertView.getTag();

        }
        Product product = arrlist.get(position);
        holder.txtID.setText(product.getId());
        holder.txtName.setText(product.getName());
        holder.txtPrice.setText(String.valueOf(product.getPrice()));

        return convertView;
    }
}
