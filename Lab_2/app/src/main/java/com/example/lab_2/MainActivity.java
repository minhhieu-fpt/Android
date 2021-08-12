package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.security.Key;

public class MainActivity extends AppCompatActivity {
    EditText edtA;
    EditText edtB;

    TextView tvKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG", "onCreate");

        tvKQ = findViewById(R.id.tvKQ);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG", "onRestart");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "onDestroy");
    }

    //Bai 2


    public void cong (View v) {

        String a = edtA.getText().toString();
        String b = edtB.getText().toString();

        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);

        int kq = numA + numB;

        tvKQ.setText(String.valueOf(kq));

        Intent i = new Intent(MainActivity.this, kq.class);
        i.putExtra("key_1", String.valueOf(kq));
        startActivity(i);
    }

    public void tru (View v) {
        String a = edtA.getText().toString();
        String b = edtB.getText().toString();

        int numberA = Integer.parseInt(a);
        int numberB = Integer.parseInt(b);

        int kq = numberA - numberB;
        tvKQ.setText(String.valueOf(kq));

        Intent i = new Intent(MainActivity.this, kq.class);
        i.putExtra("key_1", String.valueOf(kq));
        startActivity(i);
    }

    public void nhan (View v) {
        String a = edtA.getText().toString();
        String b = edtB.getText().toString();

        int numberA = Integer.parseInt(a);
        int numberB = Integer.parseInt(b);

        int kq = numberA * numberB;
        tvKQ.setText(String.valueOf(kq));

        Intent i = new Intent(MainActivity.this, kq.class);
        i.putExtra("key_1", String.valueOf(kq));
        startActivity(i);
    }

    public void chia (View v) {
        String a = edtA.getText().toString();
        String b = edtB.getText().toString();

        double numberA = Double.parseDouble(a);
        double numberB = Double.parseDouble(b);

        double kq = numberA / numberB;
        tvKQ.setText(String.valueOf(kq));

        Intent i = new Intent(MainActivity.this, kq.class);
        i.putExtra("key_1", String.valueOf(kq));
        startActivity(i);
    }
}
