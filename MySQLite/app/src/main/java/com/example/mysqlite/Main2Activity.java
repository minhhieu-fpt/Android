package com.example.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MainActivity mainActivity = new MainActivity(Main2Activity.this);



        SinhVien sinhVien = new SinhVien("Ph10003", "Hieu", "Phu Tho", "01082001", "PT15355");
        mainActivity.themsinhvien(sinhVien);
    }
}
