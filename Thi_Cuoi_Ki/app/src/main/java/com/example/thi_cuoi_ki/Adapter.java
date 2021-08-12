package com.example.thi_cuoi_ki;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    List<Thoi_Gian> thoi_gianList;
    ViewHolder viewHolder;
    SQLite sqLite;
    int a;

    public Adapter(List<Thoi_Gian> thoi_gianList) {
        this.thoi_gianList = thoi_gianList;
    }

    @Override
    public int getCount() {
        return thoi_gianList.size();
    }

    @Override
    public Object getItem(int position) {
        return thoi_gianList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
            viewHolder.txt_user = convertView.findViewById(R.id.txt_users);
            viewHolder.txt_pass = convertView.findViewById(R.id.txt_passs);


//            viewHolder.button_xoa = convertView.findViewById(R.id.btn_xoad);

            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txt_user.setText(thoi_gianList.get(position).getThoigian());
        viewHolder.txt_pass.setText(thoi_gianList.get(position).getNoidung());


//        viewHolder.button_xoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                sqLite.xoa(thoi_gian.getThoigian());
//
//
//            }
//        });


        return convertView;
    }

    public class ViewHolder{
        TextView txt_user, txt_pass;
//        Button button_xoa;
    }
}
