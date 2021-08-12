package com.example.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class User_Adapter extends BaseAdapter {

    List<User> userList;
    ViewHolder viewHolder;

    public User_Adapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
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
            viewHolder.txt_user = convertView.findViewById(R.id.txt_user);
            viewHolder.txt_pass = convertView.findViewById(R.id.txt_pass);

            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txt_user.setText(userList.get(position).getUser());
        viewHolder.txt_pass.setText(userList.get(position).getPassword());


        return convertView;
    }

    public class ViewHolder{
        TextView txt_user, txt_pass;

    }
}
