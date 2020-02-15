package com.example.quranua.Model.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nameNumber_table")
data class NameAndNumberForIndex (
    @PrimaryKey  @ColumnInfo(name = "suraNumber") val suraNumber: Int?,
    @ColumnInfo(name = "suraName") val suraName: String?
    )