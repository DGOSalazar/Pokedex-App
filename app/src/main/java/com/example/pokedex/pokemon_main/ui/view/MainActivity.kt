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
import com.example.pokedex.pokemon_main.ui.view.list_pokemon.ListPokemonFragment
import com.example.pokedex.pokemon_main.ui.view.my_pokemon.MyPokemonsFragment
import com.example.pokedex.pokemon_main.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : PokemonMainBinding
    private var pokemon: Pokemon = Pokemon()
    private val mainViewModel: MainViewModel by viewModels()
    private var imgCount =0
    private var nPokemon: Int=1

    override fun onCreate(savedInstanceState: Bundle?) {
        mBinding=PokemonMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        //liveData
        mainViewModel.onCreate(nPokemon)
        mainViewModel.pokemon.observe(this, Observer {
            pokemon = it
            nPokemon = pokemon.id
            printPokemon()
        })
        mainViewModel.fab.observe(this, Observer {
            mBinding.fabCapture.isVisible=it
        })

        //userClicks
        mBinding.previousPokemon.setOnClickListener{
            if(nPokemon==1) nPokemon else nPokemon--
            mainViewModel.onCreate(nPokemon)
        }
        mBinding.nextPokemon.setOnClickListener{
            if(nPokemon==893) nPokemon else nPokemon++
            mainViewModel.onCreate(nPokemon)
        }
        mBinding.mcMain.setOnClickListener{
            imgCount++
            changeImg()
        }
        mBinding.listPokemon.setOnClickListener {
            launchFragmentList()
        }
        mBinding.fabCapture.setOnClickListener{
            toastMessage(getString(R.string.CatchPokemon))
        }
        mBinding.ivFavorite.setOnClickListener{
            launchFragmentFav()
        }
    }
    private fun launchFragmentList() {
        mainViewModel.setShowFab(false)
        mBinding.mcMain.isGone
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack("main")
            add<ListPokemonFragment>(R.id.main_activity)
        }
    }
    private fun launchFragmentFav(){
        mainViewModel.setShowFab(false)
        mBinding.mcMain.isGone
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack("main")
            add<MyPokemonsFragment>(R.id.main_activity)
        }
    }
    private fun changeImg() {
        when(imgCount){
            1 -> mountImg(pokemon.sprites.backImg)
            2 -> mountImg(pokemon.sprites.shinyImg)
            3 -> {
                mountImg(pokemon.sprites.frontImg)
                imgCount=0
            }
        }
    }
    private fun printPokemon() {
        mountImg(pokemon.sprites.frontImg)
        with(mBinding){
            tvName.text=pokemon.name.capitalize()
            tvNumber.text=("#${pokemon.id}")
            showTypes()
            tvHp.text=pokemon.stats[0].stat.name
            progressHp.progress = pokemon.stats[0].baseStat.toFloat()
            progressHp.labelText = pokemon.stats[0].baseStat.toString()
            tvAttack.text=pokemon.stats[1].stat.name
            progressAttack.progress = pokemon.stats[1].baseStat.toFloat()
            progressAttack.labelText = pokemon.stats[1].baseStat.toString()
            tvDefense.text=pokemon.stats[2].stat.name
            progressDefense.progress = pokemon.stats[2].baseStat.toFloat()
            progressDefense.labelText = pokemon.stats[2].baseStat.toString()
            tvSpeed.text=pokemon.stats[5].stat.name
            progressSpeed.progress = pokemon.stats[5].baseStat.toFloat()
            progressSpeed.labelText = pokemon.stats[5].baseStat.toString()
            tvHeight.text=("Height: ${pokemon.height}")
            tvWeight.text=("Weight: ${pokemon.weight}")
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
            .into(mBinding.mcMain)
    }
    private fun toastMessage(text : String){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }
}