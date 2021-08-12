package com.example.thi_cuoi_ki;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView view;
    Button button;
    List<Thoi_Gian> userList;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.lv_listtg);
        button = findViewById(R.id.btn_add);
        userList = new ArrayList<>();
        SQLite sqLite_user = new SQLite(this);
        Thoi_Gian thoi_gian = new Thoi_Gian("Ăn trưa lúc 7h", "10/10/2020");
        sqLite_user.them(thoi_gian);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Them_Ghi_Chu.class);
                startActivity(intent);
            }
        });

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Xem_CT.class);
                Bundle bundle = new Bundle();
                bundle.putString("thoi_gian", userList.get(position).getThoigian());
                bundle.putString("noi_dung", userList.get(position).getNoidung());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        loadlist();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadlist();
    }

    void loadlist (){

        SQLite sqLite_user = new SQLite(this);
        userList = sqLite_user.getListThoiGian();
        Adapter user_adapter = new Adapter(userList);
        view.setAdapter(user_adapter);
    }
}
