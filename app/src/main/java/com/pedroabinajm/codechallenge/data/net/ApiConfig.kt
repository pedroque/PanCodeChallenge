package com.pedroabinajm.codechallenge.data.net

interface ApiConfig {

    val baseUrl: String

    fun log(): Boolean
}
