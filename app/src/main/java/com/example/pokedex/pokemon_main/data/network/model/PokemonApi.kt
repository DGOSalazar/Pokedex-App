package com.example.pokedex.pokemon_main.data.network.model

import com.example.pokedex.pokemon_main.data.network.model.auxModel.*
import com.google.gson.annotations.SerializedName

data class PokemonApi(@SerializedName("height") var height : Int=34,
                      @SerializedName("id") var id : Int=1,
                      @SerializedName("is_default") var isDefault : Boolean=false,
                      @SerializedName("location_area_encounters") var locationArea : String="",
                      @SerializedName("name") var name : String="",
                      @SerializedName("order") var order: Int=0,
                      @SerializedName("species") var species : Results = Results(),
                      @SerializedName("sprites") var sprites: Sprites = Sprites(
                       frontImg = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
                       backImg = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
                       shinyImg = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png"),
                      @SerializedName("stats") var  stats: List<Stats> =
                       listOf(
                           Stats(baseStat = 30, effort = 0, Stat(name="Attack",url="")),
                           Stats(baseStat = 25, effort = 0,Stat(name="Defense",url="")),
                           Stats(baseStat = 12, effort = 0,Stat(name="Speed",url="")),
                           Stats(baseStat = 98, effort = 0,Stat(name="Special Attack",url=""))
                       ),
                      @SerializedName("types") var types : List<Types> = listOf
                          (Types(slot = 1,Results(name="fire", url = ""))),
                      @SerializedName("weight") var weight : Int=21)
