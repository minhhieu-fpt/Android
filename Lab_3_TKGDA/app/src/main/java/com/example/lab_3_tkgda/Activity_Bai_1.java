package com.example.lab_3_tkgda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Activity_Bai_1 extends AppCompatActivity {
    ListView listView;
    List<HashMap<String, Object>> ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bai_1);

        listView = findViewById(R.id.listb1);

        ds = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("Ten", "Hancock");
        hm.put("Hinh", R.drawable.hancock);
        hm.put("Tuoi", "18");
        ds.add(hm);

        hm = new HashMap<>();
        hm.put("Ten", "Shank");
        hm.put("Hinh", R.drawable.shank);
        hm.put("Tuoi", "35");
        ds.add(hm);

        String[] from = {"Ten", "Tuoi", "Hinh"};
        int[] to = {R.id.text1, R.id.text2, R.id.image};

        SimpleAdapter simpleAdapter = new SimpleAdapter(Activity_Bai_1.this,ds,R.layout.row,from,to);

        listView.setAdapter(simpleAdapter);
    }
}
