package com.pedroabinajm.codechallenge.data.entity.mapper

import com.pedroabinajm.codechallenge.data.entity.GameSummaryEntity
import com.pedroabinajm.codechallenge.data.model.GameSummary
import javax.inject.Inject


class GameSummaryMapper @Inject constructor() {
    fun transform(summaryEntity: GameSummaryEntity): GameSummary {
        return GameSummary(
                summaryEntity.channels,
                summaryEntity.viewers
        )
    }
}