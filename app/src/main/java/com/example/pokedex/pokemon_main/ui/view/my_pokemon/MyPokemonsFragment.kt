package com.example.pokedex.pokemon_main.ui.view.my_pokemon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentListBinding
import com.example.pokedex.databinding.FragmentMyPokemonsBinding
import com.example.pokedex.pokemon_main.data.model.PokemonFav
import com.example.pokedex.pokemon_main.data.model.PokemonList
import com.example.pokedex.pokemon_main.data.model.auxModel.Results
import com.example.pokedex.pokemon_main.ui.view.MainActivity
import com.example.pokedex.pokemon_main.ui.view.list_pokemon.adapter.ListFragAdapter
import com.example.pokedex.pokemon_main.ui.view.my_pokemon.adapter.MyPokemonAdapter
import com.example.pokedex.pokemon_main.ui.viewModel.MainViewModel

class MyPokemonsFragment : Fragment() {

    private lateinit var mAdapter : MyPokemonAdapter
    private lateinit var mBinding: FragmentMyPokemonsBinding
    private var mActivity : MainActivity? = null
    var pokeList: List<PokemonFav> = listOf(PokemonFav())
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel= ViewModelProvider(requireActivity())
            .get(MainViewModel::class.java)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        mBinding = FragmentMyPokemonsBinding.inflate(inflater,container,false)
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        mAdapter = MyPokemonAdapter(pokeList)
        mainViewModel.getMyPokemon()
        mainViewModel.pokemonsFav.observe(viewLifecycleOwner, Observer {
            pokeList=it
            setAdapter(pokeList)
        })
    }
    private fun setAdapter(pokeList: List<PokemonFav>){
        mAdapter.setData(pokeList)
        mBinding.recycler.apply {
            layoutManager= GridLayoutManager(mBinding.recycler.context,2)
            adapter=mAdapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
    override fun onDestroy(){
        mainViewModel.setShowFab(true)
        super.onDestroy()
    }
}