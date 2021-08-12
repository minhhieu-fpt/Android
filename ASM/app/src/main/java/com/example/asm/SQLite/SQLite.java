package com.example.asm.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.asm.Model.Class;
import com.example.asm.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class SQLite extends SQLiteOpenHelper {
    public SQLite(@Nullable Context context) {
        super(context, "DataASM.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table LOP (ID_LOP TEXT primary key, TEN_LOP TEXT)");
        db.execSQL("create table SINH_VIEN (TEN_SV TEXT primary key, NGAY_SINH TEXT, ID_LOP TEXT, constraint SV_LOP foreign key (ID_LOP) references LOP (ID_LOP))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    SQLiteDatabase sqLiteDatabase = getWritableDatabase();
    SQLiteDatabase sqLiteDatabaseRead = getReadableDatabase();

    public void add_lop (Class aClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_LOP", aClass.getMaLop());
        contentValues.put("TEN_LOP", aClass.getTenLop());
        sqLiteDatabase.insert("LOP",null, contentValues);

    }

    public void edit_lop (Class aClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_LOP", aClass.getMaLop());
        contentValues.put("TEN_LOP", aClass.getTenLop());
        sqLiteDatabase.update("LOP", contentValues, "ID_LOP = ?", new String[] {aClass.getMaLop()});
    }

    public void delete_lop(String malop){

        sqLiteDatabase.delete("LOP", "ID_LOP = ?", new String[] {malop});
    }

    public List<Class> getListLop(){
        List<Class> list_class = new ArrayList<>();

        Cursor cursor = sqLiteDatabaseRead.rawQuery("Select * From LOP", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            String idLop = cursor.getString(0);
            String tenLop = cursor.getString(1);
            Class aClass = new Class(idLop,tenLop);
            list_class.add(aClass);
            cursor.moveToNext();
        }
        cursor.close();
        return list_class;
    }

    public void add_student(Student student){
        ContentValues contentValues = new ContentValues();
        contentValues.put("TEN_SV", student.getTenSinhVien());
        contentValues.put("NGAY_SINH", student.getNgaySinh());
        contentValues.put("ID_LOP", student.getId_lop());
        sqLiteDatabase.insert("SINH_VIEN", null,contentValues);
    }

    public void edit_studen (Student student){
        ContentValues contentValues = new ContentValues();
        contentValues.put("TEN_SV", student.getTenSinhVien());
        contentValues.put("NGAY_SINH", student.getNgaySinh());
        contentValues.put("ID_LOP", student.getId_lop());
        sqLiteDatabase.update("SINH_VIEN", contentValues, "TEN_SV = ?", new String[] {student.getTenSinhVien()});
    }

    public void delete_sinhvien(String tensinhvien){
        sqLiteDatabase.delete("SINH_VIEN", "TEN_SV = ?", new String[]{tensinhvien});

    }


    public List<Student> getListStudent(){
        List<Student> listStudent = new ArrayList<>();
        Cursor cursor = sqLiteDatabaseRead.rawQuery("Select * From SINH_VIEN", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){

            String tenSV = cursor.getString(0);
            String ngaySinh = cursor.getString(1);
            String id_lop = cursor.getString(2);
            Student student = new Student(tenSV, ngaySinh,id_lop);
            listStudent.add(student);
            cursor.moveToNext();
        }
        return listStudent;
    }
}
