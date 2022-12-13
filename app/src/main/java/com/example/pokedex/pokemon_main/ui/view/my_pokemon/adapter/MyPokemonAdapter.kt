package com.example.pokedex.pokemon_main.ui.view.my_pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokedex.R
import com.example.pokedex.databinding.PokemonFavContainerBinding
import com.example.pokedex.pokemon_main.data.model.PokemonFav

class MyPokemonAdapter(var pokemons: List<PokemonFav>):
    RecyclerView.Adapter<MyPokemonAdapter.ViewHolder>(){
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var mBinding = PokemonFavContainerBinding.bind(view)
        fun showPokemon(pokemonFav: PokemonFav){
            with(mBinding){
                tvName.text=pokemons[adapterPosition].name
                tvId.text=pokemons[adapterPosition].id.toString()
                tvDate.text=pokemons[adapterPosition].date
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.pokemon_fav_container,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            showPokemon(pokemons[adapterPosition])
            //Glide.with(mBinding.root.context)
            //    .load(pokemons[adapterPosition].img)
            //    .diskCacheStrategy(DiskCacheStrategy.ALL)
            //    .centerCrop()
            //    .circleCrop()
            //    .into(mBinding.ivImg)
        }
    }
    override fun getItemCount(): Int = pokemons.size

    fun setData(pokemons: List<PokemonFav>){
        this.pokemons = pokemons
    }
}