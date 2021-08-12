package com.example.mysqlite;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends SQLiteOpenHelper {
    public MainActivity(@Nullable Context context) {
        super(context, "mydata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table LOP (idLop nvarchar(9) not null, TenLop nvarchar(30) not null, Nganh nvarchar(30) not null, constraint FK_LOP primary key (idLop))");
        db.execSQL("create table SINHVIEN (IDSV nvarchar(9) primary key not null, tenSV text , noisinh text ,ngaysinh text, idLop text, constraint FK_SinhVien_Lop foreign key (idLop) references LOP(idLop))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void themsinhvien(SinhVien sv){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("IDSV", sv.getID());
        contentValues.put("tenSV", sv.getTen());
        contentValues.put("noisinh", sv.getNoisinh());
        contentValues.put("ngaysinh", sv.getNgaysinh());
        contentValues.put("idLop", sv.getIDlop());

        sqLiteDatabase.insert("SINHVIEN", null,contentValues);

    }

    public void themlop(Lop lop){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("idLop", lop.getIdlop());
        contentValues.put("TenLop", lop.getTenlop());
        contentValues.put("Nganh", lop.getNghanh());


    }
}
