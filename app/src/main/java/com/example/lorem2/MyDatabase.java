package com.example.lorem2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Hashtable;

public class MyDatabase extends SQLiteOpenHelper
{

    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(id INTEGER primary key AUTOINCREMENT ,name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //method add
    public void  add(String n){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("name",n);
        db.insert("student",null,cv);
        db.close();
    }
    //methid get table
    public   ArrayList<String> get_table()
    {
        ArrayList<String> list_student = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from student",null);
         while (!cs.isAfterLast()){
             String n = cs.getString(1);
             list_student.add(n);
             cs.moveToNext();
         }
         db.close();
         return list_student;
    }
}
