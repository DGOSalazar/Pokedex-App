package com.example.pokedex.pokemon_main.data.network.model.auxModel

import com.google.gson.annotations.SerializedName

data class Types(@SerializedName("slot")var slot:Int=0,
                 @SerializedName("type")var type: Results
)