package com.example.amphibiansapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

sealed interface AmphibiansUiState{
    data class Success(val photos: String): AmphibiansUiState
    object Error: AmphibiansUiState
    object Loading: AmphibiansUiState
}



class AmphibiansViewModel: ViewModel() {
    //this stores the status of the most recent request
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set
}