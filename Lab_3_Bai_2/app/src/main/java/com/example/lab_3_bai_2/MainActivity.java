package com.example.lab_3_bai_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText so_a;
    EditText so_b;
    EditText so_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        so_a = findViewById(R.id.edt_sht1);
        so_b = findViewById(R.id.edt_sht2);
        so_c = findViewById(R.id.edt_sht3);
    }



    public void tinh (View v){
        String a = so_a.getText().toString();
        String b = so_b.getText().toString();
        String c = so_c.getText().toString();

        double s_a = Double.parseDouble(a);
        double s_b = Double.parseDouble(b);
        double s_c = Double.parseDouble(c);

        double delta = Math.pow(s_b , 2) - (4 * s_a * s_c);

        if(delta < 0 ){

            String kq = "Phương trình vô nghiệm";
            Intent i = new Intent(MainActivity.this, Activity_ManHinhKQ_Bai_2.class);
            i.putExtra("key_1",String.valueOf(kq));
            startActivity(i);

        } else if (delta == 0) {

            double kq = - s_b / (2 * s_a);
            Intent i = new Intent(MainActivity.this, Activity_ManHinhKQ_Bai_2.class);
            i.putExtra("key_1",String.valueOf(kq));
            startActivity(i);

        } else if (delta > 0){
            double x1 = (-s_b - Math.sqrt(delta)) / (2 * s_a);

            Intent i = new Intent(MainActivity.this, Activity_ManHinhKQ_Bai_2.class);
            i.putExtra("key_1",String.valueOf(x1));
            startActivity(i);

            double x2 = (-s_b + Math.sqrt(delta)) / (2 * s_a);

            Intent j = new Intent(MainActivity.this, Activity_ManHinhKQ_Bai_2.class);
            j.putExtra("key_2",String.valueOf(x2));
            startActivity(j);
        }
    }
}
