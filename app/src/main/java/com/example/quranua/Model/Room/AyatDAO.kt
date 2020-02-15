package com.example.quranua.Model.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AyatDAO {
    @Query("SELECT suraNumber,suraName FROM ayat_table")
    fun getsuraNameandNumber(): List<Ayat>

    @Insert
    fun insertAll(vararg ayat: Ayat)
}