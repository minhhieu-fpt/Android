package com.example.demo_slide_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button sCache, lCache, sInternal, lInternal, sExternal, lExternal, sSharepref, lSharepref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edt_name);

    }

    public void saveCache(View v) throws IOException {
        File file = new File(getCacheDir(),"abc.cache");
        file.createNewFile();
        String data = name.getText().toString();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(data.getBytes());
        fileOutputStream.close();


    }
    public void loadCache(View v) throws IOException {
        File path = getCacheDir();
        String fileName = "abc.cache";
        File file = new File(path,fileName);

        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);
        String data = "";
        while (scanner.hasNext()){
            data += scanner.nextLine();
        }
        name.setText(data);
        scanner.close();
        fileInputStream.close();


    }

    public void saveInternal(View v) throws IOException {
        String data = name.getText().toString();
        FileOutputStream fileOutputStream = openFileOutput("data.cache",MODE_PRIVATE);
        fileOutputStream.write(data.getBytes());
        fileOutputStream.close();
    }
    public void loadInternal(View v) throws IOException {
        FileInputStream fileInputStream = openFileInput("data.cache");
        Scanner scanner = new Scanner(fileInputStream);
        String data = "";
        while (scanner.hasNext()){
            data += scanner.nextLine();
        }
        name.setText(data);
        scanner.close();
        fileInputStream.close();
    }
    public void saveExternal(View v) throws IOException {
        String path = getExternalFilesDir(null).getAbsolutePath() + "/file.txt";
        File file = new File(path);
        file.createNewFile();

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
        outputStreamWriter.write(name.getText().toString());
        outputStreamWriter.close();
    }
    public void loadExternal(View v) throws IOException {
        String path = getExternalFilesDir(null).getAbsolutePath() + "/file.txt";
        File file = new File(path);


        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        String data = "";
        Scanner scanner = new Scanner(inputStreamReader);
        while(scanner.hasNext()){
            data += scanner.nextLine();
        }
        scanner.close();
        inputStreamReader.close();
        name.setText(data);


    }

    public void saveSharepref(View v){
        SharedPreferences sharedPreferences = getSharedPreferences("file.ref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String data = name.getText().toString();

        editor.putString("name",data);
        editor.commit();

    }
    public void loadSharepref(View v){
        SharedPreferences sharedPreferences = getSharedPreferences("file.ref",MODE_PRIVATE);
        String namer = sharedPreferences.getString("name",null);
        int tuoi = sharedPreferences.getInt("tuoi",-1);
        if(name != null){
            name.setText(namer);
        }
    }


}
