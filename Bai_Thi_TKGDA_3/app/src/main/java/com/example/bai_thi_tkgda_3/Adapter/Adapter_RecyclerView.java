package com.example.bai_thi_tkgda_3.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bai_thi_tkgda_3.MainActivity;
import com.example.bai_thi_tkgda_3.Model.My_Time;
import com.example.bai_thi_tkgda_3.R;
import com.example.bai_thi_tkgda_3.SQLite.MySQLite;
import com.example.bai_thi_tkgda_3.Sua_My_Time;

import java.util.List;

public class Adapter_RecyclerView extends RecyclerView.Adapter<Adapter_RecyclerView.ViewHolder_User> {

    List<My_Time> timeList;
    Context context;
    MainActivity mainActivity;
    MySQLite mySQLite;
    private AlertDialog alertDialog;
    int a;

    public Adapter_RecyclerView(List<My_Time> timeList, Context context, MainActivity mainActivity) {
        this.timeList = timeList;
        this.context = context;
        this.mainActivity = mainActivity;
    }


    @NonNull
    @Override
    public ViewHolder_User onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_recycler, parent, false);
        return new ViewHolder_User(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder_User holder, final int position) {
        a = position;
        holder.username_recyclerview.setText(timeList.get(position).getNoidung());
        holder.password_recyclerview.setText(timeList.get(position).getTime());


        holder.xoa_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MySQLite mySQLite = new MySQLite(context);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo!");
                builder.setMessage("Bạn có chắc muôn xóa không?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String ten = timeList.get(position).getNoidung();
                        mySQLite.delete_user(ten);
                        //Main_1
                        mainActivity.loadlist();

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }
        });

        holder.sua_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Sua_My_Time.class);

                intent.putExtra("noid", holder.username_recyclerview.getText().toString());
                intent.putExtra("timee", holder.password_recyclerview.getText().toString());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return timeList.size();
    }

    public class ViewHolder_User extends RecyclerView.ViewHolder {

        TextView username_recyclerview, password_recyclerview;
        ImageView sua_recyclerview, xoa_recyclerview;
        CardView cardView;

        public ViewHolder_User(@NonNull View itemView) {
            super(itemView);

            username_recyclerview = itemView.findViewById(R.id.username_recyclerview);
            password_recyclerview = itemView.findViewById(R.id.password_recyclerview);
            sua_recyclerview = itemView.findViewById(R.id.sua_recyclerview);
            xoa_recyclerview = itemView.findViewById(R.id.xoa_recyclerview);
            cardView = itemView.findViewById(R.id.cardview_user);

        }
    }
}
