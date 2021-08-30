package com.example.loginpage
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context,"details.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ADMIN(NAME VARCHAR2,UNAME VARCHAR2,PASS VARCHAR2)")
        db?.execSQL("CREATE TABLE ADDCONTACT(CNAME VARCHAR2,EMAIL VARCHAR2,PHNO NUMBER(10))")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ADMIN")
        db?.execSQL("DROP TABLE IF EXISTS ADDCONTACT")
    }
}
