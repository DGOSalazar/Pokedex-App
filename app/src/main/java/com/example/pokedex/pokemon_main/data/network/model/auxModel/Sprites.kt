package com.example.pokedex.pokemon_main.data.network.model.auxModel

import com.google.gson.annotations.SerializedName

data class Sprites (@SerializedName("front_default")var frontImg: String,
                    @SerializedName("back_default")var backImg: String,
                    @SerializedName("front_shiny")var shinyImg:String)