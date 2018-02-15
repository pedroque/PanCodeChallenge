package com.pedroabinajm.codechallenge.ui.games

import android.arch.lifecycle.MutableLiveData
import com.pedroabinajm.codechallenge.data.model.TopGames
import com.pedroabinajm.codechallenge.data.repository.GamesRepository
import com.pedroabinajm.codechallenge.data.schedulers.ISchedulerProvider
import com.pedroabinajm.codechallenge.exception.TopGamesNetworkException
import com.pedroabinajm.codechallenge.ui.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.exceptions.CompositeException

class TopGamesViewModel constructor(
        private val gamesRepository: GamesRepository,
        schedulerProvider: ISchedulerProvider
) : BaseViewModel(schedulerProvider) {

    val topGames = MutableLiveData<TopGamesResource>()

    fun nextPage(): Observable<TopGames> {
        return fetchGames(gamesRepository.getGames())
    }

    fun refreshGames(): Observable<TopGames> {
        return fetchGames(gamesRepository.refreshGames())
    }

    private fun fetchGames(source: Observable<TopGames>): Observable<TopGames> {
        topGames.postValue(TopGamesResource.loading(topGames.value?.data?.let { it }))
        return execute(source, {
            topGames.postValue(TopGamesResource.success(it))
        }, {
            val cause = (it as? CompositeException)?.exceptions?.get(it.size() - 1) ?: it
            if (cause is TopGamesNetworkException) {
                topGames.postValue(TopGamesResource.error(cause, cause.topGames))
            } else {
                topGames.postValue(TopGamesResource.error(cause))
            }
        })
    }
}