package com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuvemconnect.app.nuvemconnect.data.repository.ServiceRepository
import com.nuvemconnect.app.nuvemconnect.model.service.ResetPasswordRequest
import com.nuvemconnect.app.nuvemconnect.model.service.ResetPasswordResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

data class ForgotPasswordUiState(
    val name: String = "",
    val email: String = "",
    val isUserInteracted: Boolean = false,
    val password: String = "",
    val confirmPassword: String = "",
    val onError: String? = null,
    val onSucess: Boolean = false,
    val response: ResetPasswordResponse? = null,
)

class ForgotPasswordViewModel :
    ViewModel(),
    KoinComponent {
    private val serviceRepository: ServiceRepository by inject()

    private val _uiState = MutableStateFlow(ForgotPasswordUiState())
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

    fun dimissError() {
        _uiState.value = _uiState.value.copy(onError = null)
    }

    fun resetPasswordRequest()  {
        viewModelScope.launch {
            try {
                val response = serviceRepository.resetPasswordRequest(ResetPasswordRequest(uiState.value.email))
                when (response.code()) {
                    200 -> {
                        response.body()?.let {
                            _uiState.value = _uiState.value.copy(onSucess = true, response = it)
                        }
                        if (response.body() == null)
                            {
                                _uiState.value =
                                    _uiState.value.copy(
                                        onSucess = false,
                                        onError = "Você deve aguardar um pouco para poder solicitar redefinição da senha novamente",
                                    )
                            }
                    }
                    400 -> {
                        _uiState.value = _uiState.value.copy(onError = "Preencha o campo corretamente e tente novamente")
                    }
                    422 -> {
                        _uiState.value = _uiState.value.copy(onError = "Não encontramos uma conta com esse e-mail")
                    }
                    else -> {
                        _uiState.value = _uiState.value.copy(onError = "Ocorreu um erro. Tente novamente mais tarde")
                    }
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(onError = e.toString())
            }
        }
    }
}
