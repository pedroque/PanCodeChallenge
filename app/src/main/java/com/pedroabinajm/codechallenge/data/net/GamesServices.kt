package com.pedroabinajm.codechallenge.data.net

import com.pedroabinajm.codechallenge.data.entity.TopGamesEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface GamesServices {
    @GET("games/top")
    fun getTopGames(@Query("offset") offset: Int,
                    @Query("limit") limit: Int): Observable<TopGamesEntity>
}