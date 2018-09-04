package com.example.aming.createdatabase.model.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper  {
    public DatabaseHelper(Context context) {
        super(context,DatabaseContract.DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(DatabaseContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(DatabaseContract.DROP_TABLE);
    db.execSQL(DatabaseContract.CREATE_TABLE);
    }

}
