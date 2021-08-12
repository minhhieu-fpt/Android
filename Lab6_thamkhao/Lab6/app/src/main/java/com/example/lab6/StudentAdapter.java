package com.example.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab6.HandleData.SQLite;
import com.example.lab6.View.EditActivity;

public class StudentAdapter extends BaseAdapter{

    SQLite sqLite;

    public StudentAdapter(SQLite sqLite){
        this.sqLite = sqLite;
    }

    public void reLoadData(){

    }

    @Override
    public int getCount() {
        return sqLite.getAllStudent().size();
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
    public View getView(int i, View view, ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_cell, parent, false);
        TextView tv_ten = view.findViewById(R.id.tv_ten);
        TextView tv_id = view.findViewById(R.id.tv_id);
        TextView tv_lop = view.findViewById(R.id.tv_idLop);
        TextView tv_noiSinh = view.findViewById(R.id.tv_noiSinh);
        Button btn_delete = view.findViewById(R.id.btn_delete);
        Button btn_edit = view.findViewById(R.id.btn_edit);
        final Student student = sqLite.getAllStudent().get(i);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(sqLite.context, EditActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", student.id);
                bundle.putString("ten",student.ten);
                bundle.putString("lop",student.lop);
                bundle.putString("noiSinh",student.noiSinh);
                i.putExtras(bundle);
                sqLite.context.startActivity(i);
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLite.delete(student.id);
            }
        });


        tv_id.setText(student.id);
        tv_ten.setText(student.ten);
        tv_lop.setText(student.lop);
        tv_noiSinh.setText(student.noiSinh);

        return view;
    }
}
