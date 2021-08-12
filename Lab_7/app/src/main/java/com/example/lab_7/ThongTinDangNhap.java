package com.example.lab_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThongTinDangNhap extends AppCompatActivity {

    TextView tv_tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_dang_nhap);

        tv_tt = findViewById(R.id.tv_tt);

        SharedPreferences sharedPreferences = getSharedPreferences("file.ref", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", null);

        if(name != null){

            tv_tt.setText("Xin Chào " + name);

        }

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){

            tv_tt.setText("Xin Chào " + bundle.getString("name"));
        }
    }

    public void thoat (View v){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            finish();

    }


}
