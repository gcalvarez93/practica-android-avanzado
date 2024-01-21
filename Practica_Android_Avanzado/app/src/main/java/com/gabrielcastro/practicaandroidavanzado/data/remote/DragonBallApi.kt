package com.gabrielcastro.practicaandroidavanzado.data.remote

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface DragonBallApi {
    //Login
    @POST("/api/auth/login")
    suspend fun performLogin(@Header("Authorization") loginData: String): String


    //Retrieve heroes list
    @POST("/api/heros/all")
    suspend fun retrieveHeroes(@Header("Authorization") petitionData: String,
                               @Body getHeroesRequestBody: GetHeroesRequestBody
    ): List<GetHeroesResponse>

    //Update heroe favourite state
    @POST("/api/data/herolike")
    //Header Bearer Token $token
    //Body: Heroe id
    //This petition does not return a value.
    suspend fun updateHeroeFavStateRemote(@Header("Authorization") petitionData: String,
                                          @Body getFavRequestBody: GetFavRequestBody
    )

    //Retrieve heroe locations
    @POST("/api/heros/locations")
    //This call needs a header (token) and a body (hero id)
    suspend fun retrieveHeroeLocations(@Header("Authorization") petitionData: String,
                                       @Body getLocationRequestBody: GetLocationRequestBody
    ): List<GetLocationsResponse>

}