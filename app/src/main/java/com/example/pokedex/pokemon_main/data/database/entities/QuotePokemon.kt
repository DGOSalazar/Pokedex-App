package com.example.pokedex.pokemon_main.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "quotePokemon_table")
data class QuotePokemon(@ColumnInfo(name = "id") var id : Long,
                        @ColumnInfo(name="name") var name: String,
                        @ColumnInfo(name="date") var date: String,
                        @ColumnInfo(name="img")var img: String)