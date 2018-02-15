package com.pedroabinajm.codechallenge.data.cache

import com.pedroabinajm.codechallenge.data.model.Game
import com.pedroabinajm.codechallenge.data.model.TopGames


interface GameCache {
    fun getGames() : TopGames
    fun save(total: Int, games: List<Game>)
    fun delete()
}