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

public class Main4Activity extends AppCompatActivity {
    EditText edtID;
    EditText edtTen;
    EditText edtNoiSinh;
    EditText edtNgaySinh;
    EditText edtLop;
    ListView lvList;
    List<SinhVien> lstSinhVien;
    int index = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        edtID = findViewById(R.id.edtID);
        edtTen = findViewById(R.id.edtTen);
        edtNoiSinh = findViewById(R.id.edtNoiSinh);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtLop = findViewById(R.id.edtLop);
        SinhVien sv1 = new SinhVien("PH10012","Nguyễn Văn Thành","Hà Nội","12/10/2001","PT15355");
        SinhVien sv2 = new SinhVien("PH10013","Nguyễn Văn Hùng","Hà Nội","12/10/2001","PT15355");
        SinhVien sv3 = new SinhVien("PH10014","Nguyễn Văn Nam","Hà Nội","12/10/2001","PT15355");
        lstSinhVien = new ArrayList<>();
        lstSinhVien.add(sv1);
        lstSinhVien.add(sv2);
        lstSinhVien.add(sv3);
        lvList = findViewById(R.id.lvSinhVien);
      SVSQLite svsqLite = new SVSQLite(Main4Activity.this);

        for (SinhVien x : lstSinhVien){
            svsqLite.themSV(x);
        }

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtID.setText(lstSinhVien.get(position).idSV);
                edtTen.setText(lstSinhVien.get(position).tenSV);
                edtNoiSinh.setText(lstSinhVien.get(position).noiSinh);
                edtNgaySinh.setText(lstSinhVien.get(position).ngaySinh);
                edtLop.setText(lstSinhVien.get(position).idLop);
                index = position;

//                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
//                intent.putExtra("key_1",String.valueOf(index));
//                startActivity(intent);
            }
        });
        loadList();


    }

    public void  add(View v){
        int count = 0;
        SinhVien sv = new SinhVien(edtID.getText().toString(),edtTen.getText().toString(),edtNoiSinh.getText().toString(),
                edtNgaySinh.getText().toString(),edtLop.getText().toString());
        for(SinhVien x : lstSinhVien){
            if(x.getIdSV().matches(sv.idSV)){
                Toast.makeText(getApplicationContext(),"ID Đã Tồn Tại",Toast.LENGTH_LONG).show();
                count++;
                break;
            }
        }
        if(count == 0) {
            SVSQLite svsqLite = new SVSQLite(Main4Activity.this);
            svsqLite.themSV(sv);
            Toast.makeText(getApplicationContext(), "Them Thanh Cong", Toast.LENGTH_LONG).show();
            loadList();
        }



    }

    public void loadList(){
        SVSQLite svsqLite = new SVSQLite(Main4Activity.this);
        lstSinhVien = svsqLite.getListAll();
      //  SinhVienAdapter sinhVienAdapter = new SinhVienAdapter(lstSinhVien);
        SVAdapter svAdapter = new SVAdapter(lstSinhVien);
        lvList.setAdapter(svAdapter);
    }


    public void updata(View v){

        SinhVien sv = lstSinhVien.get(index);
        sv.setIdSV(edtID.getText().toString());
        sv.setTenSV(edtTen.getText().toString());
        sv.setNoiSinh(edtNoiSinh.getText().toString());
        sv.setNgaySinh(edtNgaySinh.getText().toString());
        sv.setIdLop(edtLop.getText().toString());
        SVSQLite svsqLite = new SVSQLite(Main4Activity.this);
        svsqLite.update(sv);
        loadList();

    }

    public void delete(View view){
        SinhVien sv = lstSinhVien.get(index);
        SVSQLite svsqLite = new SVSQLite(Main4Activity.this);
        svsqLite.delete(sv.getIdSV());
        loadList();
    }
}
