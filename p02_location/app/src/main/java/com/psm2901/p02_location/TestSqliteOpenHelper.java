package com.psm2901.p02_location;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by psm29 on 2016-06-04.
 */
public class TestSqliteOpenHelper extends SQLiteOpenHelper {
    public TestSqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table location(id integer primary key autoincrement, latitude real, longitude real, time integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists location";
        db.execSQL(sql);

        onCreate(db);
    }
}
