package com.example.pokedex.pokemon_main.domain

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.pokedex.pokemon_main.data.Repository
import com.example.pokedex.pokemon_main.domain.models.Pokemon
import javax.inject.Inject

class SetPokemonFavorite @Inject constructor(
    var repository: Repository
) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(pokemon: Pokemon)= repository.insertPokemonFav(pokemon)
}