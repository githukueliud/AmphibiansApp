package com.example.amphibiansapp.data

import com.example.amphibiansapp.network.AmphibiansApiService
import retrofit2.Retrofit
import retrofit2.create

interface AppContainer {
    val amphibiansAppRepository: AmphibiansAppRepository
}

class DefaultAppContainer(): AppContainer {
    //baseUrl for the backend server
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    override val amphibiansAppRepository: AmphibiansAppRepository by lazy {
        NetworkAmphibiansAppRepository(retrofitService)
    }
}