package com.pedroabinajm.codechallenge.data.repository

import com.pedroabinajm.codechallenge.data.model.TopGames
import io.reactivex.Observable


interface GamesRepository {
    fun getGames(): Observable<TopGames>
    fun refreshGames() : Observable<TopGames>
}