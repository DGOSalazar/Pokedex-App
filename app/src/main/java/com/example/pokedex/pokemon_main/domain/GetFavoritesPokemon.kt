package com.example.pokedex.pokemon_main.domain

import com.example.pokedex.pokemon_main.data.Repository
import com.example.pokedex.pokemon_main.domain.models.PokeFav
import javax.inject.Inject

class GetFavoritesPokemon @Inject constructor(
    val repository: Repository
) {
    suspend operator fun invoke():List<PokeFav> = repository.getPokemonFav()
}