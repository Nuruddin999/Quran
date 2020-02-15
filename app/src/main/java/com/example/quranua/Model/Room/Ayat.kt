package com.example.quranua.Model.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ayat_table")
data class Ayat(
    @PrimaryKey  @ColumnInfo(name = "suraNumber") val suraNumber: Int?,
    @ColumnInfo(name = "suraName") val suraName: String?,
    @ColumnInfo(name = "suraTranslation") val suraTranslation: String?,
    @ColumnInfo(name = "suraCount") val suraCount: String?,
    @ColumnInfo(name = "ayaNumber") val ayaNumber: Int?,
    @ColumnInfo(name = "ayaUkr") val ayaUkr: String?,
    @ColumnInfo(name = "ayaArabic") val ayaArabic: String?
)