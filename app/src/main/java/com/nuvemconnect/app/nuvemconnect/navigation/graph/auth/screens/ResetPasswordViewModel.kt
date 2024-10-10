package com.nuvemconnect.app.nuvemconnect.navigation.graph.auth.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuvemconnect.app.nuvemconnect.data.repository.ServiceRepository
import com.nuvemconnect.app.nuvemconnect.model.service.SendResetPasswordRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

data class ResetPasswordUiState(
    val tokenUUID: String = "",
    val token: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isUserInteracted: Boolean = false,
    val onError: String? = null,
    val onSucess: String? = null,
)

class ResetPasswordViewModel :
    ViewModel(),
    KoinComponent {
    private val _uiState = MutableStateFlow(ResetPasswordUiState())
    val uiState = _uiState.asStateFlow()

    private val serviceRepository: ServiceRepository by inject()

    fun updatePassword(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun updateConfirmPassword(confirmPassword: String) {
        _uiState.value = _uiState.value.copy(confirmPassword = confirmPassword)
    }

    fun sendResetPassword() {
        val request =
            SendResetPasswordRequest(
                tokenUUID = uiState.value.tokenUUID,
                token = uiState.value.token,
                email = uiState.value.email,
                password = uiState.value.password,
                passwordConfirmation = uiState.value.confirmPassword,
            )
        viewModelScope.launch {
            try {
                val response = serviceRepository.sendResetPassword(request)
                when (response.code()) {
                    200 -> {
                        _uiState.value = _uiState.value.copy(onSucess = "Senha alterada com sucesso!")
                        _uiState.value = _uiState.value.copy(onError = null)
                    }
                    400 -> {
                        _uiState.value = _uiState.value.copy(onError = "Preencha os formulários adequadamente")
                        _uiState.value = _uiState.value.copy(onSucess = null)
                    }
                    422 -> {
                        _uiState.value =
                            _uiState.value.copy(onError = "As senhas não estão iguais, ou fora do padrao aceito. Tente novamente")
                        _uiState.value = _uiState.value.copy(onSucess = null)
                    }
                    404 -> {
                        _uiState.value = _uiState.value.copy(onError = "Ocorreu um erro. Usuario não encontrado")
                        _uiState.value = _uiState.value.copy(onSucess = null)
                    }
                    else -> {
                        _uiState.value = _uiState.value.copy(onError = "Ocorreu um erro. Usuario não encontrado")
                        _uiState.value = _uiState.value.copy(onSucess = null)
                    }
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(onError = e.toString())
                _uiState.value = _uiState.value.copy(onSucess = null)
            }
        }
    }

    fun dimissSucess() {
        _uiState.value = _uiState.value.copy(onSucess = null)
    }

    fun dimissError() {
        _uiState.value = _uiState.value.copy(onError = null)
    }

    fun updateArguments(
        tokenUUID: String,
        token: String,
        email: String,
    ) {
        _uiState.value = _uiState.value.copy(tokenUUID = tokenUUID, token = token, email = email)
    }
}
