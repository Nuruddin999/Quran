package com.example.quranua

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.quranua.Model.Bookmark

val DBNAME = "Quran"
val TABLE_NAME = "Bookmarks"
val COL_IND = "SuraIndex"
val COL_SURNUM="SuraNumber"
val COL_TRANS = "Translation"
val COL_SURA = "Sura"
val COL_AYANUM = "Number"
val COL_AYAUKR = "ukr"
val COL_AYAARAB = "arab"
val COL_LOVED="loved"
class Database (var context: Context) : SQLiteOpenHelper(context, DBNAME, null, 3){
    override fun onCreate(db: SQLiteDatabase?) {
        val createtable =
            "CREATE TABLE $TABLE_NAME ($COL_IND INTEGER, $COL_SURNUM , $COL_SURA VARCHAR (300),  $COL_TRANS VARCHAR (300),$COL_AYANUM INTEGER, $COL_AYAUKR VARCHAR(300), $COL_AYAARAB VARCHAR (300), $COL_LOVED VARCHAR (300))"
        db?.execSQL(createtable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
    fun inserdata(suraname: String, suraindex:Int,suraNumber:Int,translation: String, ayanumber: Int, ukr: String, arab: String, loved:String) {
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_SURA, suraname)
        cv.put(COL_IND, suraindex)
        cv.put(COL_SURNUM,suraNumber)
        cv.put(COL_TRANS, translation)
        cv.put(COL_AYANUM, ayanumber)
        cv.put(COL_AYAARAB, arab)
        cv.put(COL_AYAUKR, ukr)
        cv.put(COL_LOVED,loved)
        var result = db.insert(TABLE_NAME, null, cv)
        if (result == -1.toLong()) {
            Toast.makeText(context, "неудачно", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "добавлено", Toast.LENGTH_LONG).show()
        }
    }
    fun readdata(loved: String): ArrayList<Bookmark>
    {
        var no="no"
        var db = this.writableDatabase
        var list = ArrayList<Bookmark>()


        val result = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COL_LOVED = ? ", arrayOf(loved))
        if (result.moveToFirst()) {

            do {
                var bookmark = Bookmark()
                bookmark.ayanumber = result.getString(result.getColumnIndex(COL_AYANUM))
                bookmark.suraIndex = result.getInt(result.getColumnIndex(COL_IND))
                bookmark.suraNumber=result.getInt(result.getColumnIndex(COL_SURNUM))
                bookmark.translation=result.getString(result.getColumnIndex(COL_TRANS))
                bookmark.suraname = result.getString(result.getColumnIndex(COL_SURA))
                bookmark.arab = result.getString(result.getColumnIndex(COL_AYAARAB))
                bookmark.ukr = result.getString(result.getColumnIndex(COL_AYAUKR))
                bookmark.loved= result.getString(result.getColumnIndex(COL_LOVED))
                list.add(bookmark)

            } while (result.moveToNext())

        }
        result.close()
        return list

    }
    fun deleteData(index: Int,loved: String,ayatukr:String) {
        val db = this.writableDatabase
        val query = "delete  from $TABLE_NAME where $COL_IND='$index' and $COL_LOVED='$loved'  and $COL_AYAUKR='$ayatukr'"
        val result = db.execSQL(query)
    }

    fun deleteAll() {
        val db = this.writableDatabase
        val query = "delete  from " + TABLE_NAME
        db.execSQL(query)

    }

}