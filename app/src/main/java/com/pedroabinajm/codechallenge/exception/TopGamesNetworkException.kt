package com.pedroabinajm.codechallenge.exception

import com.pedroabinajm.codechallenge.data.model.TopGames
import java.io.IOException


class TopGamesNetworkException constructor(val topGames: TopGames) : IOException()