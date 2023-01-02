package com.example.pokedex.pokemon_main.data.network.model.auxModel

import com.google.gson.annotations.SerializedName

data class Stats(@SerializedName("base_stat") var baseStat : Int=0,
                 @SerializedName("effort") var effort : Int=0,
                 @SerializedName("stat") var stat : Stat
)
