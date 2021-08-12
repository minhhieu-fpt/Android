package com.example.lab6.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab6.R;
import com.example.lab6.HandleData.SQLite;
import com.example.lab6.Student;

public class EditActivity extends AppCompatActivity {

    SQLite sqLite;
    TextView tv_id;
    EditText txt_ten;
    EditText txt_lop;
    EditText txt_noiSinh;
    Button btn_hoanTat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        tv_id = findViewById(R.id.tv_id);
        txt_ten = findViewById(R.id.txt_newName);
        txt_lop = findViewById(R.id.txt_newLop);
        txt_noiSinh = findViewById(R.id.txt_newNoiSinh);
        btn_hoanTat = findViewById(R.id.btn_hoanTat);

        sqLite = new SQLite(this);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        tv_id.setText(bundle.getString("id"));
        txt_ten.setText(bundle.getString("ten"));
        txt_lop.setText(bundle.getString("lop"));
        txt_noiSinh.setText(bundle.getString("noiSinh"));

        btn_hoanTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_ten.getText().toString().isEmpty()|| txt_lop.getText().toString().isEmpty()||txt_noiSinh.getText().toString().isEmpty()){
                    Toast.makeText(EditActivity.this, "Không được để trống ô nào hết!", Toast.LENGTH_SHORT).show();
                    return;
                }
                sqLite.upDate(new Student(
                        tv_id.getText().toString(),
                        txt_ten.getText().toString(),
                        txt_lop.getText().toString(),
                        txt_noiSinh.getText().toString()
                ));
                Intent i = new Intent(EditActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
