package com.example.thi_cuoi_ki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Xem_CT extends AppCompatActivity {
    TextView nd, tg;
    Button xoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem__c_t);

        nd = findViewById(R.id.tv_noidung);
        tg = findViewById(R.id.tv_thoigian);
        xoa = findViewById(R.id.btn_xoaaaaa);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            nd.setText(bundle.getString("thoi_gian", ""));
            tg.setText(bundle.getString("noi_dung", ""));


        }
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLite sqLite = new SQLite(Xem_CT.this);
                sqLite.xoa(nd.getText().toString());

            }
        });
    }
}
