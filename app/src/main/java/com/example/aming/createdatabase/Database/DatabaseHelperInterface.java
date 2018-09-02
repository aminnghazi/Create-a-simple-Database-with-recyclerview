package com.example.aming.createdatabase.Database;

import android.database.Cursor;

public interface DatabaseHelperInterface {
    public boolean insertdata(String title,String content,String createdate);
    public Cursor getData();
}
