package com.pedroabinajm.codechallenge.di

import com.pedroabinajm.codechallenge.app.BaseApp
import com.pedroabinajm.codechallenge.di.component.DaggerAppComponent
import com.pedroabinajm.codechallenge.di.module.AppModule

object AppInjector {
    @JvmStatic
    fun init(app: BaseApp) {
        DaggerAppComponent.builder()
                .application(app)
                .appModule(AppModule(app))
                .build()
                .inject(app)
    }
}
