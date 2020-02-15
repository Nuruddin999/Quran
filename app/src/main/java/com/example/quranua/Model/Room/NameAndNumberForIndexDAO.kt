package com.example.quranua.Model.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NameAndNumberForIndexDAO {


    @Query("SELECT * FROM nameNumber_table")
    fun getNameAndIndex(): List<NameAndNumberForIndex>

    @Insert
    fun insertAll(vararg: NameAndNumberForIndex)


}
