package com.example.lab4_bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<DanhSach> sachList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvds);
        sachList = new ArrayList<>();

        for (int i = 0; i < 10; i++){

            DanhSach danhSach = new DanhSach();
            danhSach.setName("Ta Minh Hieu" + new Random());
            danhSach.setSddress("Phu Tho" + new Random());
            sachList.add(danhSach);

        }

        DanhSachAdapter danhSachAdapter = new DanhSachAdapter(MainActivity.this, sachList);
        listView.setAdapter(danhSachAdapter);

    }
}
