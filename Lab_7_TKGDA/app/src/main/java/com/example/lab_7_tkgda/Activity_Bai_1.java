package com.example.lab_7_tkgda;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class Activity_Bai_1 extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bai_1);

        button = findViewById(R.id.btn_click);

    }


    public void clickSnackBar(View view) {
        Snackbar.make(view,"Chắc chưa", 5000).setActionTextColor(Color.RED).setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }
}
