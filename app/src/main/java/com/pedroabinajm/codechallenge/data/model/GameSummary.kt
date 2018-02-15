package com.pedroabinajm.codechallenge.data.model

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmObject


open class GameSummary : RealmObject, Parcelable {

    var channels: Int = 0
    var viewers: Int = 0

    constructor()

    constructor(channels: Int, viewers: Int) {
        this.channels = channels
        this.viewers = viewers
    }

    constructor(source: Parcel) : this(
            source.readInt(),
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(channels)
        writeInt(viewers)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<GameSummary> = object : Parcelable.Creator<GameSummary> {
            override fun createFromParcel(source: Parcel): GameSummary = GameSummary(source)
            override fun newArray(size: Int): Array<GameSummary?> = arrayOfNulls(size)
        }
    }
}