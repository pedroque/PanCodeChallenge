package com.pedroabinajm.codechallenge.data.repository

import com.pedroabinajm.codechallenge.data.cache.GameCache
import com.pedroabinajm.codechallenge.data.model.TopGames
import com.pedroabinajm.codechallenge.data.repository.datasource.GamesDataSource
import com.pedroabinajm.codechallenge.exception.TopGamesNetworkException
import io.reactivex.Observable
import java.io.IOException
import javax.inject.Inject


class GamesRepositoryImpl @Inject constructor(
        private val gamesDataSource: GamesDataSource,
        private val gameCache: GameCache
) : GamesRepository {
    override fun refreshGames(): Observable<TopGames> {
        return getGames(0, {
            gameCache.delete()
            gameCache.save(it.total, it.games)
        })
    }

    override fun getGames(): Observable<TopGames> {
        return getGames(gameCache.getGames().games.size, {
            gameCache.save(it.total, it.games)
        })
    }

    private fun getGames(offset: Int, onNext: (topGames: TopGames) -> Unit = {}): Observable<TopGames> {
        return gamesDataSource.getGames(offset, Math.min(100, Math.max(20, offset)))
                .startWith(gameCache.getGames())
                .doOnNext {
                    onNext(it)
                }
                .map {
                    gameCache.getGames()
                }
                .doOnError {
                    throw if (it is IOException) {
                        TopGamesNetworkException(gameCache.getGames())
                    } else {
                        it
                    }
                }
    }
}