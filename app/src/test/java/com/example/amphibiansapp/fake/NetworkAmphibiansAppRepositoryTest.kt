package com.example.amphibiansapp.fake

import com.example.amphibiansapp.data.NetworkAmphibiansAppRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkAmphibiansAppRepositoryTest {

    //this is the repository test, it uses fake data to ensure no flakiness in the repository
    @Test
    fun networkAmphibiansAppRepository_getPhotosMethod_verifyAmphibiansObjects() = runTest{
        val repository = NetworkAmphibiansAppRepository(
            amphibiansApiService = FakeAmphibianApiService()
        )
        assertEquals(FakeDataSource.AmphibiansPhotoList, repository.getPhotos())
    }
}