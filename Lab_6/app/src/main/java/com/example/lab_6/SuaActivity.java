package com.example.lab_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SuaActivity extends AppCompatActivity {

    EditText edt_name, edt_price;
    private MySQL mySQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);
        edt_name = findViewById(R.id.edt_name);
        edt_price = findViewById(R.id.edt_price);


    }

    public void update(View view) {

        Product product = new Product();
        product.setTenSP(edt_name.getText().toString());
        product.setPrice(edt_price.getText().toString());

        mySQL.update(product);

    }
}
