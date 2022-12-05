package com.example.pokedex.pokemon_main.data.model

import com.example.pokedex.pokemon_main.data.model.auxModel.Results
import com.google.gson.annotations.SerializedName

data class PokemonList(@SerializedName("count") var count : Int,
                       @SerializedName("next") var urlNext : String,
                       @SerializedName("previous") var urlBack : String,
                       @SerializedName("results") var results : List<Results>)