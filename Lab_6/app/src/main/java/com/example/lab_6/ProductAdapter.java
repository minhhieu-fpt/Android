package com.example.lab_6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    List<Product> productList;
    Context context;
    ViewHolder viewHolder;
    MySQL mySQL;


    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }



    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            viewHolder = new ViewHolder();

            convertView =LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);

            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
            viewHolder.tv_price = convertView.findViewById(R.id.tv_price);
            viewHolder.btn_xoa = convertView.findViewById(R.id.btn_delete);

            viewHolder.btn_xoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Product product = productList.get(position);
                    mySQL.delete(productList.get(position).getID());
                    productList.remove(product);
                    notifyDataSetChanged();
                }
            });

            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_name.setText(productList.get(position).getTenSP());
        viewHolder.tv_price.setText(productList.get(position).getPrice());

        return convertView;
    }

    public class ViewHolder {

        TextView tv_name;
        TextView tv_price;
        Button btn_xoa;

    }
}
