package com.pedroabinajm.codechallenge.data.model

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class Game : RealmObject, Parcelable {
    @PrimaryKey
    var id: Long = 0
    var giantBombId: Long = 0
    lateinit var name: String
    var box: Image? = null
    var logo: Image? = null
    var summary: GameSummary? = null

    constructor()

    constructor(id: Long, giantBombId: Long, name: String, box: Image?, logo: Image?, summary: GameSummary?) {
        this.id = id
        this.giantBombId = giantBombId
        this.name = name
        this.box = box
        this.logo = logo
        this.summary = summary
    }

    constructor(source: Parcel) : this(
            source.readLong(),
            source.readLong(),
            source.readString(),
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.readParcelable<GameSummary>(GameSummary::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeLong(id)
        writeLong(giantBombId)
        writeString(name)
        writeParcelable(box, flags)
        writeParcelable(logo, flags)
        writeParcelable(summary, flags)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Game

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Game> = object : Parcelable.Creator<Game> {
            override fun createFromParcel(source: Parcel): Game = Game(source)
            override fun newArray(size: Int): Array<Game?> = arrayOfNulls(size)
        }
    }
}