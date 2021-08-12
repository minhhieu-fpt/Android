package com.example.asm.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asm.Model.Student;
import com.example.asm.R;

import java.util.List;

public class Student_Adapter extends BaseAdapter {
    List<Student> list_student;
    ViewHolder viewHolder;

    public Student_Adapter(List<Student> list_student) {
        this.list_student = list_student;
    }

    @Override
    public int getCount() {
        return list_student.size();
    }

    @Override
    public Object getItem(int position) {
        return list_student.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_student, parent, false);
            viewHolder.tv_stt = convertView.findViewById(R.id.stt);
            viewHolder.tv_tenSV = convertView.findViewById(R.id.tv_tenSV);
            viewHolder.tv_ngaySinh = convertView.findViewById(R.id.tv_ngaySinh);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


            viewHolder.tv_stt.setText(String.valueOf(position + 1));

        viewHolder.tv_tenSV.setText(list_student.get(position).getTenSinhVien());
        viewHolder.tv_ngaySinh.setText(list_student.get(position).getNgaySinh());

        return convertView;
    }

    public class ViewHolder{
        TextView tv_stt, tv_tenSV, tv_ngaySinh;
    }
}
