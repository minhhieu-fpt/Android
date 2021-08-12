package com.example.asm.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.asm.Adapter.Spinner_Adapter;
import com.example.asm.Adapter.Student_Adapter;
import com.example.asm.Model.Class;
import com.example.asm.Model.Student;
import com.example.asm.R;
import com.example.asm.SQLite.SQLite;

import java.util.ArrayList;
import java.util.List;

public class Quan_Ly_Sinh_Vien extends AppCompatActivity {
    EditText edt_tensv, edt_ngaysinh;
    Spinner spinner;
    List<Student> studentList;
    List<Class> classList;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan__ly__sinh__vien);
        edt_tensv = findViewById(R.id.edt_tensinhvien);
        edt_ngaysinh = findViewById(R.id.edt_ngaysinh);
        spinner = findViewById(R.id.sp_listlop);
        listView = findViewById(R.id.lv_qlsv);
        studentList = new ArrayList<>();
        classList = new ArrayList<>();
        Student student = new Student("Tạ Minh Hiếu", "01/08/2001",  "PT15355");
        studentList.add(student);
        SQLite sqLite = new SQLite(Quan_Ly_Sinh_Vien.this);
        for (Student studen : studentList) {
            sqLite.add_student(studen);

        }
        loadlist();
    }

    void loadlist (){

        SQLite sqLite = new SQLite(Quan_Ly_Sinh_Vien.this);
        studentList = sqLite.getListStudent();
        classList = sqLite.getListLop();
        Student_Adapter student_adapter = new Student_Adapter(studentList);
        Spinner_Adapter spinner_adapter = new Spinner_Adapter(classList);
        spinner.setAdapter(spinner_adapter);
        listView.setAdapter(student_adapter);

    }

    public void add(View view){

        String ten = edt_tensv.getText().toString();
        String ngaysinh = edt_ngaysinh.getText().toString();
        String id_lop = spinner.getSelectedItem().toString();


        Student student = new Student(ten,ngaysinh,id_lop);
        SQLite sqLite = new SQLite(Quan_Ly_Sinh_Vien.this);
        sqLite.add_student(student);
        loadlist();
    }
}
