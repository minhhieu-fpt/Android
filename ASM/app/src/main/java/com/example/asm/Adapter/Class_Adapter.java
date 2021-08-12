package com.example.asm.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asm.Model.Class;
import com.example.asm.R;

import java.util.List;

public class Class_Adapter extends BaseAdapter {
    List<Class> classList;
    ViewHolder viewHolder;

    public Class_Adapter(List<Class> classList) {
        this.classList = classList;
    }

    @Override
    public int getCount() {
        return classList.size();
    }

    @Override
    public Object getItem(int position) {
        return classList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_class, parent, false);
            viewHolder.tvmalop = convertView.findViewById(R.id.tv_maLop);
            viewHolder.tvtenlop = convertView.findViewById(R.id.tv_tenLop);
            viewHolder.tvsst = convertView.findViewById(R.id.sttt);

            convertView.setTag(viewHolder);
        }else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvsst.setText(String.valueOf(position + 1));

        viewHolder.tvmalop.setText(classList.get(position).getMaLop());
        viewHolder.tvtenlop.setText(classList.get(position).getTenLop());

        return convertView;
    }

    public class ViewHolder {
        TextView tvsst, tvmalop, tvtenlop;
    }
}
