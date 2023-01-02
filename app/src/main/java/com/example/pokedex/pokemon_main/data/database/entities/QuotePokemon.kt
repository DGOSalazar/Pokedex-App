package com.example.pokedex.pokemon_main.data.database.entities

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedex.pokemon_main.domain.models.Pokemon
import java.time.LocalDate

@Entity(tableName = "quotePokemon_table")
data class QuotePokemon(@PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name ="id") var id : Long=0,
                        @ColumnInfo(name = "pokemonNumber") var pokemonNumber : Int,
                        @ColumnInfo(name="name") var name: String,
                        @ColumnInfo(name="date") var date: String,
                        @ColumnInfo(name="img") var img: String)
@RequiresApi(Build.VERSION_CODES.O)
fun Pokemon.toDomain() = QuotePokemon(pokemonNumber=id,name=name,img=imgFront,date=LocalDate.now().toString())