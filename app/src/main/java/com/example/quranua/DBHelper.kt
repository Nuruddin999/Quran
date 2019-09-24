package com.example.quranua

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.quranua.Model.Sura
import java.text.FieldPosition

val DBNAME = "Quran"
val TABLE_NAME = "Bookmarks"
val COL_IND = "SuraIndex"
val COL_SURA = "Sura"
val COL_AYANUM = "Number"
val COL_AYAUKR = "ukr"
val COL_AYAARAB = "arab"

class DBHelper(var context: Context) : SQLiteOpenHelper(context, DBNAME, null, 1) {
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createtable =
            "CREATE TABLE $TABLE_NAME ($COL_IND INTEGER, $COL_SURA VARCHAR (300), $COL_AYANUM INTEGER, $COL_AYAUKR VARCHAR(300), $COL_AYAARAB VARCHAR (300))"
        db?.execSQL(createtable)
    }

    fun inserdata(sura: Sura, position: Int) {
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_IND, sura.suraindex)
        cv.put(COL_SURA, sura.suraname)
        cv.put(COL_AYANUM, sura.verses!![position].ayaindex)
        cv.put(COL_AYAARAB, sura.verses!![position].ayaarab)
        cv.put(COL_AYAUKR, sura.verses!![position].ayaukr)
        var result = db.insert(TABLE_NAME, null, cv)
        if (result == -1.toLong()) {
            Toast.makeText(context, "добавлено", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "неудачно", Toast.LENGTH_LONG).show()
        }
    }

    fun readdata(position: Int): ArrayList<Sura> {
        var db = this.writableDatabase
        var list = ArrayList<Sura>()
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                var sura = Sura(null, null, null, null, null)
                sura.suraindex = result.getInt(result.getColumnIndex(COL_IND))
                sura.suraname = result.getString(result.getColumnIndex(COL_SURA))
                sura.verses!![position].ayaarab = result.getString(result.getColumnIndex(COL_AYAARAB))
                sura.verses!![position].ayaukr = result.getString(result.getColumnIndex(COL_AYAUKR))
                sura.verses!![position].ayaindex = result.getString(result.getColumnIndex(COL_AYANUM))
                list.add(sura)
            } while (result.moveToNext())
        }
        result.close()
        return list

    }

}
