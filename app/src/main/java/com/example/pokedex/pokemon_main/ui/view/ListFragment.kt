package com.example.pokedex.pokemon_main.ui.view

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
import com.example.pokedex.pokemon_main.ui.view.adapter.ListFragAdapter
import com.example.pokedex.pokemon_main.ui.view.adapter.OnClickAdapter
import com.example.pokedex.pokemon_main.ui.viewModel.MainViewModel


class ListFragment : Fragment(),OnClickAdapter {

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
            ,this)
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
    override fun onClick(){
        mActivity?.onBackPressed()
    }
    override fun onDestroy(){
        setHasOptionsMenu(false)
        super.onDestroy()
    }
}