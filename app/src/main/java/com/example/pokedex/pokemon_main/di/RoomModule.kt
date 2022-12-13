package com.example.pokedex.pokemon_main.di

import android.content.Context
import androidx.room.Room
import com.example.pokedex.pokemon_main.data.database.queryDataBase.QueryData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)
    = Room.databaseBuilder(context,QueryData::class.java,"PokemonDatabase").build()
    @Singleton
    @Provides
    fun provideQueries(database: QueryData) = database.getDao()
}
