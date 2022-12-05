package com.example.pokedex.pokemon_main.data

import com.example.pokedex.pokemon_main.data.model.PokemonList
import com.example.pokedex.pokemon_main.data.model.cacheData.PokemonCache
import com.example.pokedex.pokemon_main.data.network.PokeService
import javax.inject.Inject

class Repository @Inject constructor(
    private val api : PokeService
){
    //suspend fun getPokemonList(): PokemonList{
    //    var response = api.getPokeListService()
    //    PokemonCache.pokemonList=response
    //    return response
    //}
    suspend fun getPokemonById(id : Int): Pokemon{
        var response = api.getPokemonByIdService(id)
        PokemonCache.pokemon = response
        return response
    }
    suspend fun getPokemonByName(name:String): Pokemon{
        var response = api.getPokemonByNameService(name)
        PokemonCache.pokemon = response
        return response
    }
}