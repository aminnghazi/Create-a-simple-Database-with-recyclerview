package com.example.aming.createdatabase.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper implements DatabaseHelperInterface {
    public DatabaseHelper(Context context) {
        super(context,DatabaseContract.DATABASE_NAME,null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(DatabaseContract.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(DatabaseContract.DROP_TABLE);
    onCreate(db);
    }

    @Override
    public boolean insertdata(String title, String content, String createdate) {
        SQLiteDatabase sd=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(DatabaseContract.COLUMN_CONTENT,content);
        cv.put(DatabaseContract.COLUMN_TITLE,title);
        cv.put(DatabaseContract.COLUMN_CREATE_DATE,createdate);
        long result = sd.insert(DatabaseContract.TABLE_NAME,null,cv);
        if (result == -1) return false;
        else return true;
    }

    @Override
    public Cursor getData() {
        SQLiteDatabase db=getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+DatabaseContract.TABLE_NAME,null);
        return res;
    }
}
