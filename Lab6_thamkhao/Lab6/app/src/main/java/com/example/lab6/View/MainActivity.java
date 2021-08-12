package com.example.lab6.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.lab6.HandleData.SQLite;
import com.example.lab6.R;
import com.example.lab6.StudentAdapter;

public class MainActivity extends AppCompatActivity {

    ListView lstStudents;
    StudentAdapter studentAdapter;
    SQLite sqLite;
    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstStudents = findViewById(R.id.lst_students);
        btn_add = findViewById(R.id.btn_add);

        sqLite = new SQLite(this);
        studentAdapter = new StudentAdapter(sqLite);
        lstStudents.setAdapter(studentAdapter);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivity(i);
            }
        });
    }

    public void reloadData(){
        lstStudents.setAdapter(studentAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        reloadData();
    }
}
