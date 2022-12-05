package com.example.pokedex.pokemon_main.data.network

import com.example.pokedex.pokemon_main.data.Pokemon
import com.example.pokedex.pokemon_main.data.model.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PokeApiClient  {
    @GET
    suspend fun getPokemon(@Url url:String): Response<Pokemon>
    //@GET
    //suspend fun getPokemonList(): Response<PokemonList>
}