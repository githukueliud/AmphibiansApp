package com.example.amphibiansapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibiansapp.AmphibiansApplication
import com.example.amphibiansapp.data.AmphibiansAppRepository
import com.example.amphibiansapp.model.AmphibiansPhoto
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface AmphibiansUiState{
    data class Success(val photos: List<AmphibiansPhoto>): AmphibiansUiState
    object Error: AmphibiansUiState
    object Loading: AmphibiansUiState
}



class AmphibiansViewModel(
    private val amphibiansAppRepository: AmphibiansAppRepository
): ViewModel() {
    //this stores the status of the most recent request
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    //calling the getPhotos in the init so that we can get the the ui status immediately
    init {
        getPhotos()
    }

    //get the information from the Amphibians Api retrofit service
    fun getPhotos() {
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try {
                val result = amphibiansAppRepository.getPhotos()[0]
                AmphibiansUiState.Success(
                    amphibiansAppRepository.getPhotos()
                )
            } catch (e: IOException) {
                AmphibiansUiState.Error
            } catch (e: HttpException) {
                AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansAppRepository = application.container.amphibiansAppRepository
                AmphibiansViewModel(amphibiansAppRepository = amphibiansAppRepository)
            }
        }
    }
}