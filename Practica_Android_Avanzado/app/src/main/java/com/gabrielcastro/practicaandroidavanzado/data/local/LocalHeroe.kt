package com.gabrielcastro.practicaandroidavanzado.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
data class LocalHeroe(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photo") val photo: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "favorite") val favorite: Boolean,
)