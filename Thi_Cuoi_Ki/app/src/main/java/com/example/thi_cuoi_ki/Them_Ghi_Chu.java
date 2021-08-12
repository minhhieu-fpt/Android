package com.example.thi_cuoi_ki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Them_Ghi_Chu extends AppCompatActivity {

    EditText edt_user, edt_pass;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them__ghi__chu);
        edt_user = findViewById(R.id.edt_user);
        edt_pass = findViewById(R.id.edt_pass);
        btn_login = findViewById(R.id.btn_login);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            edt_user.setText(bundle.getString("noi_dung", ""));
            edt_pass.setText(bundle.getString("thoi_gian", ""));


        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_user.getText().toString().isEmpty()){
                    Toast.makeText(Them_Ghi_Chu.this, "Không đc để trống nội dung.", Toast.LENGTH_LONG).show();
                    return;

                } else if (edt_pass.getText().toString().isEmpty()){
                    Toast.makeText(Them_Ghi_Chu.this, "Không đc để trống Thời gian.", Toast.LENGTH_LONG).show();
                    return;
                }
                SQLite sqLite = new SQLite(Them_Ghi_Chu.this);
                Thoi_Gian thoi_gian = new Thoi_Gian(edt_user.getText().toString(),edt_pass.getText().toString());
                sqLite.them(thoi_gian);
                Toast.makeText(Them_Ghi_Chu.this, "Thêm Thành công.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
