package com.pedroabinajm.codechallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class GameEntity (
        @Expose
        @SerializedName("_id")
        val id: Long,
        @Expose
        @SerializedName("giantbomb_id")
        val giantBombId: Long,
        @Expose
        val name: String,
        @Expose
        val popularity: Int,
        @Expose
        val box: ImageEntity,
        @Expose
        val logo: ImageEntity
)