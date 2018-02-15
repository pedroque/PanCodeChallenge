package com.pedroabinajm.codechallenge.data.dao

import com.pedroabinajm.codechallenge.data.model.Game
import javax.inject.Inject


class GameDaoImpl @Inject constructor() : GameDao, BaseDao<Game>(Game::class.java)