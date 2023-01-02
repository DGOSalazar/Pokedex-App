package com.example.pokedex.pokemon_main.domain

import com.example.pokedex.pokemon_main.data.Repository
import com.example.pokedex.pokemon_main.data.network.model.PokemonList
import com.example.pokedex.pokemon_main.domain.models.PokeList
import javax.inject.Inject

class GetListPokemonUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(n:Int): PokeList = repository.getPokemonList(n)
}