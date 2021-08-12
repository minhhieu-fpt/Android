package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_Bai_4 extends AppCompatActivity {
    EditText edt;
    TextView tv, tv2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bai_4);
        edt = findViewById(R.id.edt_text);
        tv = findViewById(R.id.textView2);
        tv2 = findViewById(R.id.textView3);
        btn = findViewById(R.id.buttonr);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(edt.getText().toString());
                tv2.setText(edt.getText().toString());
            }
        });

    }
}
