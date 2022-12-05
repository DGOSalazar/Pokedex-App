package com.example.pokedex.pokemon_main.data

import com.example.pokedex.pokemon_main.data.model.auxModel.Stats
import com.google.gson.annotations.SerializedName

data class Pokemon(@SerializedName("abilities") var abilities: List<String>,
                   @SerializedName("base_experience") var baseExperience : Int,
                   @SerializedName("forms") var forms : List<String>,
                   @SerializedName("game_indices") var gameIndices : List<String>,
                   @SerializedName("height") var height : Int,
                   @SerializedName("held_items") var heldItems : List<String>,
                   @SerializedName("id") var id : Int,
                   @SerializedName("is_default") var isDefault : Boolean,
                   @SerializedName("location_area_encounters") var locationArea : String,
                   @SerializedName("moves") var moves : List<String>,
                   @SerializedName("name") var name : String,
                   @SerializedName("order") var order: Int,
                   @SerializedName("past_types") var pastTypes : List<String>,
                   @SerializedName("species") var species : List<String>,
                   @SerializedName("sprites") var sprites : List<String>,
                   @SerializedName("stats") var stats: List<Stats>,
                   @SerializedName("types") var types : List<String>,
                   @SerializedName("weight") var weight : Int)
