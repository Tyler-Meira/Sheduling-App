package org.stn01432291.finalproject

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import android.content.ContentValues
import android.database.Cursor

class MyDBOpenHelper(
    context: Context?,
    //name: String?,
    factory: SQLiteDatabase.CursorFactory?
    //version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        private val version = 1
        private val name = "MyName.Db"
        val TABLE_NAME = "users"
        val COLUMN_ID = "_id"
        val COLUMN_NAME1 = "name"
        val COLUMN_NAME2 = "phone"
        val COLUMN_NAME3 = "date"
        val COLUMN_NAME4= "time"
        val COLUMN_NAME5= "address"
        val COLUMN_NAME6= "desc"
        val COLUMN_NAME7= "associatedUser"



    }

    @Override
    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_PRODUCT_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME1 + " TEXT," +
                COLUMN_NAME2 + " TEXT," +
                COLUMN_NAME3 + " TEXT," +
                COLUMN_NAME4 + " TEXT," +
                COLUMN_NAME5 + " TEXT," +
                COLUMN_NAME6 + " TEXT," +
                COLUMN_NAME7 + " TEXT" + ");")

        db?.execSQL(CREATE_PRODUCT_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addName(name: String, phone: String, desc: String, date: String, address: String, time: String, email: String) {
        val values = ContentValues()
        values.put(COLUMN_NAME1, name)
        values.put(COLUMN_NAME2, phone)
        values.put(COLUMN_NAME3, desc)
        values.put(COLUMN_NAME4, date)
        values.put(COLUMN_NAME5, address)
        values.put(COLUMN_NAME6, time)
        values.put(COLUMN_NAME7, email)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllName(email: String): Cursor?{
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME WHERE associatedUser= '" + email + "'", null)
    }

    fun delete(phoneNum: String){
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_NAME2= '"+phoneNum +"'", null)
        db.close()
    }

}