package com.example.agenda

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLiteHelper(context: Context) : SQLiteOpenHelper(context,"addressBook.db",null,1) {

    companion object{
        const val TABLE_NAME="Contacts"
        const val FIELD_ID="_id"
        const val FIELD_NAME="name"
        const val FIELD_SURNAME="surname"
        const val FIELD_PHONE="phone"
        const val FIELD_EMAIL="email"

    }
    override fun onCreate(db: SQLiteDatabase?) {
        val commandCreate = "CREATE TABLE $TABLE_NAME" +
                "($FIELD_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "$FIELD_NAME TEXT,"+
                "$FIELD_SURNAME TEXT,"+
                "$FIELD_PHONE TEXT,"+
                "$FIELD_EMAIL TEXT)"

                db!!.execSQL(commandCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val commandDelete= "DROP TABLE IF EXISTS $TABLE_NAME"
        db!!.execSQL(commandDelete)
        onCreate(db)
    }

    fun addData(name: String, surname: String,teléfono:String,email: String) {
        val data = ContentValues()
        data.put(FIELD_NAME, name)
        data.put(FIELD_SURNAME, surname)
        data.put(FIELD_PHONE, teléfono)
        data.put(FIELD_EMAIL, email)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, data)
        db.close()

    }

    fun deleteData(id: Int): Int {
        val args = arrayOf(id.toString())
        val db = this.writableDatabase
        val affectedRows = db.delete(TABLE_NAME, "$FIELD_ID = ?" , args)
        db.close()
        return affectedRows
    }

    fun updateData (id: String, name: String, surname: String, teléfono: String,email: String) {
        val args = arrayOf((id))
        val data = ContentValues()
        data.put(FIELD_ID, id)
        data.put(FIELD_NAME, name)
        data.put(FIELD_SURNAME, surname)
        data.put(FIELD_PHONE, teléfono)
        data.put(FIELD_EMAIL,email )
        val db = this.writableDatabase
        db.update(TABLE_NAME, data, "$FIELD_ID = ?",args)
        db.close()
    }




}