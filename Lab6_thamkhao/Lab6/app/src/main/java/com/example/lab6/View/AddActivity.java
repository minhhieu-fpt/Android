package com.example.lab6.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab6.HandleData.SQLite;
import com.example.lab6.R;
import com.example.lab6.Student;

public class AddActivity extends AppCompatActivity {

    SQLite sqLite;
    Button btn_hoanTat;
    EditText edt_ten;
    EditText edt_id;
    EditText edt_lop;
    EditText edt_noiSinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btn_hoanTat = findViewById(R.id.btn_hoanTat);
        edt_id = findViewById(R.id.edt_id);
        edt_ten = findViewById(R.id.edt_ten);
        edt_lop = findViewById(R.id.edt_lop);
        edt_noiSinh = findViewById(R.id.edt_noiSinh);

        Intent i = getIntent();
        sqLite = new SQLite(this);
        btn_hoanTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_id.getText().toString().isEmpty()||edt_ten.getText().toString().isEmpty()||
                        edt_lop.getText().toString().isEmpty()||edt_noiSinh.getText().toString().isEmpty()){
                    Toast.makeText(AddActivity.this, "Không được để trống ô nào hết!", Toast.LENGTH_SHORT).show();
                    return;
                }
                for(Student student: sqLite.getAllStudent()) {
                    if (student.id.equals(edt_id.getText().toString())) {
                        Toast.makeText(AddActivity.this, "Id này đã tồn tại", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                sqLite.addStudent(new Student(
                        edt_id.getText().toString(),
                        edt_ten.getText().toString(),
                        edt_lop.getText().toString(),
                        edt_noiSinh.getText().toString()
                ));
                Intent i = new Intent(AddActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
