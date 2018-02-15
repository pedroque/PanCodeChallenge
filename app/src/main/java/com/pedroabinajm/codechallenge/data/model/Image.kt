package com.pedroabinajm.codechallenge.data.model

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmObject


open class Image : RealmObject, Parcelable {
    lateinit var large: String

    lateinit var medium: String

    lateinit var small: String

    lateinit var template: String

    constructor()

    constructor(large: String, medium: String, small: String, template: String) {
        this.large = large
        this.medium = medium
        this.small = small
        this.template = template
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(large)
        writeString(medium)
        writeString(small)
        writeString(template)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Image> = object : Parcelable.Creator<Image> {
            override fun createFromParcel(source: Parcel): Image = Image(source)
            override fun newArray(size: Int): Array<Image?> = arrayOfNulls(size)
        }
    }
}