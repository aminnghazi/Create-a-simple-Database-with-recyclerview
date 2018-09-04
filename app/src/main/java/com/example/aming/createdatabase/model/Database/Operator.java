package com.example.aming.createdatabase.model.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.aming.createdatabase.model.items.RecyclerviewItems;

import java.util.ArrayList;

public class Operator {
    Context cntx;

    public Operator(Context context) {
        this.cntx = context;
    }

        public boolean insertdata(String title, String content, String createdate) {

            DatabaseHelper helper = new DatabaseHelper(cntx);
            SQLiteDatabase db=helper.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put(DatabaseContract.COLUMN_CONTENT,content);
            cv.put(DatabaseContract.COLUMN_TITLE,title);
            cv.put(DatabaseContract.COLUMN_CREATE_DATE,createdate);
            long result = db.insert(DatabaseContract.TABLE_NAME,null,cv);
            if (result == -1) return false;
            else return true;
        }

        public ArrayList<RecyclerviewItems> getData() {
            ArrayList<RecyclerviewItems> itemslist = new ArrayList<>();
            DatabaseHelper helper = new DatabaseHelper(cntx);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor c=db.rawQuery("select * from "+DatabaseContract.TABLE_NAME,null);
            if (c.getCount() < 1) {
                if (db.isOpen()) db.close();
                return itemslist;
            }
            while (c.moveToNext()) {
                int idIndex = c.getColumnIndex(DatabaseContract.COLUMN_ID);
                long id = c.getLong(idIndex);

                int titleIndex = c.getColumnIndex(DatabaseContract.COLUMN_TITLE);
                String title = c.getString(titleIndex);

                int contentIndex = c.getColumnIndex(DatabaseContract.COLUMN_CONTENT);
                String content = c.getString(contentIndex);

                int createDateIndex = c.getColumnIndex(DatabaseContract.COLUMN_CREATE_DATE);
                String createDate = c.getString(createDateIndex);

                RecyclerviewItems item = new RecyclerviewItems(id,title,content, createDate);

                itemslist.add(item);
            }
            if (db.isOpen()) db.close();

            return itemslist;
        }


        public RecyclerviewItems getLastitem(){
            DatabaseHelper helper = new DatabaseHelper(cntx);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor c=db.rawQuery("select * from "+DatabaseContract.TABLE_NAME,null);
            c.moveToLast();
            int idIndex = c.getColumnIndex(DatabaseContract.COLUMN_ID);
            long id = c.getLong(idIndex);

            int titleIndex = c.getColumnIndex(DatabaseContract.COLUMN_TITLE);
            String title = c.getString(titleIndex);

            int contentIndex = c.getColumnIndex(DatabaseContract.COLUMN_CONTENT);
            String content = c.getString(contentIndex);

            int createDateIndex = c.getColumnIndex(DatabaseContract.COLUMN_CREATE_DATE);
            String createDate = c.getString(createDateIndex);

            RecyclerviewItems item = new RecyclerviewItems(id,title,content,createDate);
            return item;
        }
        }

