package com.pedroabinajm.codechallenge.data.repository.datasource

import com.pedroabinajm.codechallenge.data.entity.mapper.TopGamesMapper
import com.pedroabinajm.codechallenge.data.model.TopGames
import com.pedroabinajm.codechallenge.data.net.GamesServices
import io.reactivex.Observable
import javax.inject.Inject

class CloudGamesDataSource @Inject constructor(
        private val gamesServices: GamesServices,
        private val topGamesMapper: TopGamesMapper
) : GamesDataSource {
    override fun getGames(offset: Int, limit: Int): Observable<TopGames> {
        return gamesServices.getTopGames(offset, limit)
                .map { topGamesMapper.transform(it) }
    }
}