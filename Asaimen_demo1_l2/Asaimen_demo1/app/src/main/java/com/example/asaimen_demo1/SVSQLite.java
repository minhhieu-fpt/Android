package com.example.asaimen_demo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SVSQLite extends SQLiteOpenHelper {

    public SVSQLite(@Nullable Context context) {
        super(context,"svsqlite.db", null, 1);
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table SinhVien( idSV Text primary key ,TenSV Text,NoiSinh Text,NgaySinh Text,idLop Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    SQLiteDatabase sqLiteDatabase = getWritableDatabase();

    public void themSV(SinhVien sv){

        ContentValues contentValues = new ContentValues();
        contentValues.put("idSV",sv.getIdSV());
        contentValues.put("TenSV",sv.getTenSV());
        contentValues.put("NoiSinh",sv.getNoiSinh());
        contentValues.put("NgaySinh",sv.getNgaySinh());
        contentValues.put("idLop",sv.getIdLop());
        //Thêm vào bảng bằng câu lệnh insert

        sqLiteDatabase.insert("SinhVien",null,contentValues);
    }

    public List<SinhVien> getListAll(){
        List<SinhVien> sinhVienList = new ArrayList<>();
        String get_all = "Select*from SinhVien";
        Cursor cursor = sqLiteDatabase.rawQuery(get_all,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            String idSV,TenSV,NoiSinh,NgaySinh,idLop;

            idSV = cursor.getString(0);
            TenSV = cursor.getString(1);
            NoiSinh = cursor.getString(2);
            NgaySinh = cursor.getString(3);
            idLop = cursor.getString(4);

            SinhVien sv = new SinhVien(idSV,TenSV,NoiSinh,NgaySinh,idLop);
            sinhVienList.add(sv);
            cursor.moveToNext();
        }
        cursor.close();

        return sinhVienList;
    }

    public void update(SinhVien sv){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("TenSV",sv.getTenSV());
        contentValues.put("NoiSinh",sv.getNoiSinh());
        contentValues.put("NgaySinh",sv.getNgaySinh());
        contentValues.put("idLop",sv.getIdLop());

        sqLiteDatabase.update("SinhVien",contentValues,"idSV = ?",new String[]{sv.getIdSV()});
    }

    public void delete(String idSV){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("SinhVien","idSV = ?",new String[]{idSV});
    }
}
