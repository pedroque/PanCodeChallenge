package com.pedroabinajm.codechallenge.di.module

import com.pedroabinajm.codechallenge.data.cache.GameCache
import com.pedroabinajm.codechallenge.data.cache.GameCacheImpl
import com.pedroabinajm.codechallenge.data.dao.GameDao
import com.pedroabinajm.codechallenge.data.dao.GameDaoImpl
import com.pedroabinajm.codechallenge.data.repository.GamesRepository
import com.pedroabinajm.codechallenge.data.repository.GamesRepositoryImpl
import com.pedroabinajm.codechallenge.data.repository.datasource.CloudGamesDataSource
import com.pedroabinajm.codechallenge.data.repository.datasource.GamesDataSource
import com.pedroabinajm.codechallenge.data.schedulers.ISchedulerProvider
import com.pedroabinajm.codechallenge.di.ActivityScope
import com.pedroabinajm.codechallenge.ui.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable


@Module
class GameModule {
    @Provides
    @Reusable
    internal fun provideGameDao(gameDao: GameDaoImpl): GameDao = gameDao

    @Provides
    @Reusable
    internal fun provideGamesDataSource(gamesDataSource: CloudGamesDataSource):
            GamesDataSource = gamesDataSource

    @Provides
    @Reusable
    internal fun provideGamesCache(gamesCache: GameCacheImpl):
            GameCache = gamesCache

//    @Provides
//    @Reusable
//    internal fun provideGameMapper(gameMapper: GameMapper) = gameMapper
//
//    @Provides
//    @Reusable
//    internal fun provideGameSummaryMapper(gameSummaryMapper: GameSummaryMapper) = gameSummaryMapper
//
//    @Provides
//    @Reusable
//    internal fun provideImageMapper(imageMapper: ImageMapper) = imageMapper
//
//    @Provides
//    @Reusable
//    internal fun provideTopGamesMapper(topGamesMapper: TopGamesMapper) = topGamesMapper

    @Provides
    @Reusable
    internal fun provideGamesRepository(gamesRepository: GamesRepositoryImpl):
            GamesRepository = gamesRepository


    @Provides
    @ActivityScope
    internal fun provideViewModelFactory(gamesRepository: GamesRepository,
                                         schedulerProvider: ISchedulerProvider) =
            ViewModelFactory(gamesRepository, schedulerProvider)

}