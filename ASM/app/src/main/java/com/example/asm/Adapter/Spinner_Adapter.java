package com.example.asm.Adapter;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.asm.Model.Class;
import com.example.asm.R;

import java.util.List;

public class Spinner_Adapter implements SpinnerAdapter {
    List<Class> classList;

    public Spinner_Adapter(List<Class> classList) {
        this.classList = classList;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drop_row, parent, false);

        TextView textView = convertView.findViewById(R.id.tvName_drop);
        textView.setText(classList.get(position).getMaLop());
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
        return classList.size();
    }

    @Override
    public Class getItem(int position) {
        return classList.get(position);
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

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drop_row, parent, false);
        TextView textView = convertView.findViewById(R.id.tvName_drop);
        textView.setText(classList.get(position).getMaLop());
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
