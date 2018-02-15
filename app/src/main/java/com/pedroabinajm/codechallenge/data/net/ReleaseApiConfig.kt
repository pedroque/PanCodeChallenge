package com.pedroabinajm.codechallenge.data.net

import javax.inject.Inject

class ReleaseApiConfig @Inject
constructor() : ApiConfig {

    override val baseUrl: String
        get() = "https://api.twitch.tv/kraken/"

    override fun log(): Boolean {
        return false
    }
}
