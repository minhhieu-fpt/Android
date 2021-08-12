package com.example.lab_3_tkgda;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

public class Spinner_Adapter implements SpinnerAdapter {
    List<Spinnerr> spinnerrList;

    public Spinner_Adapter(List<Spinnerr> spinnerrList) {
        this.spinnerrList = spinnerrList;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner, parent, false);
        ImageView imageView = convertView.findViewById(R.id.image_Spinner);
        TextView textView = convertView.findViewById(R.id.textview_spinner);

        imageView.setImageResource(spinnerrList.get(position).img);
        textView.setText(spinnerrList.get(position).ten);
        return convertView;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return spinnerrList.size();
    }

    @Override
    public Object getItem(int position) {
        return spinnerrList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner, parent, false);
        ImageView imageView = convertView.findViewById(R.id.image_Spinner);
        TextView textView = convertView.findViewById(R.id.textview_spinner);

        imageView.setImageResource(spinnerrList.get(position).img);
        textView.setText(spinnerrList.get(position).ten);
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
