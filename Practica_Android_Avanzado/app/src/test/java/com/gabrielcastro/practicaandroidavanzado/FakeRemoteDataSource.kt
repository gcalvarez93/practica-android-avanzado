package com.gabrielcastro.practicaandroidavanzado

import com.gabrielcastro.practicaandroidavanzado.data.remote.GetHeroesResponse
import com.gabrielcastro.practicaandroidavanzado.data.remote.GetLocationsResponse
import com.gabrielcastro.practicaandroidavanzado.data.remote.RemoteDataSource


class FakeRemoteDataSource: RemoteDataSource {
    override suspend fun performLogin(loginData: String): String {
        return generateFakeToken()
    }

    override suspend fun getHeroes(): List<GetHeroesResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun updateHeroeFavStateRemote(id: String, isFav: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun retrieveHeroeLocations(id: String): List<GetLocationsResponse> {
        TODO("Not yet implemented")
    }

}