package com.example.lab5_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_product);
        products = new ArrayList<>();
        MySQL mySQL = new MySQL(MainActivity.this);

        for (int i = 0; i < 16 ; i++) {
            Product product = new Product();
            product.setName("Điện thoại" + new Random());
            product.setPrice("30000");
            products.add(product);
            mySQL.load(product);
        }
        ProductAdapter productAdapter = new ProductAdapter(MainActivity.this, products);

        List<Product> products = mySQL.getProductList();
        listView.setAdapter(productAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


}
