package com.example.pokedex.pokemon_main.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentListBinding
import com.example.pokedex.pokemon_main.data.network.model.auxModel.Results
import com.example.pokedex.pokemon_main.domain.models.PokeList
import com.example.pokedex.pokemon_main.ui.view.adapters.ListFragAdapter
import com.example.pokedex.pokemon_main.ui.viewModel.MainViewModel


class ListPokemonFragment : Fragment(R.layout.fragment_list) {

    private lateinit var mAdapter : ListFragAdapter
    private lateinit var mBinding: FragmentListBinding
    private var pokeList: PokeList = PokeList()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        mBinding = FragmentListBinding.inflate(inflater,container,false)
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.onShowList()
        mainViewModel.pokemonList.observe(viewLifecycleOwner) {
            pokeList=it
            setAdapter(pokeList.results)
        }
        mAdapter = ListFragAdapter(pokeList.results)
        { click(it) }
    }
    private fun setAdapter(pokeList: List<Results>){
        mAdapter.setData(pokeList)
        mBinding.recycler.apply {
            layoutManager=LinearLayoutManager(activity)
            adapter=mAdapter
        }
    }
    private fun click(results: Results){
        mainViewModel.onSelectPokemon(results.name)
        findNavController().navigate(R.id.action_listPokemonFragment_to_mainFragment)
    }
    override fun onDestroy(){
        mainViewModel.setShowFab(true)
        super.onDestroy()
    }
}