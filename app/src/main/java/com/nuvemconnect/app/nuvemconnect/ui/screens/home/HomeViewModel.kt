package com.nuvemconnect.app.nuvemconnect.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuvemconnect.app.nuvemconnect.data.repository.ServiceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

data class HomeUiState(
    val token: String = "",
    val isAuthenticated: Boolean = true,
)

class HomeViewModel :
    ViewModel(),
    KoinComponent {
    private val repository: ServiceRepository by inject()

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            verifyAuthentication()
        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.deleteAuthToken()
        }
    }

    fun verifyAuthentication() {
        viewModelScope.launch {
            repository.readAuthToken().collect { string ->
                if (string == null || string == "") {
                    _uiState.value = _uiState.value.copy(isAuthenticated = false)
                    return@collect
                }
            }
        }
        _uiState.value = _uiState.value.copy(isAuthenticated = true)
    }
}
