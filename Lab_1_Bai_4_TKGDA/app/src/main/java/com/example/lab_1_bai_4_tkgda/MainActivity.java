package com.example.lab_1_bai_4_tkgda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView v1,v2,v3,v4,v5,v6,v7,v8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v1 = findViewById(R.id.imageView3);
        v2 = findViewById(R.id.imageView4);
        v3 = findViewById(R.id.imageView5);
        v4 = findViewById(R.id.imageView6);
        v5 = findViewById(R.id.imageView7);
        v6 = findViewById(R.id.imageView8);
        v7 = findViewById(R.id.imageView9);
        v8 = findViewById(R.id.imageView10);




        Thread thread = new Thread(){
            @Override
            public void run() {
                v1.setImageResource(R.drawable.anh3);
                v2.setImageResource(R.drawable.anh3);
                v3.setImageResource(R.drawable.anh3);
                v4.setImageResource(R.drawable.anh3);
                v5.setImageResource(R.drawable.anh3);
                v6.setImageResource(R.drawable.anh3);
                v7.setImageResource(R.drawable.anh3);
                v8.setImageResource(R.drawable.anh3);
            }
        };

        thread.start();

    }
}
