package com.example.lab_3_tkgda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Grid_Adapter extends BaseAdapter {

    List<GridVieww> gridViewws;
    ViewHolder viewHolder;

    public Grid_Adapter(List<GridVieww> gridViewws) {
        this.gridViewws = gridViewws;
    }

    @Override
    public int getCount() {
        return gridViewws.size();
    }

    @Override
    public Object getItem(int position) {
        return gridViewws.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowgrid, parent, false);

            viewHolder.imageView = convertView.findViewById(R.id.imgge_b3);
            viewHolder.textView = convertView.findViewById(R.id.textv_b3);

            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageView.setImageResource(gridViewws.get(position).getImg());
        viewHolder.textView.setText(gridViewws.get(position).getName());

        return convertView;
    }

    public class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
