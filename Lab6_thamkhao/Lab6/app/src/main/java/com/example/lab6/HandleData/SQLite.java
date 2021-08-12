package com.example.lab6.HandleData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.lab6.Student;
import com.example.lab6.View.MainActivity;

import java.util.ArrayList;

public class SQLite extends SQLiteOpenHelper{

    public Context context;

    public SQLite(@Nullable Context context) {
        super(context, "QLSinhVien", null, 1);
        this.context =context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Students(id nvarchar(20) primary key," +
                "ten nvarchar(50), lop nvarchar(50), noiSinh nvarchar(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStudent(Student student){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", student.id);
        contentValues.put("ten", student.ten);
        contentValues.put("lop", student.lop);
        contentValues.put("noiSinh", student.noiSinh);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("Students", "",contentValues);
    }


    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> listStudents = new ArrayList<Student>();
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Students", null);
        while(cursor.moveToNext()){
            Student student = new Student();
            student.id = cursor.getString(0);
            student.ten = cursor.getString(1);
            student.lop = cursor.getString(2);
            student.noiSinh = cursor.getString(3);
            listStudents.add(student);
        }
        return listStudents;
    }


    public void delete(String id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("Students","id = ?",new String[]{id});
        ((MainActivity) context).reloadData();
    }

    public void upDate(Student student) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put("id", student.id);
        contentValues.put("ten", student.ten);
        contentValues.put("lop", student.lop);
        contentValues.put("noiSinh", student.noiSinh);
        sqLiteDatabase.update("Students", contentValues, "id = ?", new String[]{student.id});
    }
}
