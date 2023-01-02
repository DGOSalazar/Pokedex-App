package com.example.pokedex.pokemon_main.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentMyPokemonsBinding
import com.example.pokedex.pokemon_main.domain.models.PokeFav
import com.example.pokedex.pokemon_main.ui.view.adapters.MyPokemonAdapter
import com.example.pokedex.pokemon_main.ui.viewModel.MainViewModel

class MyPokemonFragment : Fragment(R.layout.fragment_my_pokemons) {

    private lateinit var mAdapter : MyPokemonAdapter
    private lateinit var mBinding: FragmentMyPokemonsBinding
    private var pokeList: List<PokeFav> = listOf(PokeFav())
    lateinit var poke: PokeFav
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var alertBuilder : AlertDialog.Builder

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        mBinding = FragmentMyPokemonsBinding.inflate(inflater,container,false)
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        alertBuilder = AlertDialog.Builder(mBinding.root.context)
        mainViewModel.getMyPokemon()
        mainViewModel.pokemonFav.observe(viewLifecycleOwner) {
            pokeList=it
            setAdapter(pokeList)
        }
    }
    private fun setAdapter(pokeList: List<PokeFav>){
        mAdapter = MyPokemonAdapter(pokeList){onClick(it)}
        mBinding.recycler.apply {
            layoutManager= GridLayoutManager(mBinding.recycler.context,2)
            adapter=mAdapter
        }
    }
    override fun onDestroy(){
        mainViewModel.setShowFab(true)
        super.onDestroy()
    }
    private fun onClick(pokemon: PokeFav){
        alertBuilder.setTitle(getString(R.string.what_do))
            .setMessage(getString(R.string.mssg_alert))
            .setPositiveButton(getString(R.string.let_free)){ _, _ ->
                mainViewModel.letPokemonFree(pokemon.id)
                mAdapter.setData(pokeList)
            }.setNegativeButton(getString(R.string.it_ok)){ _, _ -> }
            .setNeutralButton(getString(R.string.change_ap)) { _, _ ->
                mainViewModel.changePokeName(pokemon.id,pokemon.name)
                mAdapter.setData(pokeList)
            }.show()

    }
}