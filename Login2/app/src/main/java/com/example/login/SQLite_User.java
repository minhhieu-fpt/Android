package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLite_User extends SQLiteOpenHelper {

    public SQLite_User(@Nullable Context context) {
        super(context, "data_user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table User_TK(User text primary key, Password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    SQLiteDatabase sqLiteDatabase1 = getReadableDatabase();
    SQLiteDatabase sqLiteDatabase2 = getWritableDatabase();

    public void them (User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("User", user.getUser());
        contentValues.put("Password", user.getPassword());
        sqLiteDatabase2.insert("User_TK", null, contentValues);

    }

    public void sua (User user){

        ContentValues contentValues= new ContentValues();
        contentValues.put("User", user.getUser());
        contentValues.put("Password", user.getPassword());
        sqLiteDatabase2.update("User_TK", contentValues, "User = ?", new String[] {user.getUser()});

    }

    public void xoa (String user){

        sqLiteDatabase2.delete("User_TK","User = ?", new String[]{user});
    }

    public List<User> getListUser (){

        List<User> userList = new ArrayList<>();
        Cursor cursor =sqLiteDatabase1.rawQuery("Select * From User_TK",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            String user = cursor.getString(0);
            String pass = cursor.getString(1);

            User user1 = new User(user,pass);
            userList.add(user1);

            cursor.moveToNext();
        }
        cursor.close();
        return userList;
    }

    public int getindex (String user){
        for (int i = 0; i < getListUser().size() ; i++) {

            if(getListUser().get(i).getUser().equalsIgnoreCase(user)){
                    return i;

            }
        }
        return -1;

    }
}
