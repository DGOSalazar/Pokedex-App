package com.example.pokedex.pokemon_main.ui.view.list_pokemon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.databinding.FragmentListBinding
import com.example.pokedex.pokemon_main.data.model.PokemonList
import com.example.pokedex.pokemon_main.data.model.auxModel.Results
import com.example.pokedex.pokemon_main.ui.view.MainActivity
import com.example.pokedex.pokemon_main.ui.view.list_pokemon.adapter.ListFragAdapter
import com.example.pokedex.pokemon_main.ui.viewModel.MainViewModel


class ListPokemonFragment : Fragment() {

    private lateinit var mAdapter : ListFragAdapter
    private lateinit var mBinding: FragmentListBinding
    private var mActivity : MainActivity? = null
    var pokeList: PokemonList = PokemonList()
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel=ViewModelProvider(requireActivity())
            .get(MainViewModel::class.java)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        mBinding = FragmentListBinding.inflate(inflater,container,false)
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        mAdapter = ListFragAdapter(pokeList.results as MutableList<Results>
        ) { click(it) }
        mainViewModel.onShowList()
        mainViewModel.pokemonList.observe(viewLifecycleOwner, Observer {
            pokeList=it
            setAdapter(pokeList.results)
        })
    }
    private fun setAdapter(pokeList: List<Results>){
        mAdapter.setData(pokeList)
        mBinding.recycler.apply {
            layoutManager=LinearLayoutManager(activity)
            adapter=mAdapter
        }
    }
    private fun click(results: Results){
        //var intent = Intent(mBinding.root.context, MainActivity::class.java)
        //startActivity(intent)
        mainViewModel.onSelectPokemon(results.name)
        //mBinding.fragmentContainer.isGone
        onDestroyView()
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
    override fun onDestroy(){
        mainViewModel.setShowFab(true)
        super.onDestroy()
    }
}