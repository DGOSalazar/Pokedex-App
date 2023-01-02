package com.example.pokedex.pokemon_main.data.network.model

import com.example.pokedex.pokemon_main.data.network.model.auxModel.Results
import com.example.pokedex.pokemon_main.domain.models.PokeList
import com.google.gson.annotations.SerializedName

data class PokemonList(@SerializedName("count") var count : Int = 0,
                       @SerializedName("next") var urlNext : String = "",
                       @SerializedName("previous") var urlBack : String ="",
                       @SerializedName("results") var results: List<Results> = listOf(
                           Results(name = "pichu", url = "www.google.com"),
                           Results(name = "pichu", url = "www.google.com"),
                           Results(name = "pichu", url = "www.google.com")
                       ))
fun PokeList.toDomain() = PokemonList(count=count,urlNext=urlNext,urlBack=urlBack,results=results)
