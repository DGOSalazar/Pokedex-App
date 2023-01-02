package com.example.pokedex.pokemon_main.ui.view

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentListBinding
import com.example.pokedex.databinding.FragmentMainBinding
import com.example.pokedex.databinding.PokemonMainBinding
import com.example.pokedex.pokemon_main.domain.models.Pokemon
import com.example.pokedex.pokemon_main.ui.viewModel.MainViewModel

class MainFragment : Fragment(R.layout.fragment_main),View.OnClickListener {

    private lateinit var mBinding : FragmentMainBinding
    private var pokemon: Pokemon = Pokemon()
    private val mainViewModel: MainViewModel by activityViewModels()
    private var imgCount=0
    private var nPokemon = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mBinding=FragmentMainBinding.inflate(inflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.onLaunchApp()
        with(mainViewModel){
            pokemonApi.observe(viewLifecycleOwner){ poke ->
                pokemon = poke
                printPokemon()
            }
            fab.observe(viewLifecycleOwner){
                mBinding.fabCapture.isVisible=it
            }
        }
        //userClicks
        mBinding.previousPokemon.setOnClickListener(this)
        mBinding.nextPokemon.setOnClickListener(this)
        mBinding.mcMain.setOnClickListener(this)
        mBinding.listPokemon.setOnClickListener(this)
        mBinding.fabCapture.setOnClickListener(this)
        mBinding.ivFavorite.setOnClickListener(this)
    }
    private fun changeImg() {
        when(imgCount){
            1 -> mountImg(pokemon.imgFront)
            2 -> mountImg(pokemon.imgBack)
            3 -> {
                mountImg(pokemon.imgShiny)
                imgCount=0
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private fun printPokemon() {
        mountImg(pokemon.imgFront)
        with(mBinding){
            tvName.text=pokemon.name
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
            mBinding.type2.isVisible = true
            mBinding.type1.text = pokemon.types[0].type.name
            mBinding.type2.text = pokemon.types[1].type.name
        }else{
            mBinding.type2.isGone = true
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
        Toast.makeText(mBinding.root.context,text, Toast.LENGTH_SHORT).show()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(p0: View?) {
        p0?.let {
            when(it){
                mBinding.previousPokemon -> {
                    mainViewModel.previousPokemon()
                }
                mBinding.nextPokemon-> {
                    mainViewModel.nextPokemon()
                }
                mBinding.mcMain -> {
                    imgCount++
                    changeImg()
                }
                mBinding.listPokemon -> {
                    findNavController().navigate(R.id.action_mainFragment_to_listPokemonFragment)
                }
                mBinding.ivFavorite ->{
                    findNavController().navigate(R.id.action_mainFragment_to_myPokemonFragment)
                }
                mBinding.fabCapture ->{
                    mainViewModel.capturePokemon(pokemon)
                    toastMessage(getString(R.string.CatchPokemon))
                }
            }
        }
    }
}