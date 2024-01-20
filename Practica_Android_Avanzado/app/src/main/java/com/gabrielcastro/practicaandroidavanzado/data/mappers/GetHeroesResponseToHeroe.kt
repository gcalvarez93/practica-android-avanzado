package com.gabrielcastro.practicaandroidavanzado.data.mappers

import com.gabrielcastro.practicaandroidavanzado.data.remote.GetHeroesResponse
import com.gabrielcastro.practicaandroidavanzado.ui.mainactivity.model.Heroe
import javax.inject.Inject

class GetHeroesResponseToHeroe @Inject constructor() {
    fun mapFromGetHeroesResponsesToHeroes(getHeroeResponseList: List<GetHeroesResponse>) : List<Heroe>{
        return getHeroeResponseList.map {mapFromGetHeroeResponseToHeroe(it)}
    }

    private  fun mapFromGetHeroeResponseToHeroe(getHeroeResponse: GetHeroesResponse): Heroe {
        return Heroe(getHeroeResponse.id,getHeroeResponse.name,getHeroeResponse.photo, getHeroeResponse.description,getHeroeResponse.favorite)
    }
}