package com.gabrielcastro.practicaandroidavanzado.di

import com.gabrielcastro.practicaandroidavanzado.data.local.LocalDataSource
import com.gabrielcastro.practicaandroidavanzado.data.local.LocalDataSourceImpl
import com.gabrielcastro.practicaandroidavanzado.data.remote.RemoteDataSource
import com.gabrielcastro.practicaandroidavanzado.data.remote.RemoteDataSourceImpl
import com.gabrielcastro.practicaandroidavanzado.data.Repository
import com.gabrielcastro.practicaandroidavanzado.data.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract  fun bindsRepository(repositoryImpl: RepositoryImpl): Repository


    @Binds
    abstract fun bindsLocalDataSource(localdataSource: LocalDataSourceImpl): LocalDataSource


    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}