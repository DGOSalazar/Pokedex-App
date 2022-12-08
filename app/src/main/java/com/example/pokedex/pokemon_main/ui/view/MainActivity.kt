package com.example.pokedex.pokemon_main.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokedex.R
import com.example.pokedex.databinding.PokemonMainBinding
import com.example.pokedex.pokemon_main.data.model.Pokemon
import com.example.pokedex.pokemon_main.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : PokemonMainBinding
    private var pokemon: Pokemon = Pokemon()
    private var nPokemon: Int=1
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        mBinding=PokemonMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        mainViewModel.onCreate(nPokemon)
        mainViewModel.pokemon.observe(this, Observer {
            pokemon = it
            printPokemon()
        })
        mBinding.previousPokemon.setOnClickListener{
            if(nPokemon==1) nPokemon else nPokemon--
            mainViewModel.onCreate(nPokemon)
        }
        mBinding.nextPokemon.setOnClickListener{
            nPokemon++
            mainViewModel.onCreate(nPokemon)
        }
        mBinding.mcMain.setOnClickListener{
            changeImg()
        }
        mBinding.listPokemon.setOnClickListener {
            launchFragment()
            Toast.makeText(this,"hola",Toast.LENGTH_SHORT).show()
        }
    }
    private fun launchFragment() {
      supportFragmentManager.commit {
          setReorderingAllowed(true)
          add<ListFragment>(R.id.fragment_id)
      }
    }

    private fun changeImg() {
        mountImg(pokemon.sprites.backImg)
        printPokemon()
    }

    private fun printPokemon() {
        mountImg(pokemon.sprites.frontImg)
        with(mBinding){
            tvName.text=pokemon.name.capitalize()
            tvNumber.text=("#${pokemon.id}")
            showTypes()
            tvHp.text=("${pokemon.stats[0].stat.name}: ${pokemon.stats[0].baseStat}")
            tvAttack.text=("${pokemon.stats[1].stat.name}: ${pokemon.stats[1].baseStat}")
            tvDefense.text=("${pokemon.stats[2].stat.name}: ${pokemon.stats[2].baseStat}")
            tvSpeed.text=("${pokemon.stats[5].stat.name}: ${pokemon.stats[5].baseStat}")
            //tvHeight.text=("Height: ${pokemon.height}")
            //tvWeight.text=("Weight: ${pokemon.weight}")
        }
    }
    private fun showTypes() {
        if(pokemon.types.size == 2){
            mBinding.type2.isVisible
            mBinding.type1.text = pokemon.types[0].type.name
            mBinding.type2.text = pokemon.types[1].type.name
        }else{
            mBinding.type2.isGone
            mBinding.type1.text = pokemon.types[0].type.name
        }
    }

    private fun mountImg(url:String){
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .circleCrop()
            .into(mBinding.ivPokemon)
    }
}