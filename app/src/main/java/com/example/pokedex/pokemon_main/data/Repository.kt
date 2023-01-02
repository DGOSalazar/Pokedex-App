package com.example.pokedex.pokemon_main.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.pokedex.pokemon_main.data.database.dao.QueryPokemon
import com.example.pokedex.pokemon_main.data.database.entities.QuotePokemon
import com.example.pokedex.pokemon_main.data.database.entities.toDomain
import com.example.pokedex.pokemon_main.data.network.model.PokemonApi
import com.example.pokedex.pokemon_main.data.network.model.PokemonList
import com.example.pokedex.pokemon_main.data.network.PokeService
import com.example.pokedex.pokemon_main.domain.models.PokeFav
import com.example.pokedex.pokemon_main.domain.models.PokeList
import com.example.pokedex.pokemon_main.domain.models.Pokemon
import com.example.pokedex.pokemon_main.domain.models.toDomain
import javax.inject.Inject

class Repository @Inject constructor(
    private val api : PokeService,
    private val dao : QueryPokemon
){
    suspend fun getPokemonList(n:Int): PokeList {
        val response = api.getPokeListService(n)
        return response.toDomain()
    }
    suspend fun getPokemonById(n:Int): Pokemon {
        val response= api.getPokemonByIdService(n)
        return response.toDomain()
    }
    suspend fun getPokemonByName(name: String): Pokemon {
        val response=api.getPokemonByNameService(name)
        return response.toDomain()
    }
    suspend fun getPokemonFav():List<PokeFav>{
        val response = dao.getMyTeam()
        return response.map { it.toDomain() }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun insertPokemonFav(pokemon: Pokemon){
        dao.setMyTeam(pokemon.toDomain())
    }
    suspend fun deletePokemon(id:Long){
        dao.deletePokemon(id.toInt())
    }
    suspend fun changePokeName(id: Long,name: String){
        dao.changePokeName(id.toInt(),name)
    }
}