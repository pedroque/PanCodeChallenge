package com.pedroabinajm.codechallenge.data.cache

import com.pedroabinajm.codechallenge.app.Preferences
import com.pedroabinajm.codechallenge.data.dao.GameDao
import com.pedroabinajm.codechallenge.data.model.Game
import com.pedroabinajm.codechallenge.data.model.TopGames
import javax.inject.Inject


class GameCacheImpl @Inject constructor(
        private val preferences: Preferences,
        private val dao: GameDao
) : GameCache {
    override fun delete() {
        dao.delete()
    }

    override fun getGames(): TopGames {
        val games = dao.findAll() ?: listOf()
        return TopGames(preferences.totalGameCount, games.toMutableList())
    }

    override fun save(total: Int, games: List<Game>) {
        preferences.totalGameCount = total
        dao.save(games)
    }
}