package com.example.asaimen_demo1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SVAdapter extends BaseAdapter {

    List<SinhVien> lstSinhVien;

    public SVAdapter(List<SinhVien> lstSinhVien) {
        this.lstSinhVien = lstSinhVien;
    }

    @Override
    public int getCount() {
        return lstSinhVien.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ruw,viewGroup,false);
        TextView stt = view.findViewById(R.id.txtTT);
        TextView tvID = view.findViewById(R.id.txtTenSV);
        TextView tvName = view.findViewById(R.id.txtNgaySinh);

        SinhVien sv = lstSinhVien.get(i);
        tvID.setText(sv.idSV);
        tvName.setText(sv.ngaySinh);
        return view;
    }
}
