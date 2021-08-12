package com.example.lab5_bai1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MySQL extends SQLiteOpenHelper {
    public MySQL(@Nullable Context context) {
        super(context, "MyData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Product (ID nvarchar(10), Name nvarchar(100), Price nvarchar(20), constraint PK_Product primary key (ID))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void load (Product product){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", product.getID());
        contentValues.put("Name", product.getName());
        contentValues.put("Price", product.getPrice());

        sqLiteDatabase.insert("Product", null, contentValues);
    }


    public List<Product> getProductList(){
        List<Product> productList = new ArrayList<>();
        String sql = "Select * From Product";

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        cursor.moveToNext();

        while(!cursor.isAfterLast()){

            String ID, Name, Price;

            ID = cursor.getString(0);
            Name = cursor.getString(1);
            Price = cursor.getString(2);

            Product product = new Product(ID, Name, Price);

            productList.add(product);
            cursor.moveToNext();

        }

        cursor.close();

        return productList;
    }

    public void update (Product product){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", product.getID());
        contentValues.put("Name", product.getName());
        contentValues.put("Price", product.getPrice());

        sqLiteDatabase.update("Product",contentValues,"ID = ?", new String[] {product.getID()});

    }

    public void delete (String ID){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("Product", "ID = ?", new String[] {ID});

    }
}
