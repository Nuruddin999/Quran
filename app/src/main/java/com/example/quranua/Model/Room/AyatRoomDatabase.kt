package com.example.quranua.Model.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Ayat::class, NameAndNumberForIndex::class), version = 1)
public abstract class AyatRoomDatabase : RoomDatabase() {
    abstract fun AyatDAO(): AyatDAO
    abstract fun nameAndIndexDAO(): NameAndNumberForIndexDAO

    companion object {
        @Volatile
        private var INSTANCE: AyatRoomDatabase? = null

        fun getDatabase(context: Context): AyatRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AyatRoomDatabase::class.java,
                    "aya_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}