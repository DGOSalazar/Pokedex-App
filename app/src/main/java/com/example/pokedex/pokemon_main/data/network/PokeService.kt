package com.example.pokedex.pokemon_main.data.network



import com.example.pokedex.pokemon_main.data.network.model.PokemonApi
import com.example.pokedex.pokemon_main.data.network.model.PokemonList
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PokeService @Inject constructor(
    private val api:PokeApiClient
    ) {

    suspend fun getPokeListService(n:Int): PokemonList {
        return with(Dispatchers.IO){
            val response = api.getPokemonList("?offset=${n}&limit=898")
            return response.body() ?: PokemonList()
        }
    }
    suspend fun getPokemonByIdService(n:Int): PokemonApi {
        return with(Dispatchers.IO){
            val response = api.getPokemon(n.toString())
            return response.body() ?: PokemonApi()
        }
    }
    suspend fun getPokemonByNameService(name:String): PokemonApi {
        return with(Dispatchers.IO){
                    val response = api.getPokemon(name)
                    return response.body() ?: PokemonApi()
                }
            }
}
