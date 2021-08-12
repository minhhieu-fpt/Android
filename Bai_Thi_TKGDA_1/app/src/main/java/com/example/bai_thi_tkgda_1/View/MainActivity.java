package com.example.bai_thi_tkgda_1.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.bai_thi_tkgda_1.Adapter.Adapter_RecyclerView;
import com.example.bai_thi_tkgda_1.Adapter.Adapter_ViewPager;
import com.example.bai_thi_tkgda_1.Model.Use;
import com.example.bai_thi_tkgda_1.R;
import com.example.bai_thi_tkgda_1.SQLite.MySQLite;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    List<Use> useList;
//    RecyclerView recyclerView;
//    Button dangnhap, dangki;
//    MySQLite mySQLite;
//    Adapter_RecyclerView adapter_recyclerView;
//    int count = 1;
//    private AlertDialog alertDialog;

    // Main 2
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Bài Thi");

        tabLayout = findViewById(R.id.tablayout_main2_PH10003);
        viewPager = findViewById(R.id.viewpagert_main2_PH10003);

        tabLayout.addTab(tabLayout.newTab().setText("Tab List"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab DK"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });
        Adapter_ViewPager adapter_viewPager = new Adapter_ViewPager(getSupportFragmentManager());
        viewPager.setAdapter(adapter_viewPager);

        // Main_Activity
//        recyclerView = findViewById(R.id.recyclerview_user);
//        useList = new ArrayList<>();
//        mySQLite = new MySQLite(MainActivity.this);
//
//        dangnhap = findViewById(R.id.dangnhap);
//        dangki = findViewById(R.id.dangki);
//
//        dangnhap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_dang_nhap, null);
//                builder.setView(view);
//                final TextInputLayout dangnhapUsername;
//                final TextInputEditText textdangnhapussername;
//                final TextInputLayout dangnhapPassword;
//                final TextInputEditText textdangnhappass;
//                final Button dangnhapDialog;
//                final Button huyDangnhapDialog;
//
//                dangnhapUsername = view.findViewById(R.id.dangnhap_username);
//                textdangnhapussername = view.findViewById(R.id.textdangnhapussername);
//                dangnhapPassword = view.findViewById(R.id.dangnhap_password);
//                textdangnhappass = view.findViewById(R.id.textdangnhappass);
//                dangnhapDialog = view.findViewById(R.id.dangnhap_dialog);
//                huyDangnhapDialog = view.findViewById(R.id.huy_dangnhap_dialog);
//                dangnhapDialog.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if(dangnhapUsername.getEditText().length() == 0 && textdangnhapussername.getText().toString().trim().isEmpty()){
//
//                            dangnhapUsername.setError("Nhập dùm cái tên!");
//                        } else if (mySQLite.check_ton_tai(textdangnhapussername.getText().toString().trim()) == -1){
//                            dangnhapUsername.setError("Tên không tồn tại!");
//                        } else {
//                            dangnhapUsername.setError("");
//                        }
//
//                        if (dangnhapUsername.getError() == null){
//                            if(dangnhapPassword.getEditText().length() == 0){
//                                dangnhapPassword.setError("Nhập Password!");
//                            } else if (dangnhapPassword.getEditText().length() < 6){
//                                dangnhapPassword.setError("Password lớn hơn 6 kí tự!");
//                            } else if (!mySQLite.get_list_user().get(mySQLite.check_ton_tai(textdangnhapussername.getText().toString().trim())).getPassword().equals(textdangnhappass.getText().toString())){
//                                dangnhapPassword.setError("Password không đúng!");
//                            } else {
//                                dangnhapPassword.setError("");
//                            }
//                        }
//
//                        if(dangnhapUsername.getError() == null && dangnhapPassword.getError() == null) {
//
//                            Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_LONG).show();
//                            alertDialog.dismiss();
//                        }
//                    }
//                });
//
//                huyDangnhapDialog.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        alertDialog.dismiss();
//                    }
//                });
//
//                builder.create();
//                alertDialog = builder.show();
//            }
//        });
//
//        dangki.setOnClickListener(new View.OnClickListener() {
//            private AlertDialog alertDialogg;
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_dang_ki, null);
//                builder.setView(view);
//
//                 final TextInputLayout dkUsername;
//                 final TextInputLayout dkPassword;
//                 final TextInputLayout dkNhapLaiPassword;
//                 final TextInputEditText textpass;
//                 final TextInputEditText textpasslai;
//                 final TextInputEditText textussername;
//                 Button dangkiDialog;
//                 Button huyDialog;
//
//                dkUsername = view.findViewById(R.id.dk_username);
//                dkPassword = view.findViewById(R.id.dk_password);
//                dkNhapLaiPassword = view.findViewById(R.id.dk_nhap_lai_password);
//
//
//                textussername = view.findViewById(R.id.textussername);
//                textpass = view.findViewById(R.id.textpass);
//                textpasslai = view.findViewById(R.id.textpasslai);
//
//                dangkiDialog = view.findViewById(R.id.dangki_dialog);
//                huyDialog = view.findViewById(R.id.huy_dialog);
//
//
//                dangkiDialog.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if(dkUsername.getEditText().length() == 0 && textussername.getText().toString().trim().isEmpty()){
//
//                            dkUsername.setError("Nhập dùm cái tên!");
//                            count = 1;
//                        } else if (mySQLite.check_ton_tai(textussername.getText().toString().trim()) != -1){
//                            dkUsername.setError("Tên đã tồn tại!");
//                            count = 1;
//                        } else {
//                            dkUsername.setError("");
//                            count = 0;
//                        }
//
//                        if(dkPassword.getEditText().length() == 0){
//                            dkPassword.setError("Nhập Password!");
//                            count = 1;
//                        } else if (dkPassword.getEditText().length() < 6){
//                            dkPassword.setError("Password lớn hơn 6 kí tự!");
//                            count = 1;
//                        } else {
//                            dkPassword.setError("");
//                            count = 0;
//                        }
//
//                        if(dkNhapLaiPassword.getEditText().length() == 0){
//                            dkNhapLaiPassword.setError("Nhập Password!");
//                            count = 1;
//                        } else if (dkNhapLaiPassword.getEditText().length() < 6){
//                            dkNhapLaiPassword.setError("Password lớn hơn 6 kí tự!");
//                            count = 1;
//                        }  else if(!textpasslai.getText().toString().equals(textpass.getText().toString())){
//                            dkNhapLaiPassword.setError("Password phải trùng nhau!");
//                            count = 1;
//                        } else if (textpasslai.getText().toString().equals(textpass.getText().toString())){
//                            dkNhapLaiPassword.setError("");
//                            count = 0;
//                        }
//
//
//
//                        if(dkUsername.getError() == null && dkPassword.getError() == null && dkNhapLaiPassword.getError() == null){
//
//                            Use use = new Use();
//                            use.setUser_name(textussername.getText().toString());
//                            use.setPassword(textpass.getText().toString());
//                            mySQLite.add_user(use);
//
//                            loadlist();
//                            alertDialogg.dismiss();
//                        }
//
//                    }
//                });
//
//                huyDialog.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        alertDialogg.dismiss();
//                    }
//                });
//
//                builder.create();
//                alertDialogg = builder.show();
//            }
//        });
//        loadlist();

    }

//    public void loadlist (){
//        useList = mySQLite.get_list_user();
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        adapter_recyclerView = new Adapter_RecyclerView(useList,MainActivity.this, MainActivity.this);
//
//        recyclerView.setAdapter(adapter_recyclerView);
//        adapter_recyclerView.notifyDataSetChanged();
//
//    }
}