package com.example.pokedex.pokemon_main.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.databinding.PokemonListContainerBinding
import com.example.pokedex.pokemon_main.data.model.auxModel.Results

class ListFragAdapter(var listPoke: MutableList<Results>,
                      private var listener: OnClickAdapter)
    :RecyclerView.Adapter<ListFragAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private var mBinding = PokemonListContainerBinding.bind(view)

        fun setBind(position: Int){
            with(mBinding){
                tvListName.text = listPoke[position].name
                tvListUrl.text = listPoke[position].url
                tvListId.text = (position+1).toString()
            }
        }
        fun getNewPokemon(){
            mBinding.ivBack.setOnClickListener {
                listener.onClick()
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
            getNewPokemon()
        }
    }
    override fun getItemCount(): Int = listPoke.size

    fun setData(pokemonList: List<Results>){
        this.listPoke = pokemonList as MutableList<Results>
    }
}