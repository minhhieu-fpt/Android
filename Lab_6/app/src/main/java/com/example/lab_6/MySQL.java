package com.example.lab_6;

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
        super(context, "myDataBase.db", null, 1);
    }

    public static final String TABLE_NAME = "Product";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_PRICE = "Price";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " + TABLE_NAME + " (" + COLUMN_ID  + " nvarchar(10), " + COLUMN_NAME + " nvarchar(100), " + COLUMN_PRICE + " nvarchar(20), constraint PK_Product primary key ( " + COLUMN_ID + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert (Product product){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, product.getID());
        contentValues.put(COLUMN_NAME, product.getTenSP());
        contentValues.put(COLUMN_PRICE, product.getPrice());

        return sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public long update (Product product){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, product.getID());
        contentValues.put(COLUMN_NAME, product.getTenSP());
        contentValues.put(COLUMN_PRICE, product.getPrice());

        return sqLiteDatabase.update(TABLE_NAME,contentValues,COLUMN_ID + "= ?", new String[] {product.getID()});

    }

    public void delete (String ID){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, COLUMN_ID + "= ?", new String[] {ID});

    }

    public List<Product> getProductList(){
        List<Product> productList = new ArrayList<>();
//        String sql = "Select * From " + TABLE_NAME ;

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * From " + TABLE_NAME, null);

        cursor.moveToNext();

        while(!cursor.isAfterLast()){

            String ID, Name, Price;

            ID = cursor.getString(cursor.getColumnIndex(COLUMN_ID));
            Name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            Price = cursor.getString(cursor.getColumnIndex(COLUMN_PRICE));

            Product product = new Product(ID, Name, Price);

            productList.add(product);
            cursor.moveToNext();

        }

        cursor.close();

        return productList;
    }


}
