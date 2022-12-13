package com.example.pokedex.pokemon_main.data

import com.example.pokedex.pokemon_main.data.database.dao.QueryPokemon
import com.example.pokedex.pokemon_main.data.database.entities.QuotePokemon
import com.example.pokedex.pokemon_main.data.model.Pokemon
import com.example.pokedex.pokemon_main.data.model.PokemonList
import com.example.pokedex.pokemon_main.data.network.PokeService
import javax.inject.Inject

class Repository @Inject constructor(
    private val api : PokeService,
    private val dao : QueryPokemon
){
    suspend fun getPokemonList(n:Int): PokemonList {
        return api.getPokeListService(n)
    }
    suspend fun getPokemonById(n:Int): Pokemon {
        return api.getPokemonByIdService(n)
    }
    suspend fun getPokemonByName(name: String): Pokemon {
        return api.getPokemonByNameService(name)
    }
    suspend fun getPokemonFavAll():List<QuotePokemon>{
        return dao.getMyTeam()
    }
    suspend fun insertPokemonFav(quotePokemon: QuotePokemon){
        dao.setMyTeam(quotePokemon)
    }
}