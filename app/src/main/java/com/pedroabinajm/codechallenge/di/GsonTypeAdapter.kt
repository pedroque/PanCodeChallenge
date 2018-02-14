package com.pedroabinajm.codechallenge.di


import javax.inject.Qualifier
import kotlin.reflect.KClass

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class GsonTypeAdapter(val value: KClass<*>)
