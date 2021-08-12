package com.example.thi_cuoi_ki;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLite extends SQLiteOpenHelper {




        public SQLite(@Nullable Context context) {
            super(context, "data_time.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table Thoi_Gian_TB (Thoi_Gian text primary key, Noi_Dung text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        SQLiteDatabase sqLiteDatabase1 = getReadableDatabase();
        SQLiteDatabase sqLiteDatabase2 = getWritableDatabase();

        public void them (Thoi_Gian thoi_gian) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("Thoi_Gian", thoi_gian.getThoigian());
            contentValues.put("Noi_Dung", thoi_gian.getNoidung());
            sqLiteDatabase2.insert("Thoi_Gian_TB", null, contentValues);

        }

        public void sua (Thoi_Gian thoi_gian){

            ContentValues contentValues = new ContentValues();
            contentValues.put("Thoi_Gian", thoi_gian.getThoigian());
            contentValues.put("Noi_Dung", thoi_gian.getNoidung());
            sqLiteDatabase2.update("Thoi_Gian_TB", contentValues, "Thoi_Gian = ?", new String[] {thoi_gian.getThoigian()});

        }

        public void xoa (String thoi_gian){

            sqLiteDatabase2.delete("Thoi_Gian_TB","Thoi_Gian = ?", new String[]{thoi_gian});
        }

        public List<Thoi_Gian> getListThoiGian (){

            List<Thoi_Gian> thoi_gianList = new ArrayList<>();
            Cursor cursor =sqLiteDatabase1.rawQuery("Select * From Thoi_Gian_TB",null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){

                String thoi_gian = cursor.getString(0);
                String noi_dung = cursor.getString(1);

                Thoi_Gian thoi_gian1 = new Thoi_Gian(thoi_gian,noi_dung);
                thoi_gianList.add(thoi_gian1);

                cursor.moveToNext();
            }
            cursor.close();
            return thoi_gianList;
        }

        public int getindex (String thoigian){
            for (int i = 0; i < getListThoiGian().size() ; i++) {

                if(getListThoiGian().get(i).getThoigian().equalsIgnoreCase(thoigian)){
                    return i;

                }
            }
            return -1;

        }
    }


