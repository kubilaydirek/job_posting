package com.example.jobposting.ui.scene.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobposting.data.enums.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Empty)
    val uiState = _uiState.asStateFlow()

    init {
        login()
    }

    private fun login() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            delay(10000)
            _uiState.value = UiState.Success(null)
        }

    }
}