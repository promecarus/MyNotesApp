package com.promecarus.mynotesapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.promecarus.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DATE
import com.promecarus.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DESCRIPTION
import com.promecarus.mynotesapp.db.DatabaseContract.NoteColumns.Companion.TABLE_NAME
import com.promecarus.mynotesapp.db.DatabaseContract.NoteColumns.Companion.TITLE
import com.promecarus.mynotesapp.db.DatabaseContract.NoteColumns.Companion._ID

internal class DatabaseContract {
    internal class NoteColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "note"
            const val _ID = "_id"
            const val TITLE = "title"
            const val DESCRIPTION = "description"
            const val DATE = "date"
        }
    }
}

internal class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "dbnoteapp"
        private const val DATABASE_VERSION = 1
        private const val SQL_CREATE_TABLE_NOTE = "CREATE TABLE $TABLE_NAME" +
                "($_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$TITLE TEXT NOT NULL," +
                "$DESCRIPTION TEXT NOT NULL," +
                "$DATE TEXT NOT NULL)"

    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_NOTE)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}
