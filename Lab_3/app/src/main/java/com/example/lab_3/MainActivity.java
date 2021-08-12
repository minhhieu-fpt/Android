package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText edtUser;
    EditText pass;

    String chuoi = "admin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtUser = findViewById(R.id.edt_user);
        pass = findViewById(R.id.edt_pass);
    }

    public void kiemtra (View v){

        String a = edtUser.getText().toString();
        String b = pass.getText().toString();

        if(a.equalsIgnoreCase(chuoi) && b.equalsIgnoreCase(chuoi)){
            Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        }
    }
}
