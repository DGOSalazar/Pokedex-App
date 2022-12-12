package com.example.pokedex.pokemon_main.data

import com.example.pokedex.pokemon_main.data.model.Pokemon
import com.example.pokedex.pokemon_main.data.model.PokemonList
import com.example.pokedex.pokemon_main.data.network.PokeService
import javax.inject.Inject

class Repository @Inject constructor(
    private val api : PokeService
){
    suspend fun getPokemonList(n:Int): PokemonList {
        return api.getPokeListService(n)
    }
    suspend fun getPokemonById(n:Int): Pokemon {
        return api.getPokemonByIdService(n)
    }
    //suspend fun getPokemonByName(name:String): Pokemon{
    //    var response = api.getPokemonByNameService(name)
    //    PokemonCache.pokemon = response
    //    return response
    //}
}