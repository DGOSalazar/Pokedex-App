package com.example.pokedex.pokemon_main.data.network.model.auxModel

import com.google.gson.annotations.SerializedName

data class Results (@SerializedName("name") var name : String="",
                    @SerializedName("url") var url : String="")