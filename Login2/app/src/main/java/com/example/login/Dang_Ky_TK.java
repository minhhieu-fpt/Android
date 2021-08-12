package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dang_Ky_TK extends AppCompatActivity {
    EditText edt_user_dk, edt_pass_dk, edt_passl_dk;
    Button btn_dk;
    List<User> userList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang__ky__t_k);
        edt_user_dk = findViewById(R.id.edt_user_dk);
        edt_pass_dk = findViewById(R.id.edt_pass_dk);
        edt_passl_dk = findViewById(R.id.edt_passl_dk);
        btn_dk = findViewById(R.id.btn_dk);
        listView = findViewById(R.id.lv_list);
        userList = new ArrayList<>();
        final SQLite_User sqLite_user = new SQLite_User(Dang_Ky_TK.this);
        userList = sqLite_user.getListUser();

        btn_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(!edt_pass_dk.getText().toString().matches(edt_passl_dk.getText().toString())){
                    Toast.makeText(Dang_Ky_TK.this, "Mật khẩu không khớp.", Toast.LENGTH_LONG).show();
                    return;
                } else if(sqLite_user.getindex(edt_user_dk.getText().toString()) != -1){

                    Toast.makeText(Dang_Ky_TK.this, "Tài khoản đã tồn tại.", Toast.LENGTH_LONG).show();
                    return;
                }

                User user = new User(edt_user_dk.getText().toString(), edt_pass_dk.getText().toString());
                SQLite_User sqLite_user = new SQLite_User(Dang_Ky_TK.this);
                sqLite_user.them(user);
                Toast.makeText(Dang_Ky_TK.this, "Thành Công.", Toast.LENGTH_LONG).show();

            }
        });
    }

}
