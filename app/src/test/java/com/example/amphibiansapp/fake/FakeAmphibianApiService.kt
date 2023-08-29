package com.example.amphibiansapp.fake

import com.example.amphibiansapp.model.AmphibiansPhoto
import com.example.amphibiansapp.network.AmphibiansApiService


class FakeAmphibianApiService: AmphibiansApiService {
    override suspend fun getPhotos(): List<AmphibiansPhoto> {
        return FakeDataSource.AmphibiansPhotoList
    }
}