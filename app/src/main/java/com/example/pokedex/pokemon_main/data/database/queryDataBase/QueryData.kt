package com.example.pokedex.pokemon_main.data.database.queryDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedex.pokemon_main.data.database.dao.QueryPokemon
import com.example.pokedex.pokemon_main.data.database.entities.QuotePokemon

@Database(entities = [QuotePokemon::class], version = 1)
abstract class QueryData: RoomDatabase() {
    abstract fun getDao():QueryPokemon
}