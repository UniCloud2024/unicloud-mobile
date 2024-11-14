package com.nuvemconnect.app.nuvemconnect.ui.screens.home

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
    val inOnSearch: Boolean = false,
    val textToSearch: String = "",
    val query: String = "",
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

    fun onSearchClick() {
        isOnSearchChange()
        // Fazer pesquisa aqui e retornar para a tela
    }

    fun isOnSearchChange() {
        _uiState.value = _uiState.value.copy(inOnSearch = !uiState.value.inOnSearch)
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

    fun onQueryChange(newValue: String) {
        _uiState.value = _uiState.value.copy(query = newValue)
    }

    fun resetQuery() {
        _uiState.value = _uiState.value.copy(query = "")
    }
}
