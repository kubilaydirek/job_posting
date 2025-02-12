package com.example.jobposting.ui.scene.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobposting.data.helpers.ErrorTypeToErrorTextConverter
import com.example.jobposting.data.helpers.Resource
import com.example.jobposting.data.helpers.UiState
import com.example.jobposting.data.helpers.extension.toErrorType
import com.example.jobposting.data.models.getjobs.JobsResponseModel
import com.example.jobposting.data.repository.HomeRepository
import com.example.local_preference.UserPreference
import com.example.local_preference.data.KEYS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    private val errorTypeToErrorTextConverter: ErrorTypeToErrorTextConverter,
    private val userPreference: UserPreference
) : ViewModel() {
    private var _uiState = MutableStateFlow<UiState>(UiState.Empty)
    var uiState = _uiState.asStateFlow()
    private val _data = MutableStateFlow<List<JobsResponseModel>>(emptyList())
    var data = _data.asStateFlow()
    private val _name = MutableStateFlow<String>("")
    val name = _name.asStateFlow()

    init {
        getNameSurname()
        getAllJobs()
    }

    private fun getAllJobs() {
        _uiState.value = UiState.Loading
        viewModelScope.launch {
            homeRepository.getAllJobs().catch {
                _uiState.value = UiState.Error(errorTypeToErrorTextConverter.convert(it.toErrorType()), showToast = true)
            }
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            _uiState.value = UiState.Success(result.data)
                            _data.value = result.data
                        }

                        is Resource.Error -> _uiState.value = UiState.Error(errorTypeToErrorTextConverter.convert(result.error))
                    }
                }
        }
    }


    private fun getNameSurname() {
        viewModelScope.launch {
            val name = userPreference.getData<String>(KEYS.NAME).firstOrNull()
            val surname = userPreference.getData<String>(KEYS.SURNAME).firstOrNull()
            _name.value = "$name $surname"
        }
    }

}