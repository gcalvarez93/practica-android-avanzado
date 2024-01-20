package com.gabrielcastro.practicaandroidavanzado.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalHeroe::class], version = 1, exportSchema = false)
abstract class HeroeDatabase : RoomDatabase(){
    abstract fun heroeDao(): HeroeDAO
}