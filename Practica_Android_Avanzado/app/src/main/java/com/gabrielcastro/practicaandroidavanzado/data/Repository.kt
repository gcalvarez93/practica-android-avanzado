package com.gabrielcastro.practicaandroidavanzado.data

import com.gabrielcastro.practicaandroidavanzado.ui.mainactivity.model.Location
import com.gabrielcastro.practicaandroidavanzado.ui.mainactivity.model.Heroe

interface Repository {
    suspend fun performLogin(loginData: String): String
    suspend fun getHeroes(): List<Heroe>

    suspend fun  getHeroe(id:String): Heroe

    suspend fun  updateHeroeFavStateLocalAndRemote(id: String, isFav:Boolean)

    suspend fun retrieveHeroeLocations(id: String): List<Location>
}