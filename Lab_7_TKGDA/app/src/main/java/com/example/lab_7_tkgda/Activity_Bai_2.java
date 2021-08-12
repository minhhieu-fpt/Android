package com.example.lab_7_tkgda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Activity_Bai_2 extends AppCompatActivity {
    TextInputLayout textInputLayout1;
    TextInputLayout textInputLayout2;
    TextInputLayout textInputLayout3;
    Button button;
//    String bt = /[0-9]{1-2}/;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bai_2);
        textInputLayout1 = findViewById(R.id.name);
        textInputLayout2 = findViewById(R.id.email);
        textInputLayout3 = findViewById(R.id.pass);


        button = findViewById(R.id.button_b2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textInputLayout1.getEditText().length() == 0){

                    textInputLayout1.setError("Nhập Name.");

                } else {
                    textInputLayout1.setError("");
                }

                if(textInputLayout2.getEditText().length() == 0){

                    textInputLayout2.setError("Nhập Email.");

                }  else {
                    textInputLayout2.setError("");
                }

                if(textInputLayout3.getEditText().length() == 0){

                    textInputLayout3.setError("Nhập Password.");

                } else if(textInputLayout3.getEditText().length() < 6){

                    textInputLayout3.setError("Password lớn hơn 6 kí tự.");

                } else {
                textInputLayout3.setError("");
            }
            }
        });

    }
}
