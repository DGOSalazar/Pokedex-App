package com.example.pokedex.pokemon_main.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.pokemon_main.data.model.Pokemon
import com.example.pokedex.pokemon_main.data.model.PokemonList
import com.example.pokedex.pokemon_main.domain.GetListPokemonUseCase
import com.example.pokedex.pokemon_main.domain.GetPokemonByIdUseCase
import com.example.pokedex.pokemon_main.domain.GetPokemonByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
     private val getListPokemonUseCase: GetListPokemonUseCase,
     private val getPokemonByIdUseCase: GetPokemonByIdUseCase,
     private val getPokemonByNameUseCase: GetPokemonByNameUseCase
) : ViewModel() {
    var pokemon = MutableLiveData<Pokemon>()
    val pokemonList = MutableLiveData<PokemonList>()

    fun onCreate(n:Int){
        viewModelScope.launch {
            val resultMain = getPokemonByIdUseCase(n)
            pokemon.postValue(resultMain)
        }
    }
    fun onShowList(n:Int=0){
        viewModelScope.launch {
            val resultList = getListPokemonUseCase(n)
            pokemonList.postValue(resultList)
        }
    }
}