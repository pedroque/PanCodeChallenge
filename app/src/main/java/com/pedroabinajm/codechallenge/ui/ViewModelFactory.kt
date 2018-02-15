@file:Suppress("UNCHECKED_CAST")

package com.pedroabinajm.codechallenge.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.pedroabinajm.codechallenge.data.repository.GamesRepository
import com.pedroabinajm.codechallenge.data.schedulers.ISchedulerProvider
import com.pedroabinajm.codechallenge.ui.games.TopGamesViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
        private val gamesRepository: GamesRepository,
        private val schedulerProvider: ISchedulerProvider
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TopGamesViewModel::class.java)) {
            return TopGamesViewModel(gamesRepository, schedulerProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}