package com.example.pokedex.pokemon_main.domain.models

import com.example.pokedex.pokemon_main.data.network.model.PokemonList
import com.example.pokedex.pokemon_main.data.network.model.auxModel.Results

data class PokeList (var count : Int = 0,
                     var urlNext : String = "",
                     var urlBack : String ="",
                     var results: List<Results> = listOf())
fun PokemonList.toDomain()=
    PokeList(count=count,urlNext=urlNext ?: "",urlBack=urlBack ?: "",results=results)

