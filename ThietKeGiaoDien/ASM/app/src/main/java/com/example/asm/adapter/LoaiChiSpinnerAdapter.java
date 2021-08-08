package com.example.asm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asm.R;
import com.example.asm.entity.LoaiChi;
import com.example.asm.ui.chi.KhoanChiViewModel;

import java.util.List;

public class LoaiChiSpinnerAdapter extends BaseAdapter {
    private List<LoaiChi> mList;
    private LayoutInflater mlayoutInflater;

    public LoaiChiSpinnerAdapter(Context context) {
        mlayoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<LoaiChi> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mList == null){
            return 0;
        }
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        if (mList == null){
            return null;
        }
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        KhoanChiViewModel hodel;
        if (convertView == null){
            convertView =mlayoutInflater.inflate(R.layout.spinner_chi_item,null,false);
            hodel = new KhoanChiViewModel(convertView);
            convertView.setTag(hodel);
        }else {
            hodel= (KhoanChiViewModel) convertView.getTag();
        }
        hodel.tvName.setText(mList.get(position).ten);
        return convertView;
    }
    public static class KhoanChiViewModel{
        public TextView tvName;
        public KhoanChiViewModel(View view){
            tvName = view.findViewById(R.id.tvName1);
        }
    }
}
