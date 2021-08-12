package com.example.lab_5_tkgda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
//    Button button;
    List<Cauhoi> cauhois;
//    List<HashMap<String, Object>> hashMapList;
//    HashMap<String, Object> hashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        cauhois = new ArrayList<>();

        Cauhoi cauhoi = new Cauhoi("Câu hỏi: Bạn bao nhiêu tuổi?", "");
        cauhois.add(cauhoi);

        Cauhoi  cauhoi2 = new Cauhoi("Câu hỏi: Ông bạn bao nhiêu tuổi?", "");
        cauhois.add(cauhoi2);

        cauhoi2 = new Cauhoi("Câu hỏi: Bà bạn bao nhiêu tuổi?", "");
        cauhois.add(cauhoi2);

        cauhoi2 = new Cauhoi("Câu hỏi: Bố bạn bao nhiêu tuổi?", "");
        cauhois.add(cauhoi2);

        cauhoi2 = new Cauhoi("Câu hỏi: Mẹ bạn bao nhiêu tuổi?", "");
        cauhois.add(cauhoi2);

        cauhoi2 = new Cauhoi("Câu hỏi: Anh bạn bao nhiêu tuổi?", "");
        cauhois.add(cauhoi2);

        cauhoi2 = new Cauhoi("Câu hỏi: Chị bạn bao nhiêu tuổi?", "");
        cauhois.add(cauhoi2);

        cauhoi2 = new Cauhoi("Câu hỏi: Em bạn bao nhiêu tuổi?", "");
        cauhois.add(cauhoi2);



//        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout1, null, false);
//        button = view.findViewById(R.id.btn_traloi);
//        hashMapList = new ArrayList<>();
//
//        hashMap = new HashMap();
//
//        hashMap.put("STT", "1");
//        hashMap.put("Cauhoi", "Bạn bao nhiêu tuổi?");
//        hashMap.put("Cautraloi", "");
//        hashMapList.add(hashMap);
//
//        String[] from = {"STT", "Cauhoi", "Cautraloi"};
//        int[] to = {R.id.stt, R.id.cauhoi, R.id.cautraloi};
//
//        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,hashMapList,R.layout.layout1,from, to);
//        listView.setAdapter(simpleAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.e ("vào", "vào");
//
//                button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                        View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout2, null, false);
//                        builder.setView(view1);
//                        builder.create();
//                        builder.show();
//
//                        Intent intent = new Intent(MainActivity.this, Layout2.class);
//
//
//
//
//                        Bundle bundle = new Bundle();
//                        bundle.putString("STT", (String) hashMap.get("STT"));
//                        bundle.putString("Cauhoi", (String) hashMap.get("Cauhoi"));
//                        bundle.putString("Cautraloi", (String) hashMap.get("Cautraloi"));
//                        intent.putExtras(bundle);
//                        startActivity(intent);
//
//                    }
//                });
//            }
//        });
//

        onResume();
    }

    @Override
    protected void onResume() {
        AdapterCauHoi adapterCauHoi = new AdapterCauHoi(cauhois,MainActivity.this);
        listView.setAdapter(adapterCauHoi);
        super.onResume();
    }


}
