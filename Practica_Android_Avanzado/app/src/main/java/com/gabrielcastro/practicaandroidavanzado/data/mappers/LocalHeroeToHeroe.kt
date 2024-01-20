package com.gabrielcastro.practicaandroidavanzado.data.mappers

import com.gabrielcastro.practicaandroidavanzado.data.local.LocalHeroe
import com.gabrielcastro.practicaandroidavanzado.ui.mainactivity.model.Heroe
import javax.inject.Inject

class LocalHeroeToHeroe @Inject constructor() {
    fun mapFromLocalHeroesToHeroes(getLocalHeroeList: List<LocalHeroe>) : List<Heroe>{
        return getLocalHeroeList.map {mapFromLocalHeroeToHeroe(it)}
    }

    fun mapFromLocalHeroeToHeroe(getLocalHeroe: LocalHeroe): Heroe {
        return Heroe(getLocalHeroe.id,getLocalHeroe.name,getLocalHeroe.photo, getLocalHeroe.description,getLocalHeroe.favorite)
    }

}