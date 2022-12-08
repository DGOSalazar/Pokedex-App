package com.example.pokedex.pokemon_main.data.model.auxModel

import com.google.gson.annotations.SerializedName

data class Abilities(@SerializedName("ability") var ability: Ability,
                     @SerializedName("is_hidden") var isHidden: Boolean=false,
                     @SerializedName("slot") var slot: Int=0)
data class Ability(@SerializedName("name") var name:String="",
                   @SerializedName("url") var url : String="")