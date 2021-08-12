package com.example.lab_3_bai_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_ManHinhKQ_Bai_2 extends AppCompatActivity {


    TextView tvKQx1;
    TextView tvKQx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__man_hinh_k_q__bai_2);

        tvKQx1 = findViewById(R.id.tv_KQx1);
        tvKQx2 = findViewById(R.id.tv_KQx2);

        Intent i = getIntent();
        tvKQx1.setText(i.getStringExtra("key_1"));

        Intent j = getIntent();
        tvKQx2.setText(j.getStringExtra("key_2"));
    }
}
