package com.example.pokedex.pokemon_main.data.network



import com.example.pokedex.pokemon_main.data.model.Pokemon
import com.example.pokedex.pokemon_main.data.model.PokemonList
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PokeService @Inject constructor(
    private val api:PokeApiClient
    ) {

    suspend fun getPokeListService(n:Int): PokemonList {
        return with(Dispatchers.IO){
            val response = api.getPokemonList("?offset=${n}&limit=20")
            return response.body() ?: PokemonList()
        }
    }
    suspend fun getPokemonByIdService(n:Int): Pokemon {
        return with(Dispatchers.IO){
            val response = api.getPokemon(n.toString())
            return response.body() ?: Pokemon()
        }
    }
    //suspend fun getPokemonByNameService(name:String): Pokemon{
    //    return with(Dispatchers.IO){
    //        val response = api.getPokemon(name)
    //        return response.body() ?: PokemonCache.pokemon
    //    }
    //}
}