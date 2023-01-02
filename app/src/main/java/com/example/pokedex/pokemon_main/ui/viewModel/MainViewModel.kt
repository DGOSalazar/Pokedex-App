package com.example.pokedex.pokemon_main.ui.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.pokemon_main.domain.*
import com.example.pokedex.pokemon_main.domain.models.PokeFav
import com.example.pokedex.pokemon_main.domain.models.PokeList
import com.example.pokedex.pokemon_main.domain.models.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
     private val getListPokemonUseCase: GetListPokemonUseCase,
     private val getPokemonByIdUseCase: GetPokemonByIdUseCase,
     private val getPokemonByNameUseCase: GetPokemonByNameUseCase,
     private val getFavoritesPokemon: GetFavoritesPokemon,
     private val setPokemonFavorite: SetPokemonFavorite,
     private val getFreePokemonUseCase: GetFreePokemonUseCase,
     private val changePokemonNameUseCase: ChangePokemonNameUseCase
) : ViewModel() {
    var pokemonApi = MutableLiveData<Pokemon>()
    var pokemonList = MutableLiveData<PokeList>()
    var pokemonFav= MutableLiveData<List<PokeFav>>()
    var fab = MutableLiveData<Boolean>()
    var n=1;

    fun onLaunchApp(){
        viewModelScope.launch {
            val resultMain = getPokemonByIdUseCase(n)
            pokemonApi.postValue(resultMain)
        }
    }
    fun nextPokemon(){
        if(n==1000) n else n++
        onLaunchApp()
    }
    fun previousPokemon(){
        if(n==1) n else n--
        onLaunchApp()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun capturePokemon(pokemon: Pokemon){
        viewModelScope.launch {
            setPokemonFavorite(pokemon)
        }
    }
    fun getMyPokemon() {
        viewModelScope.launch {
            val pokeFav = getFavoritesPokemon()
            pokemonFav.postValue(pokeFav)
        }
    }
    fun onSelectPokemon(name:String){
        viewModelScope.launch {
            val resultMain = getPokemonByNameUseCase(name)
            n=resultMain.id
            onLaunchApp()
        }
    }
    fun onShowList(n:Int=0){
        viewModelScope.launch{
            val resultList = getListPokemonUseCase(n)
            pokemonList.postValue(resultList)
        }
    }
    fun changePokeName(id: Long, name: String){
        viewModelScope.launch {
            changePokemonNameUseCase(id,name)
        }
    }
    fun setShowFab(isVisible : Boolean){
        fab.value = isVisible
    }
    fun letPokemonFree(id:Long){
        viewModelScope.launch {
            getFreePokemonUseCase(id)
            getMyPokemon()
        }
    }
}
