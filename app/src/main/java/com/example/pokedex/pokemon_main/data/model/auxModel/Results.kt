package com.example.pokedex.pokemon_main.data.model.auxModel

import com.google.gson.annotations.SerializedName

data class Results (@SerializedName("name") var name : String="",
                    @SerializedName("url") var url : String="")