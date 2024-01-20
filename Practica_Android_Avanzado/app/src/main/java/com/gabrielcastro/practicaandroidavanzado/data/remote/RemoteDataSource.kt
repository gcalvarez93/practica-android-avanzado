package com.gabrielcastro.practicaandroidavanzado.data.remote

import com.gabrielcastro.practicaandroidavanzado.data.remote.GetHeroesResponse
import com.gabrielcastro.practicaandroidavanzado.data.remote.GetLocationsResponse

interface RemoteDataSource {
    suspend fun performLogin(loginData:String): String

    suspend fun getHeroes(): List<GetHeroesResponse>

    suspend fun updateHeroeFavStateRemote(id:String, isFav: Boolean)

    suspend fun retrieveHeroeLocations(id: String): List<GetLocationsResponse>

}