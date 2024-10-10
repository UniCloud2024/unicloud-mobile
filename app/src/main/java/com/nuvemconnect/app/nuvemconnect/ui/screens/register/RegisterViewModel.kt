package com.nuvemconnect.app.nuvemconnect.ui.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuvemconnect.app.nuvemconnect.data.repository.ServiceRepository
import com.nuvemconnect.app.nuvemconnect.model.service.AccountRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

data class RegisterUiState(
    val name: String = "",
    val email: String = "",
    val isUserInteracted: Boolean = false,
    val password: String = "",
    val confirmPassword: String = "",
    val onError: String? = null,
    val onSucess: String? = null,
)

class RegisterViewModel :
    ViewModel(),
    KoinComponent {
    private val serviceRepository: ServiceRepository by inject()

    private val _uiState = MutableStateFlow(RegisterUiState())
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

    fun onRegisterClick() {
        val request =
            AccountRequest(
                name = _uiState.value.name,
                email = _uiState.value.email,
                password = _uiState.value.password,
                passwordConfirmation = _uiState.value.confirmPassword,
            )
        viewModelScope.launch {
            try {
                val response = serviceRepository.createAccount(request)
                when (response.code()) {
                    200 -> {
                        _uiState.value = _uiState.value.copy(onSucess = "Conta criada com sucesso!")
                    }
                    400 -> {
                        _uiState.value = _uiState.value.copy(onError = "Preencha todos os campos corretamente e tente novamente")
                    }
                    422 -> {
                        _uiState.value = _uiState.value.copy(onError = "A senha deve conter uma maiscula, caracter especial e devem ser iguais")
                    }
                    else -> {
                        _uiState.value = _uiState.value.copy(onError = "Ocorreu um erro, tente novamente mais tarde")
                    }
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(onError = e.toString())
            }
        }
    }

    fun dimissError() {
        _uiState.value = _uiState.value.copy(onError = null)
    }

    fun dimissSucess() {
        _uiState.value = _uiState.value.copy(onSucess = null)
    }
}
