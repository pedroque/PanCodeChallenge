package com.pedroabinajm.codechallenge.data.entity.mapper

import com.pedroabinajm.codechallenge.data.entity.TopGamesEntity
import com.pedroabinajm.codechallenge.data.model.TopGames
import javax.inject.Inject


class TopGamesMapper @Inject constructor(
        private val gameMapper: GameMapper
) {
    fun transform(topGamesEntity: TopGamesEntity): TopGames {
        return TopGames(
                topGamesEntity.total,
                topGamesEntity.top.map {
                    gameMapper.transform(it.game, it)
                }.toMutableList()
        )
    }
}