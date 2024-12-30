package com.example.jobposting.ui.scene.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobposting.data.helpers.ErrorTypeToErrorTextConverter
import com.example.jobposting.data.helpers.ErrorTypeToErrorTextConverterImp
import com.example.jobposting.data.helpers.Resource
import com.example.jobposting.data.helpers.UiState
import com.example.jobposting.data.helpers.extension.toErrorType
import com.example.jobposting.data.models.Login.LoginRequestModel
import com.example.jobposting.data.repository.AuthRepository
import com.example.`local-preference`.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val errorTypeToErrorTextConverter: ErrorTypeToErrorTextConverter = ErrorTypeToErrorTextConverterImp(),
    private val userPreference: UserPreference
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Empty)
    val uiState = _uiState.asStateFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            authRepository.login(LoginRequestModel(username = username, password = password))
                .catch {
                    _uiState.value = UiState.Error(errorTypeToErrorTextConverter.convert(it.toErrorType()), showToast = true)
                }
                .collect { result ->
                    when (result) {
                        is Resource.Success -> _uiState.value = UiState.Success(result.data)
                        is Resource.Error -> _uiState.value = UiState.Error(errorTypeToErrorTextConverter.convert(result.error))
                    }
                }
        }

    }
}