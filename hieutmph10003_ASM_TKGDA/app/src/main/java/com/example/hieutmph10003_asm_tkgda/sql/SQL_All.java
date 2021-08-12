package com.example.hieutmph10003_asm_tkgda.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.hieutmph10003_asm_tkgda.model.Khoan_Chi;
import com.example.hieutmph10003_asm_tkgda.model.Khoan_Thu;
import com.example.hieutmph10003_asm_tkgda.model.Loai_Chi;
import com.example.hieutmph10003_asm_tkgda.model.Loai_Thu;

import java.util.ArrayList;
import java.util.List;

public class SQL_All extends SQLiteOpenHelper {
    public SQL_All(@Nullable Context context) {
        super(context, "Data_Thu_Chi.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table LOAI_THU(ID_LOAI_THU int primary key, TEN_LOAI_THU text)");
        db.execSQL("create table KHOAN_THU(ID_KHOAN_THU int primary key, TEN_KHOAN_THU text, SO_TIEN_THU int, LOAI_THU text, NGAY_THU text, ID_LOAI_THU int, constraint THU foreign key (ID_LOAI_THU) references LOAI_THU (ID_LOAI_THU))");

        db.execSQL("create table LOAI_CHI(ID_LOAI_CHI int primary key, TEN_LOAI_CHI text)");
        db.execSQL("create table KHOAN_CHI(ID_KHOAN_CHI int primary key, TEN_KHOAN_CHI text, SO_TIEN_CHI int, LOAI_CHI text, NGAY_CHI text, ID_LOAI_CHI int, constraint CHI foreign key (ID_LOAI_CHI) references LOAI_CHI (ID_LOAI_CHI))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    SQLiteDatabase sqLiteDatabase = getWritableDatabase();
    SQLiteDatabase sqLiteDatabaseread = getReadableDatabase();

    public void add_loai_thu (Loai_Thu loai_thu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_LOAI_THU", loai_thu.getIdLoaiThu());
        contentValues.put("TEN_LOAI_THU", loai_thu.getTenLoaiThu());
        sqLiteDatabase.insert("LOAI_THU",null,contentValues);
    }

    public void edit_loai_thu(Loai_Thu loai_thu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_LOAI_THU", loai_thu.getIdLoaiThu());
        contentValues.put("TEN_LOAI_THU", loai_thu.getTenLoaiThu());
        sqLiteDatabase.update("LOAI_THU",contentValues,"ID_LOAI_THU = ?", new String[]{String.valueOf(loai_thu.getIdLoaiThu())});
    }

    public void delete_loai_thu (Loai_Thu loai_thu){
        sqLiteDatabase.delete("LOAI_THU","ID_LOAI_THU = ?", new String[]{String.valueOf(loai_thu.getIdLoaiThu())});
    }

    public List<Loai_Thu> get_list_loai_thu(){
        List<Loai_Thu> loai_thuList = new ArrayList<>();
        Cursor cursor = sqLiteDatabaseread.rawQuery("Select * From LOAI_THU", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id = cursor.getString(0);
            String tenkhoanthu = cursor.getString(1);
            Loai_Thu loai_thu = new Loai_Thu(Integer.parseInt(id), tenkhoanthu);
            loai_thuList.add(loai_thu);
            cursor.moveToNext();

        }
        cursor.close();
        return loai_thuList;
    }

    public void add_khoan_thu (Khoan_Thu khoan_thu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_KHOAN_THU", khoan_thu.getId());
        contentValues.put("TEN_KHOAN_THU", khoan_thu.getTenKhoanThu());
        contentValues.put("SO_TIEN_THU", khoan_thu.getSoTienThu());
        contentValues.put("LOAI_THU", khoan_thu.getLoaiThu());
        contentValues.put("NGAY_THU", khoan_thu.getNgayThu());
        contentValues.put("ID_LOAI_THU", khoan_thu.getIdLoaiThu());
        sqLiteDatabase.insert("KHOAN_THU", null, contentValues);

    }

    public void edit_khoan_thu (Khoan_Thu khoan_thu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_KHOAN_THU", khoan_thu.getId());
        contentValues.put("TEN_KHOAN_THU", khoan_thu.getTenKhoanThu());
        contentValues.put("SO_TIEN_THU", khoan_thu.getSoTienThu());
        contentValues.put("LOAI_THU", khoan_thu.getLoaiThu());
        contentValues.put("NGAY_THU", khoan_thu.getNgayThu());
        contentValues.put("ID_LOAI_THU", khoan_thu.getIdLoaiThu());
        sqLiteDatabase.update("KHOAN_THU",contentValues,"ID_KHOAN_THU = ?", new String[] {String.valueOf(khoan_thu.getId())});
    }

    public void delete_khoan_thu(Khoan_Thu khoan_thu){
        sqLiteDatabase.delete("KHOAN_THU", "ID_KHOAN_THU = ?", new String[]{String.valueOf(khoan_thu.getId())});
    }

    public List<Khoan_Thu> get_list_khoan_thu(){
        final List<Khoan_Thu> khoan_thuList = new ArrayList<>();

        Cursor cursor = sqLiteDatabaseread.rawQuery("Select * From KHOAN_THU",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id = cursor.getString(cursor.getColumnIndex("ID_KHOAN_THU"));
            String ten = cursor.getString(cursor.getColumnIndex("TEN_KHOAN_THU"));
            String sotien = cursor.getString(cursor.getColumnIndex("SO_TIEN_THU"));
            String loaiThu = cursor.getString(cursor.getColumnIndex("LOAI_THU"));
            String ngaythu = cursor.getString(cursor.getColumnIndex("NGAY_THU"));
            String idLoaiThu = cursor.getString(cursor.getColumnIndex("ID_LOAI_THU"));

            Khoan_Thu khoan_thu = new Khoan_Thu(Integer.parseInt(id), ten, Integer.parseInt(sotien), loaiThu, ngaythu,Integer.parseInt(idLoaiThu));
            khoan_thuList.add(khoan_thu);
            cursor.moveToNext();

        }
        cursor.close();
        return khoan_thuList;
    }

    public void add_loai_chi(Loai_Chi loai_chi){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_LOAI_CHI", loai_chi.getIdLoaiChi());
        contentValues.put("TEN_LOAI_CHI", loai_chi.getTenLoaiChi());
        sqLiteDatabase.insert("LOAI_CHI", null, contentValues);
    }

    public void edit_loai_chi(Loai_Chi loai_chi){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_LOAI_CHI", loai_chi.getIdLoaiChi());
        contentValues.put("TEN_LOAI_CHI", loai_chi.getTenLoaiChi());
        sqLiteDatabase.update("LOAI_CHI", contentValues, "ID_LOAI_CHI = ?", new String[]{String.valueOf(loai_chi.getIdLoaiChi())});
    }

    public void delete_loai_chi (Loai_Chi loai_chi){
        sqLiteDatabase.delete("LOAI_CHI", "ID_LOAI_CHI = ?", new String[]{String.valueOf(loai_chi.getIdLoaiChi())});
    }

    public List<Loai_Chi> get_list_loai_chi(){
        List<Loai_Chi> loai_chiList = new ArrayList<>();
        Cursor cursor = sqLiteDatabaseread.rawQuery("Select * From LOAI_CHI", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id = cursor.getString(0);
            String ten = cursor.getString(1);
            Loai_Chi loai_chi = new Loai_Chi(Integer.parseInt(id),ten);
            loai_chiList.add(loai_chi);
            cursor.moveToNext();
        }
        cursor.close();
        return loai_chiList;
    }

    public void add_khoan_chi(Khoan_Chi khoan_chi) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_KHOAN_CHI", khoan_chi.getIdKhoanChi());
        contentValues.put("TEN_KHOAN_CHI", khoan_chi.getTenKhoanChi());
        contentValues.put("SO_TIEN_CHI", khoan_chi.getSoTienChi());
        contentValues.put("LOAI_CHI", khoan_chi.getNoiDung());
        contentValues.put("NGAY_CHI", khoan_chi.getNgayChi());
        contentValues.put("ID_LOAI_CHI", khoan_chi.getIdLoaiChi());

        sqLiteDatabase.insert("KHOAN_CHI", null, contentValues);
    }

    public void edit_khoan_chi(Khoan_Chi khoan_chi) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID_KHOAN_CHI", khoan_chi.getIdKhoanChi());
        contentValues.put("TEN_KHOAN_CHI", khoan_chi.getTenKhoanChi());
        contentValues.put("SO_TIEN_CHI", khoan_chi.getSoTienChi());
        contentValues.put("LOAI_CHI", khoan_chi.getNoiDung());
        contentValues.put("NGAY_CHI", khoan_chi.getNgayChi());
        contentValues.put("ID_LOAI_CHI", khoan_chi.getIdLoaiChi());

        sqLiteDatabase.update("KHOAN_CHI", contentValues, "ID_KHOAN_CHI = ?", new String[]{String.valueOf(khoan_chi.getIdKhoanChi())});

    }

    public void delete_khoan_chi (Khoan_Chi khoan_chi){
        sqLiteDatabase.delete("KHOAN_CHI", "ID_KHOAN_CHI = ?", new String[]{String.valueOf(khoan_chi.getIdKhoanChi())});
    }


    public List<Khoan_Chi> get_list_khoan_chi(){
        List<Khoan_Chi> khoan_chiList = new ArrayList<>();
        Cursor cursor = sqLiteDatabaseread.rawQuery("Select * From KHOAN_CHI", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id = cursor.getString(0);
            String ten = cursor.getString(1);
            String sotien = cursor.getString(2);
            String loaichi = cursor.getString(3);
            String ngaychi = cursor.getString(4);
            String idloaichi = cursor.getString(5);
            Khoan_Chi khoan_chi = new Khoan_Chi(Integer.parseInt(id),ten,Integer.parseInt(sotien),loaichi,ngaychi,Integer.parseInt(idloaichi));
            khoan_chiList.add(khoan_chi);
            cursor.moveToNext();
        }
        cursor.close();
        return khoan_chiList;
    }

}