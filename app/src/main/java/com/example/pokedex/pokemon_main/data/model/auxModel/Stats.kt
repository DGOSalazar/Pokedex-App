package com.example.pokedex.pokemon_main.data.model.auxModel

import com.google.gson.annotations.SerializedName

data class Stats(@SerializedName("base_stat") var baseStat : Int,
                 @SerializedName("effort") var effort : Int,
                 @SerializedName("stat") var stat : Stat)
