package com.example.lab_3_tkgda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Activity_Bai_4 extends AppCompatActivity {
    ListView listView;
    List<Listb4> listb4s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bai_4);
        listView = findViewById(R.id.lvb4);
        listb4s = new ArrayList<>();

        Listb4 listb4 = new Listb4();
        listb4.setImg(R.drawable.kimheesun);
        listb4.setMame("Kim Hee Sun");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimnamjoo);
        listb4.setMame("Kim Nam Joo");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimsoeun);
        listb4.setMame("Kim So Eun");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimtaehee);
        listb4.setMame("Kim Tae Hee");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimchi);
        listb4.setMame("Kim Chi");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimbap);
        listb4.setMame("Kim Bap");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimheesun);
        listb4.setMame("Kim Hee Sun");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimnamjoo);
        listb4.setMame("Kim Nam Joo");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimsoeun);
        listb4.setMame("Kim So Eun");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimtaehee);
        listb4.setMame("Kim Tae Hee");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimchi);
        listb4.setMame("Kim Chi");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimbap);
        listb4.setMame("Kim Bap");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimheesun);
        listb4.setMame("Kim Hee Sun");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimnamjoo);
        listb4.setMame("Kim Nam Joo");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimsoeun);
        listb4.setMame("Kim So Eun");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimtaehee);
        listb4.setMame("Kim Tae Hee");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimchi);
        listb4.setMame("Kim Chi");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimbap);
        listb4.setMame("Kim Bap");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimheesun);
        listb4.setMame("Kim Hee Sun");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimnamjoo);
        listb4.setMame("Kim Nam Joo");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimsoeun);
        listb4.setMame("Kim So Eun");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimtaehee);
        listb4.setMame("Kim Tae Hee");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimchi);
        listb4.setMame("Kim Chi");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimbap);
        listb4.setMame("Kim Bap");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimheesun);
        listb4.setMame("Kim Hee Sun");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimnamjoo);
        listb4.setMame("Kim Nam Joo");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimsoeun);
        listb4.setMame("Kim So Eun");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimtaehee);
        listb4.setMame("Kim Tae Hee");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimchi);
        listb4.setMame("Kim Chi");
        listb4s.add(listb4);

        listb4 = new Listb4();
        listb4.setImg(R.drawable.kimbap);
        listb4.setMame("Kim Bap");
        listb4s.add(listb4);


        Bai_4_Adapter bai_4_adapter = new Bai_4_Adapter(listb4s);
        listView.setAdapter(bai_4_adapter);
    }
}
