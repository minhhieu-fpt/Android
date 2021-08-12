package com.example.lab4_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText soThuNhat, soThuHai;
    Button bcnn;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soThuNhat = (EditText) findViewById(R.id.edit_soThuNhat);
        soThuHai = (EditText) findViewById(R.id.edit_soThuHai);
        bcnn = findViewById(R.id.btn_BoiChung);


    }

    public void BCNN(View view) {
        i = new Intent(com.example.lab4_bai1.MainActivity.this, ActivityKQ.class);
        Bundle bundle = new Bundle();
        int a = Integer.parseInt(soThuNhat.getText().toString());
        int b = Integer.parseInt(soThuHai.getText().toString());
        int c = a * b;
        bundle.putInt("soThuNhat", a);
        bundle.putInt("soThuHai", b);
        bundle.putInt("BCNN", c);
        i.putExtra("BoiChungNN", bundle);
        i.putExtra("BCNN", String.valueOf(c));
        startActivity(i);
    }
}

