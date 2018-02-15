package com.pedroabinajm.codechallenge.data.net

import javax.inject.Inject

class DebugApiConfig @Inject
constructor() : ApiConfig {

    override val baseUrl: String
        get() = "https://api.twitch.tv/kraken/"

    override fun log(): Boolean {
        return true
    }
}
