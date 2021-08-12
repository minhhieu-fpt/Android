package com.example.bai_thi_tkgda_1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bai_thi_tkgda_1.Adapter.Adapter_RecyclerView;
import com.example.bai_thi_tkgda_1.Model.Use;
import com.example.bai_thi_tkgda_1.R;
import com.example.bai_thi_tkgda_1.SQLite.MySQLite;
import com.example.bai_thi_tkgda_1.View.MainActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Chuc_Nang_Fragment extends Fragment {

    public Button dangnhap;
    public Button dangki;
    private AlertDialog alertDialog;
    MySQLite mySQLite;

    List_DS_Fragment_Main2 list_ds_fragment_main2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chuc_nang_fragment, container, false);
        dangnhap = view.findViewById(R.id.dangnhap);
        dangki = view.findViewById(R.id.dangki);
        mySQLite = new MySQLite(view.getContext());
        list_ds_fragment_main2 = new List_DS_Fragment_Main2(Chuc_Nang_Fragment.this);

        final Adapter_RecyclerView adapter_recyclerView = new Adapter_RecyclerView(mySQLite.get_list_user(),view.getContext(),list_ds_fragment_main2);
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                final View view = LayoutInflater.from(v.getContext()).inflate(R.layout.dialog_dang_nhap, null);
                builder.setView(view);
                final TextInputLayout dangnhapUsername;
                final TextInputEditText textdangnhapussername;
                final TextInputLayout dangnhapPassword;
                final TextInputEditText textdangnhappass;
                final Button dangnhapDialog;
                final Button huyDangnhapDialog;

                dangnhapUsername = view.findViewById(R.id.dangnhap_username);
                textdangnhapussername = view.findViewById(R.id.textdangnhapussername);
                dangnhapPassword = view.findViewById(R.id.dangnhap_password);
                textdangnhappass = view.findViewById(R.id.textdangnhappass);
                dangnhapDialog = view.findViewById(R.id.dangnhap_dialog);
                huyDangnhapDialog = view.findViewById(R.id.huy_dangnhap_dialog);
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

                            Toast.makeText(view.getContext(), "Thành công", Toast.LENGTH_LONG).show();
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

        dangki.setOnClickListener(new View.OnClickListener() {
            private AlertDialog alertDialogg;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                View view = LayoutInflater.from(v.getContext()).inflate(R.layout.dialog_dang_ki, null);
                builder.setView(view);

                 final TextInputLayout dkUsername;
                 final TextInputLayout dkPassword;
                 final TextInputLayout dkNhapLaiPassword;
                 final TextInputEditText textpass;
                 final TextInputEditText textpasslai;
                 final TextInputEditText textussername;
                 Button dangkiDialog;
                 Button huyDialog;

                dkUsername = view.findViewById(R.id.dk_username);
                dkPassword = view.findViewById(R.id.dk_password);
                dkNhapLaiPassword = view.findViewById(R.id.dk_nhap_lai_password);


                textussername = view.findViewById(R.id.textussername);
                textpass = view.findViewById(R.id.textpass);
                textpasslai = view.findViewById(R.id.textpasslai);

                dangkiDialog = view.findViewById(R.id.dangki_dialog);
                huyDialog = view.findViewById(R.id.huy_dialog);


                dangkiDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(dkUsername.getEditText().length() == 0 && textussername.getText().toString().trim().isEmpty()){

                            dkUsername.setError("Nhập dùm cái tên!");
                        } else if (mySQLite.check_ton_tai(textussername.getText().toString().trim()) != -1){
                            dkUsername.setError("Tên đã tồn tại!");
                        } else {
                            dkUsername.setError("");
                        }

                        if(dkPassword.getEditText().length() == 0){
                            dkPassword.setError("Nhập Password!");
                        } else if (dkPassword.getEditText().length() < 6){
                            dkPassword.setError("Password lớn hơn 6 kí tự!");
                        } else {
                            dkPassword.setError("");
                        }

                        if(dkNhapLaiPassword.getEditText().length() == 0){
                            dkNhapLaiPassword.setError("Nhập Password!");
                        } else if (dkNhapLaiPassword.getEditText().length() < 6){
                            dkNhapLaiPassword.setError("Password lớn hơn 6 kí tự!");
                        }  else if(!textpasslai.getText().toString().equals(textpass.getText().toString())){
                            dkNhapLaiPassword.setError("Password phải trùng nhau!");
                        } else if (textpasslai.getText().toString().equals(textpass.getText().toString())){
                            dkNhapLaiPassword.setError("");
                        }



                        if(dkUsername.getError() == null && dkPassword.getError() == null && dkNhapLaiPassword.getError() == null){

                            Use use = new Use();
                            use.setUser_name(textussername.getText().toString());
                            use.setPassword(textpass.getText().toString());
                            mySQLite.add_user(use);
//                            Intent intent = new Intent(,MainActivity.class);
                            alertDialogg.dismiss();
                        }

                    }
                });

                huyDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialogg.dismiss();
                    }
                });

                builder.create();
                alertDialogg = builder.show();
            }
        });
        return view;
    }
}
