package com.example.pokedex.pokemon_main.domain

import com.example.pokedex.pokemon_main.data.model.Pokemon
import com.example.pokedex.pokemon_main.data.Repository
import javax.inject.Inject

class GetPokemonByIdUseCase @Inject constructor(
    private val repository: Repository
){
    suspend operator fun invoke(n:Int) : Pokemon = repository.getPokemonById(n)
}