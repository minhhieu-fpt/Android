package com.example.asaimen_demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {
    EditText edtTen;
    EditText ngaySinh;
    EditText edtID;
    ListView lvList;
    List<SinhVien> svList;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        edtTen =findViewById(R.id.editTenSV);
        edtID =findViewById(R.id.editLop);
        ngaySinh=findViewById(R.id.editNgaySinh);
        try {
        SinhVien sv1 = new SinhVien("Tran Dinh Phu","10-2-1001","MOB101");
        SinhVien sv2 = new SinhVien("Le Van Nam","6-7-1001","MOB102");
        SinhVien sv3 = new SinhVien("Ngyen thi Trang","22-9-1001","MOB103");
        svList = new ArrayList<>();
          svList.add(sv1);
        svList.add(sv2);
        svList.add(sv3);
        lvList = findViewById(R.id.lvListThemSV);
        MySQLite mySQLite = new MySQLite(Main4Activity.this);
        for (SinhVien x : svList) {
            mySQLite.themSV(x);
        }
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtTen.setText(svList.get(position).TenSV);
                ngaySinh.setText(svList.get(position).getNgaySinh());
                index = position;
            }
        });

            loadList();
            System.out.println("Ham dang chay voa load");
        }catch (Exception e){
            System.out.println("Ham Khong chay voa load===================================================================");
        }

    }

    public void loadList() {
        MySQLite mySQLite = new MySQLite(Main4Activity.this);
        svList = mySQLite.getListSVAll();
       SVAdapter svAdapter = new SVAdapter(svList);
        lvList.setAdapter(svAdapter);
    }
    public void add(View v) {
        int count = 0;

        SinhVien sv = new SinhVien(edtTen.getText().toString(),ngaySinh.getText().toString(),edtID.getText().toString());

        for (SinhVien x : svList) {
            if (x.getIdlop().matches(sv.TenSV)) {
                Toast.makeText(getApplicationContext(), "ID Đã Tồn Tại", Toast.LENGTH_LONG).show();
                count++;
                break;
            }
        }
        if (count == 0) {
            MySQLite mySQLite = new MySQLite(Main4Activity.this);
            mySQLite.themSV(sv);
            Toast.makeText(getApplicationContext(), "Them Thanh Cong", Toast.LENGTH_LONG).show();
           loadList();
        }


    }
}
