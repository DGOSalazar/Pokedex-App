package com.example.pokedex.pokemon_main.data.model.auxModel

import com.google.gson.annotations.SerializedName

data class GameIndices(@SerializedName("game_index") var gameIndex : Int=0,
                       @SerializedName("version") var version: Results)