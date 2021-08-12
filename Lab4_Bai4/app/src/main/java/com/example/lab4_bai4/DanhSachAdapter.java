package com.example.lab4_bai4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class DanhSachAdapter extends BaseAdapter {

    Context context;
    List<DanhSach> sachList;

    public DanhSachAdapter(Context context, List<DanhSach> sachList) {
        this.context = context;
        this.sachList = sachList;
    }

    @Override
    public int getCount() {
        return sachList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        ImageView img = convertView.findViewById(R.id.img_avt);
        TextView name = convertView.findViewById(R.id.edt_name);
        TextView address = convertView.findViewById(R.id.edt_address);

        DanhSach danhSach = sachList.get(position);

        img.setImageResource(danhSach.getImg());
        name.setText(danhSach.getName());
        address.setText(danhSach.getSddress());



        return convertView;
    }
}
