package com.example.amphibiansapp.fake

import com.example.amphibiansapp.rules.TestDispatcherRule
import com.example.amphibiansapp.ui.screens.AmphibiansUiState
import com.example.amphibiansapp.ui.screens.AmphibiansViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class AmphibiansAppViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
    @Test
    fun amphibiansViewModel_getPhotosMethod_verifyAmphibiansUiStateSuccess() = runTest {
        val amphibiansViewModel = AmphibiansViewModel(
            amphibiansAppRepository = FakeNetworkAmphibianAppRepository()
        )
        assertEquals(AmphibiansUiState.Success(
            FakeDataSource.AmphibiansPhotoList
        ), amphibiansViewModel.amphibiansUiState)
    }
}