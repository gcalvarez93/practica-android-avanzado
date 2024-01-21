package com.gabrielcastro.practicaandroidavanzado

import com.gabrielcastro.practicaandroidavanzado.data.local.LocalDataSource
import com.gabrielcastro.practicaandroidavanzado.data.mappers.GetHeroesResponseToHeroe
import com.gabrielcastro.practicaandroidavanzado.data.mappers.GetHeroesResponseToLocalHeroe
import com.gabrielcastro.practicaandroidavanzado.data.mappers.GetLocationsResponseToLocations
import com.gabrielcastro.practicaandroidavanzado.data.mappers.LocalHeroeToHeroe
import com.gabrielcastro.practicaandroidavanzado.data.RepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class RepositoryImplTest {


    private lateinit var repositoryImpl: RepositoryImpl
    private lateinit var remoteDataSource: FakeRemoteDataSource

    private lateinit var  localDataSource: LocalDataSource
    private lateinit var getHeroesResponseToHeroe: GetHeroesResponseToHeroe
    private lateinit var localHeroeToHeroe: LocalHeroeToHeroe
    private lateinit var getHeroesResponseToLocalHeroe: GetHeroesResponseToLocalHeroe
    private lateinit var getLocationsResponseToLocations: GetLocationsResponseToLocations

    @Before
    fun setup(){
        remoteDataSource = FakeRemoteDataSource()
        localDataSource = FakeLocalDataSource()
        getHeroesResponseToHeroe = GetHeroesResponseToHeroe()
        localHeroeToHeroe = LocalHeroeToHeroe()
        getHeroesResponseToLocalHeroe = GetHeroesResponseToLocalHeroe()
        getLocationsResponseToLocations = GetLocationsResponseToLocations()
        repositoryImpl = RepositoryImpl(remoteDataSource,
            localDataSource,
            getHeroesResponseToHeroe,
            localHeroeToHeroe,
            getHeroesResponseToLocalHeroe,
            getLocationsResponseToLocations)
    }

    @Test
    fun `(FAKE TEST Generated Token Slow Test)WHEN performLoging EXPECT succesfull response and token generated `() = runTest{
        //  coEvery { remoteDataSource.performLogin("dfgsdf") } returns generateFakeToken()
        val token = remoteDataSource.performLogin("asas")
        assert(token.isNotEmpty())
    }
}