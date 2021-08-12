package com.example.lab4_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityKQ extends AppCompatActivity {


    TextView ketQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_q);

        ketQua = findViewById(R.id.txt_KQ);
        Intent i = getIntent();
        ketQua.setText(i.getStringExtra("BCNN"));
    }
}
