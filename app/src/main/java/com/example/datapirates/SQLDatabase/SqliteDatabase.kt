package com.example.datapirates.SQLDatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import kotlin.math.ln

class SqliteDatabase(
    context: Context?
) : SQLiteOpenHelper(context, "Login.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        var sql = "CREATE TABLE login(id INTEGER PRIMARY KEY AUTOINCREMENT,fname TEXT,lname TEXT,email TEXT,password TEXT,cpassword TEXT)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun AddData(fname : String,lname : String,email : String,password : String,cpassword : String){
        var db = writableDatabase
        var values = ContentValues()
        values.put("fname",fname)
        values.put("lname", lname)
        values.put("email",email)
        values.put("password",password)
        values.put("cpassword",cpassword)
        db.insert("login",null,values)
    }

    fun showData(): ArrayList<LoginModel> {
        var modelList = ArrayList<LoginModel>()
        var db = readableDatabase
        var sql = "SELECT * FROM login"
        var cursor = db.rawQuery(sql,null)
        cursor.moveToFirst()

        for (x in 0..cursor.count-1) {
            var id = cursor.getInt(0)
            var fname = cursor.getString(1)
            var lname = cursor.getString(2)
            var email = cursor.getString(3)
            var password = cursor.getString(4)
            var cpassword = cursor.getString(5)
            var model = LoginModel(id, fname, lname, email,password,cpassword)
            modelList.add(model)
            cursor.moveToNext()
        }
        return modelList
    }
}