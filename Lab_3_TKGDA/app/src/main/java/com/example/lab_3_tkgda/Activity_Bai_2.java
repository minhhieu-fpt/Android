package com.example.lab_3_tkgda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Activity_Bai_2 extends AppCompatActivity {

    AppCompatSpinner spinner;
    List<Spinnerr> spinnerrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bai_2);

        spinnerrList = new ArrayList<>();

        spinner = findViewById(R.id.sp_list);

        Spinnerr spinnerr = new Spinnerr();
        spinnerr.setImg(R.drawable.vn);
        spinnerr.setTen("Việt Nam");
        spinnerrList.add(spinnerr);

        spinnerr = new Spinnerr();
        spinnerr.setImg(R.drawable.facebookkk);
        spinnerr.setTen("Lào");
        spinnerrList.add(spinnerr);


        spinnerr = new Spinnerr();
        spinnerr.setImg(R.drawable.my);
        spinnerr.setTen("Mỹ");
        spinnerrList.add(spinnerr);

        spinnerr = new Spinnerr();
        spinnerr.setImg(R.drawable.uc);
        spinnerr.setTen("Úc");
        spinnerrList.add(spinnerr);

        spinnerr = new Spinnerr();
        spinnerr.setImg(R.drawable.indonesia);
        spinnerr.setTen("Indonesia");
        spinnerrList.add(spinnerr);

        spinnerr = new Spinnerr();
        spinnerr.setImg(R.drawable.china);
        spinnerr.setTen("China");
        spinnerrList.add(spinnerr);

        Spinner_Adapter spinner_adapter = new Spinner_Adapter(spinnerrList);
        spinner.setAdapter(spinner_adapter);

    }
}
