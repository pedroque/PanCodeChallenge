package com.pedroabinajm.codechallenge.data.entity.mapper

import com.pedroabinajm.codechallenge.data.entity.ImageEntity
import com.pedroabinajm.codechallenge.data.model.Image
import javax.inject.Inject


class ImageMapper @Inject constructor() {
    fun transform(imageEntity: ImageEntity): Image {
        return Image(
                imageEntity.large,
                imageEntity.medium,
                imageEntity.small,
                imageEntity.template
        )
    }
}