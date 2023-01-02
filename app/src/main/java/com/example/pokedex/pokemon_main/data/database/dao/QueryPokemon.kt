package com.example.pokedex.pokemon_main.data.database.dao

import androidx.room.*
import com.example.pokedex.pokemon_main.data.database.entities.QuotePokemon

@Dao
interface QueryPokemon {
    @Query("Select * from quotePokemon_table LIMIT 8")
    suspend fun getMyTeam(): List<QuotePokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setMyTeam(pokemonFav: QuotePokemon)

    @Query("Delete from quotePokemon_table WHERE id = '0'+:id")
    suspend fun deletePokemon(id: Int)

    @Query("Update quotePokemon_table set name=:name where id=:id")
    suspend fun changePokeName(id:Int, name:String)
}