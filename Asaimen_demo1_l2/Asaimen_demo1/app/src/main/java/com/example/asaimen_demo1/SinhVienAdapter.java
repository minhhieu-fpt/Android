package com.example.asaimen_demo1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    List<Lop> listlp;

    public SinhVienAdapter(List<Lop> listlp) {
        this.listlp = listlp;
    }


    @Override
    public int getCount() {
        return listlp.size();
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rew,viewGroup,false);
        TextView IdLop = view.findViewById(R.id.tvID);
        TextView TenLop = view.findViewById(R.id.tvName);
        Lop lp = listlp.get(position);
        IdLop.setText(lp.getIdlop());
        TenLop.setText(lp.getIdlop());
        return view;
    }
}
