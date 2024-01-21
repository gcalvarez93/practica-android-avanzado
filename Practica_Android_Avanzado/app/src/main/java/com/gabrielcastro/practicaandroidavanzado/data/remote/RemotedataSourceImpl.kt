package com.gabrielcastro.practicaandroidavanzado.data.remote


import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(
    private val api: DragonBallApi
) : RemoteDataSource {
    //The token is set to public to facilitate testing.
    lateinit var token: String

    override suspend fun performLogin(loginData:String): String{
        this.token = api.performLogin(loginData)
        return token
    }

    override suspend fun getHeroes(): List<GetHeroesResponse>{
        token.let {
            if(token.isNotEmpty()){
                val requestData = "Bearer $token"
                return api.retrieveHeroes(requestData, GetHeroesRequestBody())
            } else{
                return mutableListOf()
            }
        }
        return mutableListOf()
    }

    override suspend fun updateHeroeFavStateRemote(id: String, isFav: Boolean) {
        token.let {
            if(token.isNotEmpty()){
                val requestData = "Bearer $token"
                api.updateHeroeFavStateRemote(requestData, GetFavRequestBody(id))

            }
        }
    }

    override suspend fun retrieveHeroeLocations(id: String): List<GetLocationsResponse> {

        token.let {
            if(token.isNotEmpty()){
                val requestData = "Bearer $token"
                return api.retrieveHeroeLocations(requestData, GetLocationRequestBody(id))
            }
        }
        return mutableListOf()
    }

}