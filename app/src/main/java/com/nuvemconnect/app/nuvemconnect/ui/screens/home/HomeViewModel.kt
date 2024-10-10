package com.nuvemconnect.app.nuvemconnect.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuvemconnect.app.nuvemconnect.data.repository.ServiceRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

data class HomeUiState(
    val token: String = "",
    val isAuthenticated: Boolean = true
)

class HomeViewModel :
    ViewModel(),
    KoinComponent {

    private val repository: ServiceRepository by inject()

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

        init{
            viewModelScope.launch {
                _uiState.value = _uiState.value.copy(isAuthenticated = verifyAuthentication())
            }
        }

    fun logout() {
        viewModelScope.launch {
            repository.deleteAuthToken()
        }
    }

    suspend fun verifyAuthentication(): Boolean {
        repository.readAuthToken().collect { string ->
            string?.let {
                if(it == ""){
                    _uiState.value = _uiState.value.copy(isAuthenticated = false)
                    return@collect
                }
            }
        }
        return false
    }
}
