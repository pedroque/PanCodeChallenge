package com.pedroabinajm.codechallenge.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class TopGamesEntity(
        @Expose
        @SerializedName("_total")
        val total: Int,
        @Expose
        val top: List<GameSummaryEntity>
)