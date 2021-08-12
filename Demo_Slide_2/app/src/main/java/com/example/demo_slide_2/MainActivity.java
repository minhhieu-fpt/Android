package com.example.demo_slide_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText edtA;
    EditText edtB;

    EditText edtKQ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtKQ = findViewById(R.id.tvKQ);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);

    }

    public void cong (View v) {

        String a = edtA.getText().toString();
        String b = edtB.getText().toString();

        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);

        int kq = numA + numB;

        edtKQ.setText(String.valueOf(kq));

//        Intent i = new Intent(MainActivity.this,DemoActivity.class);
//        startActivity(i);
    }

    public void tru (View v) {
        String a = edtA.getText().toString();
        String b = edtB.getText().toString();

        int numberA = Integer.parseInt(a);
        int numberB = Integer.parseInt(b);

        int kq = numberA - numberB;
        edtKQ.setText(String.valueOf(kq));

    }

    public void nhan (View v) {
        String a = edtA.getText().toString();
        String b = edtB.getText().toString();

        int numberA = Integer.parseInt(a);
        int numberB = Integer.parseInt(b);

        int kq = numberA * numberB;
        edtKQ.setText(String.valueOf(kq));
    }

    //cho phep neo
    public void chia (View v) {
        String a = edtA.getText().toString();
        String b = edtB.getText().toString();

        int numberA = Integer.parseInt(a);
        int numberB = Integer.parseInt(b);

        int kq = numberA / numberB;
        edtKQ.setText(String.valueOf(kq));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "onStop");
    }
}
