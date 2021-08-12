package com.example.asaimen_demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    EditText edtID;
    EditText edtTenLop;
    ListView lvList;
    List<Lop> lopList;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edtID = findViewById(R.id.edtID);
        edtTenLop = findViewById(R.id.edtTenlop);
        Lop lop1 = new Lop("MOB101", "MOB15355");
        Lop lop2 = new Lop("MOB102", "MOB15356");
        Lop lop3 = new Lop("MOB103", "MOB15357");
        lopList = new ArrayList<>();
        lopList.add(lop1);
        lopList.add(lop2);
        lopList.add(lop3);
        lvList = findViewById(R.id.lvListSinhVien);
        MySQLite mySQLite = new MySQLite(Main2Activity.this);
        for (Lop x : lopList) {
            mySQLite.themLop(x);
        }
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtID.setText(lopList.get(position).Idlop);
                edtTenLop.setText(lopList.get(position).TenLop);
                index = position;

            }
        });
        loadList();
    }

    public void loadList() {
        MySQLite mySQLite = new MySQLite(Main2Activity.this);
        lopList = mySQLite.getListLopAll();
        SinhVienAdapter sinhVienAdapter = new SinhVienAdapter(lopList);
        lvList.setAdapter(sinhVienAdapter);
    }

    public void add(View v) {
        int count = 0;
        Lop lp = new Lop(edtID.getText().toString(), edtTenLop.getText().toString());

        for (Lop x : lopList) {
            if (x.getIdlop().matches(lp.Idlop)) {
                Toast.makeText(getApplicationContext(), "ID Đã Tồn Tại", Toast.LENGTH_LONG).show();
                count++;
                break;
            }
        }
        if (count == 0) {
            MySQLite mySQLite = new MySQLite(Main2Activity.this);
            mySQLite.themLop(lp);
            Toast.makeText(getApplicationContext(), "Them Thanh Cong", Toast.LENGTH_LONG).show();
            loadList();
        }


    }
    public void updata(View view){

        Lop lop = lopList.get(index);
        lop.setIdlop(edtID.getText().toString());
        lop.setTenLop(edtTenLop.getText().toString());
        MySQLite mySQLite = new MySQLite(Main2Activity.this);
        mySQLite.suaLop(lop);
        loadList();
    }
    public void delete (View view){
        Lop lop = lopList.get(index);
        MySQLite mySQLite = new MySQLite(Main2Activity.this);
        mySQLite.xoaLop(lop.getIdlop());
        loadList();
    }
}
