package com.example.mad4


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, AKSHAYA_REST, factory, DATABASE_VERSION) {

    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // below is a sqlite query, where column names
        // along with their data types is given
        val query = ("CREATE TABLE " + ROOM_LIST + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                C_NAME + " TEXT," +
                C_mem + " NUMBER" +
                C_Rm + " NUMBER" +
                C_Du + " TEXT" +
                C_Pr + " TEL" +
                ")")

        // we are calling sqlite
        // method for executing our query
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS " + ROOM_LIST)
        onCreate(db)
    }

    // This method is for adding data in our database
    fun addName(name : String, members : Int, Rooms : String, Duration :String, Price : Int ){

        // below we are creating
        // a content values variable
        val values = ContentValues()

        // we are inserting our values
        // in the form of key-value pair
        values.put(C_NAME, name)
        values.put(C_mem, members)
        values.put( C_Rm, Rooms)
        values.put( C_Du, Duration)
        values.put( C_Pr, Price)
        // here we are creating a
        // writable variable of
        // our database as we want to
        // insert value in our database
        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(ROOM_LIST, null, values)

        // at last we are
        // closing our database
        db.close()
    }

    // below method is to get
    // all data from our database
    fun getName(): Cursor? {

        // here we are creating a readable
        // variable of our database
        // as we want to read value from it
        val db = this.readableDatabase

        // below code returns a cursor to
        // read data from the database
        return db.rawQuery("SELECT * FROM " + ROOM_LIST, null)

    }


    companion object{
        // here we have defined variables for our database

        // below is variable for database name
        private val AKSHAYA_REST = "AKSHAYA REST"

        // below is the variable for database version
        private val DATABASE_VERSION = 1

        // below is the variable for table name
        val ROOM_LIST = "roomlist"

        // below is the variable for id column
        val ID_COL = "id"

        // below is the variable for name column
        val C_NAME = "name"
        val C_mem= "members"
        val C_Rm = "Rooms"
        val C_Du = "Duration"
        val C_Pr = "Price"


    }
}
