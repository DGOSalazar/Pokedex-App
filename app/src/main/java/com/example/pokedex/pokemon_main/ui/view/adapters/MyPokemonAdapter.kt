package com.example.pokedex.pokemon_main.ui.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokedex.R
import com.example.pokedex.databinding.PokemonFavContainerBinding
import com.example.pokedex.pokemon_main.domain.models.PokeFav

class MyPokemonAdapter(private var teamPokemon: List<PokeFav>, private var click:(PokeFav)-> Unit):
    RecyclerView.Adapter<MyPokemonAdapter.ViewHolder>(){
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var mBinding = PokemonFavContainerBinding.bind(view)

        fun showPokemon(pokemonFav: PokeFav){
            with(mBinding){
                tvName.text=pokemonFav.name
                tvId.text=pokemonFav.id.toString()
                tvDate.text=pokemonFav.date
            }
        }
        fun doSomething(click:(PokeFav) -> Unit){
            mBinding.root.setOnClickListener {
                val pokemon=teamPokemon[adapterPosition]
                click(pokemon)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.pokemon_fav_container,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var pokeFav = teamPokemon[position]
        with(holder){
            doSomething(click)
            showPokemon(pokeFav)
            Glide.with(mBinding.root.context)
                .load(pokeFav.img)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(mBinding.ivImg)
        }
    }
    override fun getItemCount(): Int = teamPokemon.size

    fun setData(teamPokemon: List<PokeFav>){
        this.teamPokemon = teamPokemon
        notifyDataSetChanged()
    }
}