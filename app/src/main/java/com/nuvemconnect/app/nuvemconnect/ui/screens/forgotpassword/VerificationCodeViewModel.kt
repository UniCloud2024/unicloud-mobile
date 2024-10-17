package com.nuvemconnect.app.nuvemconnect.ui.screens.forgotpassword

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent

data class VerificationCodeUiState(
    val token: String = "",
    val uuid: String = "",
    val email: String = "",
    val inputCode: String = "",
)

class VerificationCodeViewModel :
    ViewModel(),
    KoinComponent {
    private val _uiState = MutableStateFlow(VerificationCodeUiState())
    val uiState = _uiState.asStateFlow()

    fun updateToken(
        newToken: String,
        newUuid: String,
        newEmail: String,
    ) {
        _uiState.value = _uiState.value.copy(token = newToken)
        _uiState.value = _uiState.value.copy(uuid = newUuid)
        _uiState.value = _uiState.value.copy(email = newEmail)
    }

    fun updateInputCode(newCode: String) {
        _uiState.value = _uiState.value.copy(inputCode = newCode)
    }

    fun verifyCode() = uiState.value.inputCode == uiState.value.token
}
