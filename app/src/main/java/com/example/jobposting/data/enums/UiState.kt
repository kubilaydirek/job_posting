package com.example.jobposting.data.enums

sealed class UiState {
    data object Empty : UiState()
    data object Loading : UiState()
    data class Error(val error: String) : UiState()
    data class Success<T>(val data : T?) : UiState()
}