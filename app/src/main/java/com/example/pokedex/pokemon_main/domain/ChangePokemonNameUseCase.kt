package com.example.pokedex.pokemon_main.domain

import com.example.pokedex.pokemon_main.data.Repository
import javax.inject.Inject

class ChangePokemonNameUseCase @Inject constructor(
    val repository: Repository
) {
    suspend operator fun invoke(id:Long,name:String) = repository.changePokeName(id,name)
}