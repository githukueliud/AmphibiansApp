package com.example.amphibiansapp.fake

import com.example.amphibiansapp.data.AmphibiansAppRepository
import com.example.amphibiansapp.model.AmphibiansPhoto

class FakeNetworkAmphibianAppRepository: AmphibiansAppRepository {
    override suspend fun getPhotos(): List<AmphibiansPhoto> {
        return FakeDataSource.AmphibiansPhotoList
    }
}