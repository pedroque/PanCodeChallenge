package com.pedroabinajm.codechallenge.data.entity.mapper

import com.pedroabinajm.codechallenge.data.entity.GameEntity
import com.pedroabinajm.codechallenge.data.entity.GameSummaryEntity
import com.pedroabinajm.codechallenge.data.model.Game
import javax.inject.Inject


class GameMapper @Inject constructor(
        private val gameSummaryMapper: GameSummaryMapper,
        private val imageMapper: ImageMapper
) {
    fun transform(game: GameEntity, gameSummary: GameSummaryEntity): Game {
        return Game(
                game.id,
                game.giantBombId,
                game.name,
                imageMapper.transform(game.box),
                imageMapper.transform(game.logo),
                gameSummaryMapper.transform(gameSummary)
        )
    }
}