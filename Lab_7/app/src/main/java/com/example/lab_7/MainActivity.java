package com.example.lab_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtUser, edtPass;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edt_name);
        edtUser = findViewById(R.id.edt_user);
        edtPass = findViewById(R.id.edt_pass);
        checkBox = findViewById(R.id.checkbox_nho);
    }

    public void saveInternal (View v) throws IOException {

        String a = edtName.getText().toString();
        FileOutputStream fileOutputStream = openFileOutput("dataInternal.txt", MODE_PRIVATE);
        fileOutputStream.write(a.getBytes());
        fileOutputStream.close();
    }

    public void loadInternal (View v) throws IOException {

        FileInputStream fileInputStream = openFileInput("dataInternal.txt");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        String data = "";
        while (fileInputStream.available() > 0){
            data = dataInputStream.readLine();

        }
        edtName.setText(data);
        dataInputStream.close();
        fileInputStream.close();
    }

    public void saveExternal (View v) throws IOException {

        File file = new File(getExternalFilesDir(null).getAbsolutePath() + "/file.txt");
        file.createNewFile();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
        outputStreamWriter.write(edtName.getText().toString());
        outputStreamWriter.close();
    }

    public void loadExternal (View v) throws IOException {
        File file = new File(getExternalFilesDir(null).getAbsolutePath() + "/file.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        String data = "";
        Scanner scanner = new Scanner(inputStreamReader);
        while(scanner.hasNext()){

            data += scanner.nextLine();
        }
        edtName.setText(data);
        scanner.close();

//        while(fileInputStream.available() > 0){
//                data += inputStreamReader.read();
//
//        }
//        edtName.setText(data);
        inputStreamReader.close();



    }

    @Override
    protected void onResume() {
        super.onResume();
        loadSha();
    }

    private void loadSha() {

        SharedPreferences sharedPreferences = getSharedPreferences("file.ref", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", null);
        String pass = sharedPreferences.getString("password", null);
        if(name != null){

            edtUser.setText(name);
            edtPass.setText(pass);

        }
    }

    public void saveSharepref (View v){

        if(checkBox.isChecked()){

            SharedPreferences sharedPreferences = getSharedPreferences("file.ref",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("name", edtUser.getText().toString());
            editor.putString("password",edtPass.getText().toString());
            editor.commit();
        }

        Intent intent = new Intent(MainActivity.this, ThongTinDangNhap.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", edtUser.getText().toString());
        bundle.putString("password",edtPass.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void loadSha (View v){

        SharedPreferences sharedPreferences = getSharedPreferences("file.ref", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", null);
        String pass = sharedPreferences.getString("password", null);
        if(name != null){

            edtUser.setText(name);
            edtPass.setText(pass);

        }
    }

}
