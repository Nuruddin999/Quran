package com.example.quranua.Model.Room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface AyaDAO  {
    @Query("SELECT suraNumber,suraName FROM Ayat")
    fun getsuraNameandNumber():List<Ayat>

}