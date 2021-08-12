package com.example.lab5_bai1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    Context context;
    List<Product> products;
    ViewHolder viewHolder = null;
    public ProductAdapter( Context context, List<Product> Products) {
        this.products = Products;
        this.context = context;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Product product = products.get(position);
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
            viewHolder.tv_price = convertView.findViewById(R.id.tv_price);
            viewHolder.img = convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_name.setText(product.getName());
        viewHolder.tv_price.setText(product.getPrice());
        viewHolder.img.setImageResource(product.getImg());

        return convertView;
    }

    public class ViewHolder  {

        TextView tv_name;
        TextView tv_price;
        ImageView img;
    }
}
