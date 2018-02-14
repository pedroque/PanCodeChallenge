package com.pedroabinajm.codechallenge.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Environment(val value: String)
