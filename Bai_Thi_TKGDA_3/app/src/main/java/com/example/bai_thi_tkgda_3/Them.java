package com.example.bai_thi_tkgda_3;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bai_thi_tkgda_3.Model.My_Time;
import com.example.bai_thi_tkgda_3.SQLite.MySQLite;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class Them extends AppCompatActivity {

    TextInputLayout dangnhapUsername;
    TextInputEditText textdangnhapussername;
    TextInputLayout dangnhapPassword;
    TextInputEditText textdangnhappass;
    Button huyDangnhapDialog;
    Button dangnhapDialog;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_them);

        dangnhapUsername = findViewById(R.id.dangnhap_username);
        textdangnhapussername = findViewById(R.id.textdangnhapussername);
        dangnhapPassword = findViewById(R.id.dangnhap_password);
        textdangnhappass = findViewById(R.id.textdangnhappass);
        huyDangnhapDialog = findViewById(R.id.huy_dangnhap_dialog);
        dangnhapDialog = findViewById(R.id.dangnhap_dialog);

        huyDangnhapDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
//                DatePickerDialog datePickerDialog = new DatePickerDialog(Them.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        textdangnhappass.setText(dayOfMonth + "/" + month + "/" + year);
//                    }
//                },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
//
//
//
//                datePickerDialog.show();

                TimePickerDialog datePickerDialog = new TimePickerDialog(Them.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        textdangnhappass.setText(hourOfDay + ":" + minute );
                    }
                }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE),false);



                datePickerDialog.show();
            }
        });

        dangnhapDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(dangnhapUsername.getEditText().length() == 0) {

                    dangnhapUsername.setError("Nhập nội dung");
                } else {
                    dangnhapUsername.setError("");
                }

                if(dangnhapPassword.getEditText().length() == 0) {

                    dangnhapPassword.setError("Chọn thời gian");
                } else {
                    dangnhapPassword.setError("");
                }

                if(dangnhapUsername.getError() == null && dangnhapPassword.getError() == null){

                    MySQLite mySQLite = new MySQLite(Them.this);
                    My_Time my_time = new My_Time(textdangnhapussername.getText().toString(), textdangnhappass.getText().toString());
                    mySQLite.add_time(my_time);
                    Intent intent = new Intent(Them.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
