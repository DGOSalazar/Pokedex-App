package com.example.pokedex.pokemon_main.data.model.auxModel

import com.google.gson.annotations.SerializedName

data class Moves(@SerializedName("move")var move : Results,
                 @SerializedName("version_group_details") var vgd: List<Vgd>)

data class Vgd(@SerializedName("level_learned_at")var levelLearn: Int=0,
               @SerializedName("move_learn_method")var moveLearn: Results,
               @SerializedName("version_group")var versionGroup : Results)
