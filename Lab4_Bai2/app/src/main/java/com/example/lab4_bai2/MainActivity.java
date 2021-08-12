package com.example.lab4_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText sdt = (EditText) findViewById(R.id.edit_SDT);
        dial = (Button) findViewById(R.id.btn_dial);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String soDT = sdt.getText().toString();
                if (!TextUtils.isEmpty(soDT)) {
                    String Dail = "tel:" + soDT;
                    Intent intent =new Intent(Intent.ACTION_DIAL, Uri.parse(Dail));
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"Nhap So Dien Thoai",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
