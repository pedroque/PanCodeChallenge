package com.pedroabinajm.codechallenge.app

import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesImpl @Inject
constructor(private val prefs: SharedPreferences) : Preferences {

    companion object {
        private const val TOTAL_GAME_COUNT = "total_game_count"
    }

    override var totalGameCount: Int
        get() = prefs.getInt(TOTAL_GAME_COUNT, 0)
        set(value) {
            prefs.edit().putInt(TOTAL_GAME_COUNT, value).apply()
        }

}