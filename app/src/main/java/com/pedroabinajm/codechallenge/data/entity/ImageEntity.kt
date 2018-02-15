package com.pedroabinajm.codechallenge.data.entity

import com.google.gson.annotations.Expose


class ImageEntity (
        @Expose
        val large: String,
        @Expose
        val medium: String,
        @Expose
        val small: String,
        @Expose
        val template: String
)