package com.example.pokedex.pokemon_main.domain

import com.example.pokedex.pokemon_main.data.Repository
import com.example.pokedex.pokemon_main.data.model.PokemonList
import javax.inject.Inject

class GetListPokemonUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(n:Int): PokemonList = repository.getPokemonList(n)
}