package com.nuvemconnect.app.nuvemconnect.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuvemconnect.app.nuvemconnect.data.repository.ServiceRepository
import com.nuvemconnect.app.nuvemconnect.model.service.LoginRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

data class LoginUiState(
    val name: String = "",
    val email: String = "",
    val isUserInteracted: Boolean = false,
    val password: String = "",
    val confirmPassword: String = "",
    val onError: String? = null,
    val onSucess: Boolean = false,
)

class LoginViewModel :
    ViewModel(),
    KoinComponent {
    private val serviceRepository: ServiceRepository by inject()

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun onName(newName: String) {
        _uiState.value = _uiState.value.copy(name = newName)
    }

    fun onEmailChange(newEmail: String) {
        _uiState.value = _uiState.value.copy(email = newEmail, isUserInteracted = true)
    }

    fun onPasswordChange(newPassword: String) {
        _uiState.value = _uiState.value.copy(password = newPassword, isUserInteracted = true)
    }

    fun onConfirmPassword(confirmPassword: String) {
        _uiState.value = _uiState.value.copy(confirmPassword = confirmPassword, isUserInteracted = true)
    }

    fun onLoginClick() {
        val account = LoginRequest(email = uiState.value.email, password = uiState.value.password)
        viewModelScope.launch {
            val response = serviceRepository.login(account)
            when (response.code()) {
                200 -> {
                    response.body()?.let { body ->
                        saveTokenJWT(body.token)
                        _uiState.value = _uiState.value.copy(onSucess = true)
                        _uiState.value = _uiState.value.copy(onError = null)
                    }

                }
                400 -> {
                    _uiState.value = _uiState.value.copy(onError = "Preencha todos os campos adequadamente e tente novamente")
                    _uiState.value = _uiState.value.copy(onSucess = false)
                }
                422 -> {
                    _uiState.value = _uiState.value.copy(onError = "Usuario ou senha incorretos")
                    _uiState.value = _uiState.value.copy(onSucess = false)
                }
                else -> {
                    _uiState.value = _uiState.value.copy(onError = "Ocorreu um erro. Tente mais tarde novamente")
                    _uiState.value = _uiState.value.copy(onSucess = false)
                }
            }
        }
    }

    fun dimissError() {
        _uiState.value = _uiState.value.copy(onError = null)
    }

    private fun saveTokenJWT(token: String){
        viewModelScope.launch {
            serviceRepository.saveAuthToken(token)
        }
    }
}
