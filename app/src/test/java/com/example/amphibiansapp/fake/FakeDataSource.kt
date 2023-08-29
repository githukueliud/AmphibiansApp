package com.example.amphibiansapp.fake

import com.example.amphibiansapp.model.AmphibiansPhoto

object FakeDataSource {

    const val name1 = "name1"
    const val name2 = "name2"
    const val type1 = "type1"
    const val type2 = "type2"
    const val description1 = "description1"
    const val description2 = "description2"
    const val img1 = "img.1"
    const val img2 = "img.2"
    val AmphibiansPhotoList = listOf(
        AmphibiansPhoto(
            name = name1,
            type = type1,
            description = description1,
            imgSrc = img1
        ),
        AmphibiansPhoto(
            name = name2,
            type = type2,
            description = description2,
            imgSrc = img2
        )
    )
}