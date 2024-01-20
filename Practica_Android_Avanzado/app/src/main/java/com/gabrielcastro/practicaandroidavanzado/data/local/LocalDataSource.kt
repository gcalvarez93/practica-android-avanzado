package com.gabrielcastro.practicaandroidavanzado.data.local

interface LocalDataSource {

    suspend fun getHeroes(): List<LocalHeroe>

    suspend fun insertHeroes(localHeroes: List<LocalHeroe>)

    suspend fun getHeroe(id: String): LocalHeroe

    suspend fun updateHeroeFavStateLocal(id: String, isFav: Boolean)

}