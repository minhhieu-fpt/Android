package com.example.lab_5_tkgda;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Layout2 extends AppCompatActivity {
    TextView textView;
    int tuoii = 18;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);


//        String[] tuoi = {"16", "17", "18", "19"};
//
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Layout2.this);
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        alertDialog.setTitle(bundle.getString("cauhoi"));
//        alertDialog.setSingleChoiceItems(tuoi, 2, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if(which == 0){
//                    tuoii = 16;
//                } else if (which == 1){
//                    tuoii = 17;
//                } else if(which == 2) {
//
//                    tuoii = 18;
//                } else if (which == 3){
//                    tuoii = 19;
//                }
//            }
//
//
//        });
//        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            Intent intent1 = new Intent(Layout2.this, AdapterCauHoi.class);
//            intent1.putExtra("kq", "Bạn đã chọn: " + tuoii);
//            startActivity(intent1);
//
//
//            }
//        });
//
//        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//
//        alertDialog.show();

        finish();
    }
}
