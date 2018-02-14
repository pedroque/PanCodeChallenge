package com.pedroabinajm.codechallenge.data.net

import javax.inject.Inject

class DebugApiConfig @Inject
constructor() : ApiConfig {

    override val baseUrl: String
        get() = "https://dev.twitch.tv/docs/v5/reference/games/"

    override fun log(): Boolean {
        return true
    }
}
