package com.example.pokedex.pokemon_main.domain.models

import com.example.pokedex.pokemon_main.data.network.model.PokemonApi
import com.example.pokedex.pokemon_main.data.network.model.auxModel.Stats
import com.example.pokedex.pokemon_main.data.network.model.auxModel.Types

data class Pokemon(var name: String="",
                   var id:Int=0,
                   var imgFront:String="",
                   var imgBack:String="",
                   var imgShiny:String="",
                   var types : List<Types> = listOf(),
                   var stats : List<Stats> = listOf(),
                   var height: Int=0,
                   var weight: Int=0)

fun PokemonApi.toDomain()=
    Pokemon(name=name ,id=id, imgFront =sprites.frontImg, imgBack = sprites.backImg, imgShiny = sprites.shinyImg ,types,stats, height=height,weight=weight)
