package com.pedroabinajm.codechallenge.data.entity

import com.google.gson.annotations.Expose


class GameSummaryEntity(
        @Expose
        val channels: Int,
        @Expose
        val viewers: Int,
        @Expose
        val game: GameEntity
)