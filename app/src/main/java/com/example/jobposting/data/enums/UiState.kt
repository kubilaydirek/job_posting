package com.example.jobposting.data.enums

sealed class UiState {
    data object Empty : UiState()
    data object Loading : UiState()
    data class Error(val error: String, val showToast: Boolean = false) : UiState()
    data class Success<T>(val data: T?, val message: String? = null, val showToast: Boolean = false) : UiState()
}