package com.example.asaimen_demo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MySQLite extends SQLiteOpenHelper {
    public MySQLite(@Nullable Context context) {
        super(context, "muData1.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Lop(IdLop Text primary key,TenLop Text)");
        db.execSQL("Create table SinhVien( idSV Text primary key ,TenSV Text,NoiSinh Text,NgaySinh Text,idLop Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    SQLiteDatabase sqLiteDatabase = getWritableDatabase();
    public void themLop(Lop lp){

        ContentValues contentValues = new ContentValues();
        contentValues.put("IdLop",lp.getIdlop());
        contentValues.put("TenLop",lp.getTenLop());
        sqLiteDatabase.insert("Lop",null,contentValues);
    }


    public List<Lop> getListLopAll(){
        List<Lop> listlp = new ArrayList<>();
        String get_all = "Select*from Lop";
        Cursor cursor = sqLiteDatabase.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
        String idLop,tenLop;
     idLop = cursor.getString(0);
     tenLop = cursor.getString(1);
     Lop lp = new Lop(idLop,tenLop);
     listlp.add(lp);
     cursor.moveToNext();
        }
        cursor.close();
        return listlp;
    }
    public void suaLop(Lop lp){
 ContentValues contentValues = new ContentValues();
 contentValues.put("IdLop",lp.getIdlop());
 contentValues.put("TenLop",lp.getIdlop());
 sqLiteDatabase.update("Lop",contentValues,"IdLop=?",new String[]{lp.getIdlop()});
    }
    public void xoaLop(String lp){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("Lop","IdLop=?",new String[]{lp});
    }


}
