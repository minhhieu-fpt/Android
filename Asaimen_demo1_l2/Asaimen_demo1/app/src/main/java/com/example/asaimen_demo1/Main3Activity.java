package com.example.asaimen_demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    ListView lvList;
    List<Lop> lopList;
    int index = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Lop lop1 = new Lop("MOB101", "MOB15355");
        Lop lop2 = new Lop("MOB102", "MOB15356");
        Lop lop3 = new Lop("MOB103", "MOB15357");
        lopList = new ArrayList<>();
        lopList.add(lop1);
        lopList.add(lop2);
        lopList.add(lop3);
       // lopList.add(lop4);
        lvList = findViewById(R.id.lvListLop);
        MySQLite mySQLite = new MySQLite(Main3Activity.this);
        for (Lop x : lopList) {
            mySQLite.themLop(x);
        }

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


        loadList();
    }
    public void loadList() {
        MySQLite mySQLite = new MySQLite(Main3Activity.this);
        lopList = mySQLite.getListLopAll();
       LopAdapter sinhVienAdapter = new LopAdapter(lopList);

        lvList.setAdapter(sinhVienAdapter);
    }
}
