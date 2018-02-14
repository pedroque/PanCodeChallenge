package com.pedroabinajm.codechallenge.data.schedulers

import io.reactivex.Scheduler

interface ISchedulerProvider {
    fun computation() : Scheduler
    fun ui() : Scheduler
}