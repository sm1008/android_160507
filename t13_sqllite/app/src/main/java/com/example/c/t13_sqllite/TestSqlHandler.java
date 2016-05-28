package com.example.c.t13_sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by c on 2016-05-28.
 */
public class TestSqlHandler {
    TestSqliteOpenHelper helper;
    public TestSqlHandler(Context context){
        helper = new TestSqliteOpenHelper(context,"people",null,1);

    }

    public  void insert(String name, int age, String address){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("age",age);
        values.put("address",address);

        db.insert("student",null,values);
    }

    public void delete(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("student","name=?",new String[]{name});
    }

    public void update(String name, int age){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("age",age);

        db.update("student",values,"name=?",new String[]{name});
    }


    public void showAll(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("student",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));

            Log.d("sqlite","name:"+name+"  address:"+address+"  age:"+age);

        }
    }


}
