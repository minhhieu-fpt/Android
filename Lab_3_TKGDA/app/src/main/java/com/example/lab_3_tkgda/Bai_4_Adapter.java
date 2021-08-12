package com.example.lab_3_tkgda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Bai_4_Adapter extends BaseAdapter {

    List<Listb4> listb4s;
    ViewHolder viewHolder;

    public Bai_4_Adapter(List<Listb4> listb4s) {
        this.listb4s = listb4s;
    }

    @Override
    public int getCount() {
        return listb4s.size();
    }

    @Override
    public Object getItem(int position) {
        return listb4s.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){

            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutb4, parent, false);
            viewHolder.imageView = convertView.findViewById(R.id.imgb4);
            viewHolder.textView = convertView.findViewById(R.id.textb4);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.imageView.setImageResource(listb4s.get(position).getImg());
        viewHolder.textView.setText(listb4s.get(position).getMame());
        return convertView;
    }

    public class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
