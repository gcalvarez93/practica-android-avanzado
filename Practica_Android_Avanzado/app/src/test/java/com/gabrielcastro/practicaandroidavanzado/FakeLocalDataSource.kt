package com.gabrielcastro.practicaandroidavanzado

import com.gabrielcastro.practicaandroidavanzado.data.local.LocalDataSource
import com.gabrielcastro.practicaandroidavanzado.data.local.LocalHeroe

class FakeLocalDataSource: LocalDataSource {
    //Not used. Needed for the repository
    override suspend fun getHeroes(): List<LocalHeroe> {
        TODO("Not yet implemented")
    }

    override suspend fun insertHeroes(localHeroes: List<LocalHeroe>) {
        TODO("Not yet implemented")
    }

    override suspend fun getHeroe(id: String): LocalHeroe {
        TODO("Not yet implemented")
    }

    override suspend fun updateHeroeFavStateLocal(id: String, isFav: Boolean) {
        TODO("Not yet implemented")
    }
}