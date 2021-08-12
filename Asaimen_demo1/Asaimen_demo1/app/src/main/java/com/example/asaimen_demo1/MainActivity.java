package com.example.asaimen_demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void them(View view){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
    public void xemDanhSachLop(View view){
          Intent  intent = new Intent(MainActivity.this,Main3Activity.class);
          startActivity(intent);

    }
    public void quanLySinhVien(View view){
        Intent intent = new Intent(MainActivity.this,Main4Activity.class);
        startActivity(intent);

    }
}
