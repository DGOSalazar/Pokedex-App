package com.example.pokedex.pokemon_main.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.pokedex.R
import com.example.pokedex.databinding.PokemonMainBinding
import com.example.pokedex.pokemon_main.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : PokemonMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        mBinding=PokemonMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        mainViewModel.onCreate(1)
        var response = mainViewModel.pokemon
    }
}