package com.example.asm.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asm.Model.Class;
import com.example.asm.R;
import com.example.asm.SQLite.SQLite;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_add, btn_xemdsl, btn_qlsv;
    EditText edt_idlopEditText;
    EditText edt_tenlopp;
    SQLite sqLite;
    List<Class> classList;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_xemdsl = findViewById(R.id.btn_xemdsl);
        btn_qlsv = findViewById(R.id.qlsv);
        listView = findViewById(R.id.lv_class);
        sqLite = new SQLite(MainActivity.this);

    }

    AlertDialog alertDialog;
    public void add (View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view1 = LayoutInflater.from(this).inflate(R.layout.dialog_them, null);
        builder.setView(view1);

        edt_idlopEditText = view1.findViewById(R.id.edt_malop);
        edt_tenlopp = view1.findViewById(R.id.edt_tenlop);
        Button btn_xoatrang = view1.findViewById(R.id.btn_xoatrang);
        Button btn_themmoi = view1.findViewById(R.id.btn_luulop);

        btn_xoatrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edt_idlopEditText.setText(null);
                edt_tenlopp.setText(null);
            }
        });

        btn_themmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class aClass = new Class(edt_idlopEditText.getText().toString(),edt_tenlopp.getText().toString());
                sqLite.add_lop(aClass);
                Toast.makeText(MainActivity.this, "Thêm thành công.", Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
//                loadlist();
            }
        });
        builder.create();
        alertDialog = builder.show();
    }

//    void loadlist (){
//        classList = sqLite.getListLop();
//        Class_Adapter class_adapter = new Class_Adapter(classList);
//        listView.setAdapter(class_adapter);
//    }

    public void xemdsl (View view){
        Intent intent = new Intent(MainActivity.this, Xem_Danh_Dach_Lop.class);
        startActivity(intent);
    }

    public void qlsv(View view){
        Intent intent = new Intent(MainActivity.this, Quan_Ly_Sinh_Vien.class);
        startActivity(intent);
    }
}
