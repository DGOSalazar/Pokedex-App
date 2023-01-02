package com.example.pokedex.pokemon_main.domain

import com.example.pokedex.pokemon_main.data.Repository
import javax.inject.Inject

class GetFreePokemonUseCase @Inject constructor(
    val repository: Repository
) {
    suspend operator fun invoke(id:Long) = repository.deletePokemon(id)
}