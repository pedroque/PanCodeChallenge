package com.pedroabinajm.codechallenge.data.model

import android.os.Parcel
import android.os.Parcelable

class TopGames : Parcelable {
    var total: Int = 0
    lateinit var games: MutableList<Game>

    constructor()

    constructor(total: Int, games: MutableList<Game>) {
        this.total = total
        this.games = games
    }

    constructor(source: Parcel) {
        this.total = source.readInt()
        games = mutableListOf()
        source.readTypedList(games, Game.CREATOR)
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(total)
        writeTypedList(games)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TopGames> = object : Parcelable.Creator<TopGames> {
            override fun createFromParcel(source: Parcel): TopGames = TopGames(source)
            override fun newArray(size: Int): Array<TopGames?> = arrayOfNulls(size)
        }
    }

}