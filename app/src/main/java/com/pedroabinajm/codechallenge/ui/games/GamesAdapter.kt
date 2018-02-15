package com.pedroabinajm.codechallenge.ui.games

import com.pedroabinajm.codechallenge.R
import com.pedroabinajm.codechallenge.data.model.Game
import com.pedroabinajm.codechallenge.ui.base.EndlessAdapter

class GamesAdapter : EndlessAdapter<Game>() {
    override fun getItemIdForPosition(position: Int) = R.layout.item_game
}