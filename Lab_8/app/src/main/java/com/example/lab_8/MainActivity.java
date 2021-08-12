package com.example.lab_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button , button2;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id .editText);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        webView = findViewById(R.id.webView);


        webView.setWebViewClient(new MyBr());


    }

    String duLieu;
    public void load (View view) {
        String link = editText.getText().toString();
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
    }

    public void seen (View view) {

        AsyncTask asyncTask = new AsyncTask(){
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    String links = editText.getText().toString();
                    URL url = new URL(links);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream  inputStream = httpURLConnection.getInputStream();
                    Scanner scanner = new Scanner(inputStream);

                    String data = "";
                    while (scanner.hasNext()){

                        data += scanner.nextLine();

                    }
                    scanner.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    duLieu = data;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
//                Toast.makeText(MainActivity.this, duLieu, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("key", duLieu);
                startActivity(intent);
            }
        };

        asyncTask.execute();
    }
}
