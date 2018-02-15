package com.pedroabinajm.codechallenge.ui.game

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.pedroabinajm.codechallenge.R
import com.pedroabinajm.codechallenge.data.model.Game
import com.pedroabinajm.codechallenge.databinding.ActivityGameBinding
import com.pedroabinajm.codechallenge.ui.base.BaseActivity


class GameActivity : BaseActivity() {

    private lateinit var dataBinding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_game, null, false)
        setContentView(dataBinding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setSupportActionBar(dataBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val game = intent.getParcelableExtra<Game>(GAME)
        dataBinding.game = game
    }

    companion object {

        private const val GAME = "game"

        fun getIntent(context: Context, game: Game): Intent {
            val intent = Intent(context, GameActivity::class.java)
            intent.putExtra(GAME, game)
            return intent
        }
    }
}