package com.example.lab_3_bai_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView subjectss;
    static final String[] Subjects = new String[] {"Android cơ bản", "Android nâng cao", "Thiết kế giao diện Android", "Test và triển khai ứng dụng Android", "Node JS", "Game 2D"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectss = findViewById(R.id.lvds);
        //    Context context;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, Subjects);
        subjectss.setAdapter(adapter);

        subjectss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, Subjects[position],Toast.LENGTH_SHORT).show();
            }
        });

    }





}
