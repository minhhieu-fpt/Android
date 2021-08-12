package com.example.bai_thi_tkgda_3.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.bai_thi_tkgda_3.Model.My_Time;

import java.util.ArrayList;
import java.util.List;

public class MySQLite extends SQLiteOpenHelper {

    public MySQLite(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table TABLE_TIME(NOI_DUNG text primary key, TIME text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists TABLE_TIME");
        onCreate(db);
    }

    SQLiteDatabase sqLiteDatabase = getWritableDatabase();
    SQLiteDatabase sqLiteDatabaseread = getReadableDatabase();

    public void add_time (My_Time my_time){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOI_DUNG", my_time.getNoidung());
        contentValues.put("TIME", my_time.getTime());
        sqLiteDatabase.insert("TABLE_TIME",null,contentValues);
    }

    public void edit_time (My_Time my_time){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOI_DUNG", my_time.getNoidung());
        contentValues.put("TIME", my_time.getTime());
        sqLiteDatabase.update("TABLE_TIME",contentValues,"NOI_DUNG = ?", new String[]{my_time.getNoidung()});
    }

    public void delete_user (String noidung){
        sqLiteDatabase.delete("TABLE_TIME", "NOI_DUNG = ?", new String[]{noidung});
    }


    public List<My_Time> get_list_time (){
        List<My_Time> timeList = new ArrayList<>();
        Cursor cursor = sqLiteDatabaseread.rawQuery("Select * From TABLE_TIME",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String noidung = cursor.getString(0);
            String timem = cursor.getString(1);
            My_Time time = new My_Time(noidung, timem);
            timeList.add(time);
            cursor.moveToNext();
        }
        cursor.close();
        return timeList;

    }

    public int check_ton_tai (String string){
        for (int i = 0; i < get_list_time().size(); i++) {
            if(get_list_time().get(i).getNoidung().equalsIgnoreCase(string)){
                return i;
            }
        }
        return -1;
    }
}
