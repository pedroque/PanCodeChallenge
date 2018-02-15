package com.pedroabinajm.codechallenge.ui.games

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.pedroabinajm.codechallenge.R
import com.pedroabinajm.codechallenge.data.model.Game
import com.pedroabinajm.codechallenge.databinding.ActivityGamesBinding
import com.pedroabinajm.codechallenge.extensions.friendlyMessage
import com.pedroabinajm.codechallenge.ui.ViewModelFactory
import com.pedroabinajm.codechallenge.ui.base.BaseActivity
import com.pedroabinajm.codechallenge.ui.commons.EndlessScrollListener
import com.pedroabinajm.codechallenge.ui.commons.GridAutofitLayoutManager
import com.pedroabinajm.codechallenge.ui.commons.Resource
import com.pedroabinajm.codechallenge.ui.commons.SpacesItemDecoration
import javax.inject.Inject


class TopGamesActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var topGamesViewModel: TopGamesViewModel

    private lateinit var dataBinding: ActivityGamesBinding

    private var adapter: GamesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_games, null, false)
        setContentView(dataBinding.root)
        topGamesViewModel = ViewModelProviders.of(this, viewModelFactory).get(TopGamesViewModel::class.java)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setUpViews()
        bind()
    }

    private fun setUpViews() {
        setSupportActionBar(dataBinding.toolbar)
        dataBinding.gamesRecycler.setHasFixedSize(true)
        val margin = resources.getDimension(R.dimen.default_margin).toInt()
        dataBinding.gamesRecycler.addItemDecoration(SpacesItemDecoration(margin))
        val columnWidth = resources.getDimension(R.dimen.game_column_width).toInt()
        val layoutManager = GridAutofitLayoutManager(this, margin * 2 + columnWidth)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                adapter?.run {
                    if (position == items?.size?.plus(1)) {
                        return layoutManager.spanCount
                    }
                }
                return 1
            }

        }
        dataBinding.gamesRecycler.layoutManager = layoutManager
        adapter = GamesAdapter()
        adapter?.clickSubject?.subscribe {
            topGamesViewModel.topGames.value?.data?.games?.get(it)?.let {
                navigateToGame(it)
            }
        }
        adapter?.replace(mutableListOf())
        dataBinding.gamesRecycler.adapter = adapter
        val scrollListener = object : EndlessScrollListener(dataBinding.gamesRecycler.layoutManager as GridLayoutManager) {
            override fun onLoadMore() {
                val currentOffset = topGamesViewModel.topGames.value?.data?.games?.size ?: 0
                val total = topGamesViewModel.topGames.value?.data?.total ?: 0
                adapter?.let {
                    if (currentOffset < total && !it.loading) {
                        it.loading = true
                        topGamesViewModel.nextPage()
                    }
                }
            }
        }
        dataBinding.gamesRecycler.addOnScrollListener(scrollListener)
        dataBinding.swipeRefreshLayout.setOnRefreshListener {
            topGamesViewModel.refreshGames()
        }
    }

    fun bind() {
        topGamesViewModel.topGames.observe(this, Observer<TopGamesResource> {
            dataBinding.resource = it
            adapter?.loading = it?.status == Resource.Status.LOADING
            if (it?.status != Resource.Status.LOADING) {
                dataBinding.swipeRefreshLayout.isRefreshing = false
                it?.data?.let {
                    if (it.games.isEmpty()) setEmptyGames() else setGames(it.games)
                } ?: setEmptyGames()
                if (it?.status == Resource.Status.ERROR) {
                    if (!it.isEmpty) {
                        it.error?.let {
                            setNextPageError(it.friendlyMessage)
                        }
                    }
                }
            }
        })
        if (topGamesViewModel.topGames.value == null) {
            topGamesViewModel.nextPage()
        }
    }

    private fun navigateToGame(game: Game) {
//        startActivity(MovieActivity.getIntent(this, movie))
    }

    private fun setNextPageError(message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setGames(games: List<Game>) {
        adapter?.replace(games)
    }

    private fun setEmptyGames() {
        dataBinding.errorText.setText(R.string.empty_games)
    }
}