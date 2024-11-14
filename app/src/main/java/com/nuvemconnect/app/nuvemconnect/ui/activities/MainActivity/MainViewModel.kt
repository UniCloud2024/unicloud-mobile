package com.nuvemconnect.app.nuvemconnect.ui.activities.MainActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuvemconnect.app.nuvemconnect.data.repository.ServiceRepository
import com.nuvemconnect.app.nuvemconnect.navigation.Graph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

data class MainUiState(
    val route: String = "",
)

class MainViewModel :
    ViewModel(),
    KoinComponent {
    init {
        viewModelScope.launch {
            verifyAuthentication()
        }
    }

    private val repository: ServiceRepository by inject()
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    fun verifyAuthentication() {
        viewModelScope.launch {
            repository.readAuthToken().collect { string ->
                if (string == null || string == "") {
                    _uiState.value = _uiState.value.copy(route = Graph.HomeGraph.route)
                    return@collect
                }
            }
        }
        _uiState.value = _uiState.value.copy(route = Graph.HomeGraph.route)
    }
}
