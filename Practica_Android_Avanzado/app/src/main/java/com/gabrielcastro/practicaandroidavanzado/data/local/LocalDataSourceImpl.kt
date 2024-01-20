package com.gabrielcastro.practicaandroidavanzado.data.local

import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: HeroeDAO): LocalDataSource {
    override suspend fun getHeroes(): List<LocalHeroe> {
        return dao.getAll()
    }

    override suspend fun insertHeroes(localHeroes: List<LocalHeroe>) {
        dao.insertAllHeroes(localHeroes)
    }

    override suspend fun getHeroe(id: String): LocalHeroe {
        return dao.getHeroe(id)
    }

    override suspend fun updateHeroeFavStateLocal(id: String, isFav: Boolean) {
        dao.updateHeroeFavStateLocal(id,isFav)
    }

}