package com.example.asm.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.asm.Adapter.Class_Adapter;
import com.example.asm.Model.Class;
import com.example.asm.R;
import com.example.asm.SQLite.SQLite;

import java.util.ArrayList;
import java.util.List;

public class Xem_Danh_Dach_Lop extends AppCompatActivity {
    List<Class> classList;
    ListView listView;
    AlertDialog.Builder builder;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem__danh__dach__lop);
        listView = findViewById(R.id.lv_class);
        Class aClass = new Class("MOB1013", "MOB15355");
        Class aClass1 = new Class("MOB12323", "MOB23402349204");
        classList = new ArrayList<>();
        classList.add(aClass);
        classList.add(aClass1);
        builder = new AlertDialog.Builder(Xem_Danh_Dach_Lop.this);
        final SQLite sqLite = new SQLite(Xem_Danh_Dach_Lop.this);
        for (Class x : classList) {
            sqLite.add_lop(x);
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                a = position;

                builder.setMessage("Bạn có muốn xóa không?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sqLite.delete_lop(classList.get(a).getMaLop());
                        loadList();
                    }
                });


                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.create();
            builder.show();
            }
        });
        loadList();


    }

    void loadList (){
        SQLite sqLite = new SQLite(Xem_Danh_Dach_Lop.this);
        classList = sqLite.getListLop();
        Class_Adapter class_adapter = new Class_Adapter(classList);
        listView.setAdapter(class_adapter);

    }
}
