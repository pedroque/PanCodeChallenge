package com.pedroabinajm.codechallenge.ui.games

import com.pedroabinajm.codechallenge.data.model.TopGames
import com.pedroabinajm.codechallenge.ui.commons.Resource


class TopGamesResource(
        status: Status,
        data: TopGames? = null,
        error: Throwable? = null
) : Resource<TopGames>(status, data, error) {
    override val isEmpty: Boolean
        get() = data == null || (data.games.isEmpty())

    companion object {
        fun loading(data: TopGames?) = TopGamesResource(Status.LOADING, data)
        fun success(data: TopGames?) = TopGamesResource(Status.SUCCESS, data)
        fun error(error: Throwable, data: TopGames? = null) = TopGamesResource(Status.ERROR, data, error)
    }
}