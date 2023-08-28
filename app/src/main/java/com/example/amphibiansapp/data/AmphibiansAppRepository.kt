package com.example.amphibiansapp.data

import com.example.amphibiansapp.model.AmphibiansPhoto
import com.example.amphibiansapp.network.AmphibiansApiService

interface AmphibiansAppRepository {
    suspend fun getPhotos(): List<AmphibiansPhoto>
}

class NetworkAmphibiansAppRepository(
    private val amphibiansApiService: AmphibiansApiService
): AmphibiansAppRepository {
    override suspend fun getPhotos(): List<AmphibiansPhoto> = amphibiansApiService.getPhotos()
}