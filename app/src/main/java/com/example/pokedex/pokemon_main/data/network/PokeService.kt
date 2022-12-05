package com.example.pokedex.pokemon_main.data.network

import com.example.pokedex.pokemon_main.data.Pokemon
import com.example.pokedex.pokemon_main.data.model.PokemonList
import com.example.pokedex.pokemon_main.data.model.cacheData.PokemonCache
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PokeService @Inject constructor(
    private val api:PokeApiClient
    ) {

    //suspend fun getPokeListService(): PokemonList{
    //    return with(Dispatchers.IO){
    //        val response = api.getPokemonList()
    //        return response.body() ?: PokemonCache.pokemonList
    //    }
    //}
    suspend fun getPokemonByIdService(id:Int): Pokemon{
        return with(Dispatchers.IO){
            val response = api.getPokemon(id.toString())
            return response.body() ?: PokemonCache.pokemon
        }
    }
    suspend fun getPokemonByNameService(name:String): Pokemon{
        return with(Dispatchers.IO){
            val response = api.getPokemon(name)
            return response.body() ?: PokemonCache.pokemon
        }
    }
}