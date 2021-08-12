package com.example.lab_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    MySQL mySQL;
    EditText edt_id, edt_name, edt_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edt_id = findViewById(R.id.edt_id);
        edt_name = findViewById(R.id.edt_name);
        edt_price = findViewById(R.id.edt_price);
    }

    public void insert(View view) {
        Product product = new Product();
        product.setID(edt_id.getText().toString());
        product.setTenSP(edt_name.getText().toString());
        product.setPrice(edt_price.getText().toString());

        long kq = mySQL.insert(product);
        Toast.makeText(this, "Thêm thành công.", Toast.LENGTH_SHORT).show();
        MainActivity mainActivity = new MainActivity();
        mainActivity.loadlist();

        if(kq > 0 ){

            Toast.makeText(this, "Thêm thành công.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Thêm thất bại.", Toast.LENGTH_SHORT).show();
        }
    }
}
