package com.example.pokedex.pokemon_main.data.network



import com.example.pokedex.pokemon_main.data.model.Pokemon
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