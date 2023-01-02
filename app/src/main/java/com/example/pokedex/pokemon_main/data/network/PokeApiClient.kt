package com.example.pokedex.pokemon_main.data.network

import com.example.pokedex.pokemon_main.data.network.model.PokemonApi
import com.example.pokedex.pokemon_main.data.network.model.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PokeApiClient  {
    @GET
    suspend fun getPokemon(@Url url:String):Response<PokemonApi>
    @GET
    suspend fun getPokemonList(@Url url: String): Response<PokemonList>
}