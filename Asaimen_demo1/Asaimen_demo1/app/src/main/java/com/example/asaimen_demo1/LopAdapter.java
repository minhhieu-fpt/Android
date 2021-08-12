package com.example.asaimen_demo1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LopAdapter extends BaseAdapter {
    List<Lop> listlp;

    public LopAdapter(List<Lop> listlp) {
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup,false);
        TextView stt = view.findViewById(R.id.txtSTT);
        TextView IdLop = view.findViewById(R.id.txtMaLop);
        TextView TenLop = view.findViewById(R.id.txtTenLop);
        for(int i=0;i<3;i++){
            stt.setText(String.valueOf(i));
        }
        Lop lp = listlp.get(position);

        IdLop.setText(lp.getIdlop());
        TenLop.setText(lp.getTenLop());

        return view;
    }
}
