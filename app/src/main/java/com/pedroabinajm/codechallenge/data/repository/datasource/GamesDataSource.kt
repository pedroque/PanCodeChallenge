package com.pedroabinajm.codechallenge.data.repository.datasource

import com.pedroabinajm.codechallenge.data.model.TopGames
import io.reactivex.Observable


interface GamesDataSource {
    fun getGames(offset: Int, limit: Int): Observable<TopGames>
}