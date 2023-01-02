package com.example.pokedex.pokemon_main.domain.models

import com.example.pokedex.pokemon_main.data.database.entities.QuotePokemon

data class PokeFav(var id : Long=0,
                   var pokemonNumber:Int=0,
                   var name: String="",
                   var date: String="",
                   var img: String="")
fun QuotePokemon.toDomain() =
    PokeFav(id=id, pokemonNumber = pokemonNumber,name=name,date=date,img=img)

