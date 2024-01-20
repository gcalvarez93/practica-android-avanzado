package com.gabrielcastro.practicaandroidavanzado.di

import android.content.Context
import androidx.room.Room
import com.gabrielcastro.practicaandroidavanzado.data.local.HeroeDAO
import com.gabrielcastro.practicaandroidavanzado.data.local.HeroeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun privideHeroeDatabase(@ApplicationContext context: Context): HeroeDatabase {
        return Room.databaseBuilder(
            context,
            HeroeDatabase::class.java, "heroe-db"
        ).build()
    }

    @Provides
    fun provideDAO(db: HeroeDatabase): HeroeDAO {
        return db.heroeDao()
    }

}