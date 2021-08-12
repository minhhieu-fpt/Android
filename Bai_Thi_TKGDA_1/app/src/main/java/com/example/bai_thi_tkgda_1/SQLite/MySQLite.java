package com.example.bai_thi_tkgda_1.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.bai_thi_tkgda_1.Model.Use;

import java.util.ArrayList;
import java.util.List;

public class MySQLite extends SQLiteOpenHelper {

    public MySQLite(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table USER(USER_NAME text primary key, PASSWORD text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists USER");
        onCreate(db);
    }

    SQLiteDatabase sqLiteDatabase = getWritableDatabase();
    SQLiteDatabase sqLiteDatabaseread = getReadableDatabase();

    public void add_user (Use use){
        ContentValues contentValues = new ContentValues();
        contentValues.put("USER_NAME", use.getUser_name());
        contentValues.put("PASSWORD", use.getPassword());
        sqLiteDatabase.insert("USER",null,contentValues);
    }

    public void edit_user (Use use){
        ContentValues contentValues = new ContentValues();
        contentValues.put("USER_NAME", use.getUser_name());
        contentValues.put("PASSWORD", use.getPassword());
        sqLiteDatabase.update("USER",contentValues,"USER_NAME = ?", new String[]{use.getUser_name()});
    }

    public void delete_user (String use){
        sqLiteDatabase.delete("USER", "USER_NAME = ?", new String[]{use});
    }


    public List<Use> get_list_user (){
        List<Use> useList = new ArrayList<>();
        Cursor cursor = sqLiteDatabaseread.rawQuery("Select * From USER",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String user_name = cursor.getString(0);
            String password = cursor.getString(1);
            Use use = new Use(user_name, password);
            useList.add(use);
            cursor.moveToNext();
        }
        cursor.close();
        return useList;

    }

    public int check_ton_tai (String string){
        for (int i = 0; i < get_list_user().size(); i++) {
            if(get_list_user().get(i).getUser_name().equalsIgnoreCase(string)){
                return i;
            }
        }
        return -1;
    }
}
