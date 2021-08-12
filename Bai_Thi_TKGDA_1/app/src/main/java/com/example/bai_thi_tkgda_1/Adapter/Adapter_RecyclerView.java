package com.example.bai_thi_tkgda_1.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bai_thi_tkgda_1.Fragment.List_DS_Fragment_Main2;
import com.example.bai_thi_tkgda_1.Model.Use;
import com.example.bai_thi_tkgda_1.R;
import com.example.bai_thi_tkgda_1.SQLite.MySQLite;
import com.example.bai_thi_tkgda_1.View.MainActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class Adapter_RecyclerView extends RecyclerView.Adapter<Adapter_RecyclerView.ViewHolder_User> {

    List<Use> useList;
    Context context;
    MainActivity mainActivity;
    MySQLite mySQLite;
    List_DS_Fragment_Main2 list_ds_fragment_main2;
    private AlertDialog alertDialog;
    int a;

    public Adapter_RecyclerView(List<Use> useList, Context context, MainActivity mainActivity) {
        this.useList = useList;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    public Adapter_RecyclerView(List<Use> useList, Context context, List_DS_Fragment_Main2 list_ds_fragment_main2) {
        this.useList = useList;
        this.context = context;
        this.list_ds_fragment_main2 = list_ds_fragment_main2;
    }

    @NonNull
    @Override
    public ViewHolder_User onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_recycler, parent, false);
        return new ViewHolder_User(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_User holder,final int position) {
        a = position;
        holder.username_recyclerview.setText(useList.get(position).getUser_name());
        holder.password_recyclerview.setText(useList.get(position).getPassword());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view = LayoutInflater.from(context).inflate(R.layout.dialog_dang_nhap, null);
                builder.setView(view);

                final TextInputLayout dangnhapUsername;
                final TextInputEditText textdangnhapussername;
                final TextInputLayout dangnhapPassword;
                final TextInputEditText textdangnhappass;
                final Button dangnhapDialog;
                final Button huyDangnhapDialog;
                mySQLite = new MySQLite(context);

                dangnhapUsername = view.findViewById(R.id.dangnhap_username);
                textdangnhapussername = view.findViewById(R.id.textdangnhapussername);
                dangnhapPassword = view.findViewById(R.id.dangnhap_password);
                textdangnhappass = view.findViewById(R.id.textdangnhappass);
                dangnhapDialog = view.findViewById(R.id.dangnhap_dialog);
                huyDangnhapDialog = view.findViewById(R.id.huy_dangnhap_dialog);

                textdangnhapussername.setText(useList.get(position).getUser_name());
                textdangnhappass.setText(useList.get(position).getPassword());

                dangnhapDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(dangnhapUsername.getEditText().length() == 0 && textdangnhapussername.getText().toString().trim().isEmpty()){

                            dangnhapUsername.setError("Nhập dùm cái tên!");
                        } else if (mySQLite.check_ton_tai(textdangnhapussername.getText().toString().trim()) == -1){
                            dangnhapUsername.setError("Tên không tồn tại!");
                        } else {
                            dangnhapUsername.setError("");
                        }

                        if (dangnhapUsername.getError() == null){
                            if(dangnhapPassword.getEditText().length() == 0){
                                dangnhapPassword.setError("Nhập Password!");
                            } else if (dangnhapPassword.getEditText().length() < 6){
                                dangnhapPassword.setError("Password lớn hơn 6 kí tự!");
                            } else if (!mySQLite.get_list_user().get(mySQLite.check_ton_tai(textdangnhapussername.getText().toString().trim())).getPassword().equals(textdangnhappass.getText().toString())){
                                dangnhapPassword.setError("Password không đúng!");
                            } else {
                                dangnhapPassword.setError("");
                            }
                        }

                        if(dangnhapUsername.getError() == null && dangnhapPassword.getError() == null) {

                            Toast.makeText( context, "Thành công", Toast.LENGTH_LONG).show();
                            alertDialog.dismiss();
                        }
                    }
                });

                huyDangnhapDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                builder.create();
                alertDialog = builder.show();
            }
        });

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
                        String ten = useList.get(position).getUser_name();
                        mySQLite.delete_user(ten);
                        //Main_1
//                        mainActivity.loadlist();
                        //Main_2
                        list_ds_fragment_main2.loadlist();
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
            private AlertDialog alertDialog;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view = LayoutInflater.from(context).inflate(R.layout.edit_user, null);
                builder.setView(view);
                final MySQLite mySQLite = new MySQLite(context);
                final TextInputLayout editUsername;
                final TextInputEditText texteditussername;
                final TextInputLayout editPassword;
                final TextInputEditText texteditpass;
                Button editDialog;
                Button huyEditDialog;

                editUsername = view.findViewById(R.id.edit_username);
                texteditussername = view.findViewById(R.id.texteditussername);
                editPassword = view.findViewById(R.id.edit_password);
                texteditpass = view.findViewById(R.id.texteditpass);
                editDialog = view.findViewById(R.id.edit_dialog);
                huyEditDialog = view.findViewById(R.id.huy_edit_dialog);

                texteditussername.setText(mySQLite.get_list_user().get(position).getUser_name());
                texteditpass.setText(mySQLite.get_list_user().get(position).getPassword());

                editDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(editUsername.getEditText().length() == 0 && texteditussername.getText().toString().trim().isEmpty()){

                            editUsername.setError("Nhập dùm cái tên!");
                        } else if (mySQLite.check_ton_tai(texteditussername.getText().toString().trim()) == -1){
                            editUsername.setError("Tên không tồn tại!");
                        } else {
                            editUsername.setError("");
                        }

                        if(editPassword.getEditText().length() == 0){
                            editPassword.setError("Nhập Password!");
                        } else if (editPassword.getEditText().length() < 6){
                            editPassword.setError("Password lớn hơn 6 kí tự!");
                        } else {
                            editPassword.setError("");
                        }

                        if(editUsername.getError() == null && editPassword.getError() == null){
                            Use use = new Use(mySQLite.get_list_user().get(position).getUser_name(),texteditpass.getText().toString());
                            mySQLite.edit_user(use);
                            //Main_1
//                            mainActivity.loadlist();
                            //Main_2
                            list_ds_fragment_main2.loadlist();
                            alertDialog.dismiss();
                        }
                    }
                });

                huyEditDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                builder.create();
                alertDialog = builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return useList.size();
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
