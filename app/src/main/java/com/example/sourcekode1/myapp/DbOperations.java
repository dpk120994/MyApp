package com.example.sourcekode1.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sourcekode1 on 04/08/17.
 */

public class DbOperations extends SQLiteOpenHelper {
    String query="CREATE TABLE EMP(F_NAME TEXT,L_NAME TEXT)";
    public DbOperations(Context context) {
        super(context, "MyDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Boolean addInfo(String f_name,String l_name)
    {

        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("F_NAME",f_name);
        values.put("L_NAME",l_name);
        database.insert("EMP",null,values);
        return true;



    }
    public Cursor getInfo()
    {

        SQLiteDatabase database=this.getReadableDatabase();
        String [] columns={"F_NAME"
        ,"L_NAME"};
        Cursor cursor=database.query("EMP",columns,null,null,null,null,null);
        return cursor;



    }
    public Cursor getInfoParticular(String a)
    {
        SQLiteDatabase database=this.getReadableDatabase();
        String [] columns={"F_NAME"
                ,"L_NAME"};
        Cursor cursor=database.query("EMP",columns,"F_NAME=?",columns,null,null,null);
        return cursor;


    }



}
