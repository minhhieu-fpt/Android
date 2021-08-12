package com.example.asaimen_demo1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SVAdapter extends BaseAdapter {
List<SinhVien> listSV = new ArrayList<>();

    public SVAdapter(List<SinhVien> svList) {
    }

    @Override
    public int getCount() {
        return listSV.size();
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ruw,viewGroup,false);
        TextView tenSV = view.findViewById(R.id.txtTenSV);
        TextView ngaySinh = view.findViewById(R.id.txtNgaySinh);
        TextView stt = view.findViewById(R.id.txtTT);
        SinhVien sv = listSV.get(position);
        tenSV.setText(sv.getTenSV());
        ngaySinh.setText(sv.getNgaySinh());
        for(int i=0;i<3;i++){
            stt.setText(String.valueOf(i));
        }
        return view;
    }
}
