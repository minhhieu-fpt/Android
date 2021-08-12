package com.example.lab_4_tkgda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Activity_Bai_4 extends AppCompatActivity {
    ListView listView;
    String[] mang = {"1","2","3","4","5","6","7","8"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bai_4);
        listView = findViewById(R.id.listb4);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Activity_Bai_4.this, android.R.layout.simple_list_item_1,mang);
        listView.setAdapter(arrayAdapter);


        registerForContextMenu(listView);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.homeb4,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }


}
