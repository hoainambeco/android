package com.example.lap4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    List<User> arrList;
    public Lap4_Bai3 context;
    public LayoutInflater inflater;

    public Adapter(List<User> arrList, Lap4_Bai3 context) {
        this.arrList = arrList;
        this.context = context;
        this.inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class viewHolder{
        ImageView img;
        TextView Name;
        TextView Phone;
        TextView Email;
        ImageView imgDel;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView == null){
            holder = new viewHolder();
            convertView = inflater.inflate(R.layout.item_user,null);
            holder.img = convertView.findViewById(R.id.icAvatar);
            holder.Name = convertView.findViewById(R.id.txtName);
            holder.Phone = convertView.findViewById(R.id.txtPhone);
            holder.Email = convertView.findViewById(R.id.txtEmail);
            holder.imgDel = convertView.findViewById(R.id.icDelete);
            convertView.setTag(holder);

        }
        else {
            holder = (viewHolder) convertView.getTag();

        }
        User user = arrList.get(position);
        holder.Name.setText(user.getName());
        holder.Phone.setText(user.getPhone());
        holder.Email.setText(user.getEmail());
        return convertView;
    }
}
