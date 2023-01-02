package com.example.pokedex.pokemon_main.ui.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.databinding.PokemonListContainerBinding
import com.example.pokedex.pokemon_main.data.network.model.auxModel.Results

class ListFragAdapter(var listPoke: List<Results>,
                      private var click : (Results)->Unit)
    :RecyclerView.Adapter<ListFragAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private var mBinding = PokemonListContainerBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun setBind(position: Int){
            with(mBinding){
                tvListName.text = listPoke[position].name
                tvListUrl.text = listPoke[position].url
                tvListId.text = (position+1).toString()
            }
        }
        fun getNewPokemon(click:(Results)->Unit){
            mBinding.root.setOnClickListener {
                click(listPoke[adapterPosition])
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.pokemon_list_container,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        with(holder) {
            setBind(position)
            getNewPokemon(click)
        }
    }
    override fun getItemCount(): Int = listPoke.size

    fun setData(pokemonList: List<Results>){
        this.listPoke = pokemonList
    }
}