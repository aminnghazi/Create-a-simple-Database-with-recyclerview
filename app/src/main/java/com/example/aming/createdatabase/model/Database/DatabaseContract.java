package com.example.aming.createdatabase.model.Database;

public class DatabaseContract {
    //DataBase name
    public static final String DATABASE_NAME = "Notes.db";
    //Data Types
    public static final String INTEGER_TYPE = "INTEGER";
    public static final String TEXT_TYPE = "TEXT";
    //Table name
    public static final String TABLE_NAME = "Notes";
    //Columns names
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_CREATE_DATE = "createDate";
    public static final String COLUMN_ID = "id";

    public static final String COMMA = ",";

    //String parameter for creating table method
    public static final String CREATE_TABLE = "CREATE TABLE " + DatabaseContract.TABLE_NAME
            + " (" + DatabaseContract.COLUMN_ID +" "+ DatabaseContract.INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT" +DatabaseContract.COMMA
            +DatabaseContract.COLUMN_TITLE+" "+DatabaseContract.TEXT_TYPE+
            DatabaseContract.COMMA+DatabaseContract.COLUMN_CONTENT+" "+DatabaseContract.TEXT_TYPE+DatabaseContract.COMMA+
            DatabaseContract.COLUMN_CREATE_DATE+" "+DatabaseContract.TEXT_TYPE + ") ";

    //String parameter for onUpgrade method
    public static final String DROP_TABLE ="DROPTABLE "+DatabaseContract.TABLE_NAME;
}
