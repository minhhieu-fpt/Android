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

public class Sua_My_Time extends AppCompatActivity {

    TextInputLayout dangnhapUsernameSua;
    TextInputEditText textdangnhapussernameSua;
    TextInputLayout dangnhapPasswordSua;
    TextInputEditText textdangnhappassSua;
    Button huyDangnhapDialogThem;
    Button dangnhapDialogSua;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_sua);
        Intent intent = getIntent();


        dangnhapUsernameSua = findViewById(R.id.dangnhap_username_sua);
        textdangnhapussernameSua = findViewById(R.id.textdangnhapussername_sua);
        dangnhapPasswordSua = findViewById(R.id.dangnhap_password_sua);
        textdangnhappassSua = findViewById(R.id.textdangnhappass_sua);
        huyDangnhapDialogThem = findViewById(R.id.huy_dangnhap_dialog_them);
        dangnhapDialogSua = findViewById(R.id.dangnhap_dialog_sua);

        textdangnhapussernameSua.setText(intent.getStringExtra("noid"));
        textdangnhappassSua.setText(intent.getStringExtra("timee"));

        dangnhapDialogSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dangnhapUsernameSua.getEditText().length() == 0) {

                    dangnhapUsernameSua.setError("Nhập nội dung");
                } else {
                    dangnhapUsernameSua.setError("");
                }

                if(dangnhapPasswordSua.getEditText().length() == 0) {

                    dangnhapPasswordSua.setError("Chọn thời gian");
                } else {
                    dangnhapPasswordSua.setError("");
                }

                if(dangnhapUsernameSua.getError() == null && dangnhapPasswordSua.getError() == null){

                    MySQLite mySQLite = new MySQLite(Sua_My_Time.this);
                    My_Time my_time = new My_Time(textdangnhapussernameSua.getText().toString(), textdangnhappassSua.getText().toString());
                    mySQLite.edit_time(my_time);

                    Intent intent = new Intent(Sua_My_Time.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });

        huyDangnhapDialogThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                TimePickerDialog datePickerDialog = new TimePickerDialog(Sua_My_Time.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        textdangnhappassSua.setText(hourOfDay + ":" + minute );
                    }
                }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE),false);



                datePickerDialog.show();



            }
        });

    }
}
