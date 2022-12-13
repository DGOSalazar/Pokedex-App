package com.example.pokedex.pokemon_main.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.pokemon_main.data.database.entities.QuotePokemon
import com.example.pokedex.pokemon_main.data.model.PokemonFav

@Dao
interface QueryPokemon {
    @Query("Select * from quotePokemon_table")
    suspend fun getMyTeam(): List<QuotePokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setMyTeam(pokemonFav: QuotePokemon)

    @Delete
    suspend fun deleteMyAllTeam(pokemonFavs: List<QuotePokemon>)

    @Delete
    suspend fun deleteOneOfMyTeam(pokemonFav: QuotePokemon)
}