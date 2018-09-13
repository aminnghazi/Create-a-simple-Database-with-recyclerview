package com.example.aming.createdatabase.model.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.aming.createdatabase.model.items.RecyclerviewItems;

import java.util.ArrayList;

public class Operator {
    Context cntx;

    public Operator(Context context) {
        this.cntx = context;
    }

        public RecyclerviewItems insertdata(RecyclerviewItems item) {

            DatabaseHelper helper = new DatabaseHelper(cntx);
            SQLiteDatabase db=helper.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put(DatabaseContract.COLUMN_CONTENT,item.getContent());
            cv.put(DatabaseContract.COLUMN_TITLE,item.getTitle());
            cv.put(DatabaseContract.COLUMN_CREATE_DATE,item.getCratedate());
            long result = db.insert(DatabaseContract.TABLE_NAME,null,cv);
            if (db.isOpen())db.close();
            if (result == -1) {
                return null;
            }
            else{
                item.setId(result);
                return item;
            }
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
        public boolean deletFromDatabase(RecyclerviewItems item){
        boolean is_deleted = true;
        DatabaseHelper helper = new DatabaseHelper(cntx);
        SQLiteDatabase db =helper.getWritableDatabase();
        long id = item.getId();
        db.delete(DatabaseContract.TABLE_NAME,
                DatabaseContract.COLUMN_ID+ " = ? "
                ,new String[]{String.valueOf(item.getId())});



        if (db.isOpen())db.close();
        return is_deleted;
        }
        }


