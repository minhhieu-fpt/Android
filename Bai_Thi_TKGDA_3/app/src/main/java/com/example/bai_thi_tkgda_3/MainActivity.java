package com.example.bai_thi_tkgda_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bai_thi_tkgda_3.Adapter.Adapter_RecyclerView;
import com.example.bai_thi_tkgda_3.Model.My_Time;
import com.example.bai_thi_tkgda_3.SQLite.MySQLite;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerview_user_PH10003;
    FloatingActionButton floatingActionButton_PH10003;
    List<My_Time> my_timeList;
    MySQLite mySQLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview_user_PH10003 = findViewById(R.id.recyclerview_user_PH10003);
        floatingActionButton_PH10003 = findViewById(R.id.floatingActionButton_PH10003);
        my_timeList = new ArrayList<>();
        mySQLite = new MySQLite(MainActivity.this);
        floatingActionButton_PH10003.setOnClickListener(new View.OnClickListener() {
            private AlertDialog alertDialog;
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Them.class);
                startActivity(intent);
            }
        });

        loadlist();
    }

    public void loadlist (){
        my_timeList = mySQLite.get_list_time();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
        recyclerview_user_PH10003.setLayoutManager(gridLayoutManager);
        Adapter_RecyclerView adapter_recyclerView = new Adapter_RecyclerView(my_timeList,MainActivity.this, MainActivity.this);

        recyclerview_user_PH10003.setAdapter(adapter_recyclerView);
        adapter_recyclerView.notifyDataSetChanged();

    }

    @Override
    protected void onResume() {
        loadlist();
        super.onResume();
    }
}
