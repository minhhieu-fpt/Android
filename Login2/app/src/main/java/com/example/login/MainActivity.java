package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button button;
    List<User> userList;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv_list);
        button = findViewById(R.id.btn_add);
        userList = new ArrayList<>();
        SQLite_User sqLite_user = new SQLite_User(this);
        User user = new User("Hiếu", "123456789");
        sqLite_user.them(user);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dang_Ky_TK.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                a = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Bạn muốn làm cái đéo gì?");
                builder.setIcon(R.drawable.tym);
                builder.setTitle("(▀̿Ĺ̯▀̿ ̿)");
                builder.setPositiveButton("Đăng Nhập", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, Dang_Ki.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("user", userList.get(a).getUser());
                        bundle.putString("pass", userList.get(a).getPassword());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SQLite_User sqLite_user1 = new SQLite_User(MainActivity.this);
                        sqLite_user1.xoa(userList.get(a).getUser());
                        loadlist();
                    }
                });
            builder.create();
            builder.show();
            }
        });
        loadlist();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadlist();
    }

    void loadlist (){

        SQLite_User sqLite_user = new SQLite_User(this);
        userList = sqLite_user.getListUser();
        User_Adapter user_adapter = new User_Adapter(userList);
        listView.setAdapter(user_adapter);
    }


}
