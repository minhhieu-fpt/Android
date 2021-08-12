package com.example.lab_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv_produc;
    List<Product> productList;
    MySQL mySQL = new MySQL(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_produc = findViewById(R.id.lvlist);
        productList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Product product = new Product("1" + i, "Điện thoại " + i, "1" + i);

            productList.add(product);
            mySQL.insert(product);

        }

        productList = mySQL.getProductList();
        ProductAdapter productAdapter = new ProductAdapter(productList);
        lv_produc.setAdapter(productAdapter);



    }

    public void update(View view) {

        Intent intent = new Intent(MainActivity.this, SuaActivity.class);
        startActivity(intent);

    }

    void loadlist(){
        MySQL mySQL = new MySQL(MainActivity.this);
        productList = mySQL.getProductList();
        ProductAdapter productAdapter = new ProductAdapter(productList);
        lv_produc.setAdapter(productAdapter);
    }

//    public void delete(View view) {
//
//        mySQL.delete(productList.get().getID());
//
//    }

    public void add(View view) {

        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }
}
