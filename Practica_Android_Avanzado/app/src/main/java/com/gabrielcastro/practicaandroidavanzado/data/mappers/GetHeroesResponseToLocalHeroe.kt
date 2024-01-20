package com.gabrielcastro.practicaandroidavanzado.data.mappers

import com.gabrielcastro.practicaandroidavanzado.data.local.LocalHeroe
import com.gabrielcastro.practicaandroidavanzado.data.remote.GetHeroesResponse
import javax.inject.Inject

class GetHeroesResponseToLocalHeroe @Inject constructor() {
    fun mapFromGetHeroesResponsesToLocalHeroes(getHeroeResponseList: List<GetHeroesResponse>) : List<LocalHeroe>{
        return getHeroeResponseList.map {mapFromGetHeroeResponseToLocalHeroe(it)}
    }

    private  fun mapFromGetHeroeResponseToLocalHeroe(getHeroeResponse: GetHeroesResponse): LocalHeroe {
        return LocalHeroe(getHeroeResponse.id,getHeroeResponse.name,getHeroeResponse.photo, getHeroeResponse.description,getHeroeResponse.favorite)
    }
}