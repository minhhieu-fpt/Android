package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class kq extends AppCompatActivity {

    TextView htKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kq);
        htKQ = findViewById(R.id.htKQ);


        Intent i = getIntent();
        htKQ.setText(i.getStringExtra("key_1"));
    }

}
