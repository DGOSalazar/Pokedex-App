package com.example.pokedex.pokemon_main.data.model.cacheData

import com.example.pokedex.pokemon_main.data.Pokemon
import com.example.pokedex.pokemon_main.data.model.PokemonList
import com.example.pokedex.pokemon_main.data.model.auxModel.Results
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class PokemonCache @Inject constructor() {
    companion object{
         var pokemon = Pokemon(name = "", abilities = listOf(), baseExperience = 0, forms = listOf(), gameIndices = listOf(), height = 0, heldItems = listOf(), id = 0, isDefault = true, locationArea = "", moves = listOf(), order =0, pastTypes = listOf(), species = listOf(), sprites = listOf(), stats = listOf(), types = listOf(), weight = 0)
         var pokemonList = PokemonList(count = 0, urlNext = "", urlBack = "", results = listOf())
    }
}