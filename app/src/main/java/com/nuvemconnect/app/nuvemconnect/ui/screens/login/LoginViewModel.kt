package com.nuvemconnect.app.nuvemconnect.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuvemconnect.app.nuvemconnect.data.repository.ServiceRepository
import com.nuvemconnect.app.nuvemconnect.model.service.LoginRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginViewModel :
    ViewModel(),
    KoinComponent {
    private val serviceRepository: ServiceRepository by inject()

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _isUserInteracted = MutableStateFlow(false)
    val isUserInteracted: StateFlow<Boolean> = _isUserInteracted

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword.asStateFlow()

    fun onName(newName: String) {
        _name.value = newName
    }

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
        _isUserInteracted.value = true
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
        _isUserInteracted.value = true
    }

    fun onConfirmPassword(confirmPassword: String) {
        _confirmPassword.value = confirmPassword
        _isUserInteracted.value = true
    }

    fun onLoginClick()  {
        val account: LoginRequest = LoginRequest(email = _email.value, password = password.value)
        viewModelScope.launch {
            serviceRepository.login(account)
        }
    }
}
