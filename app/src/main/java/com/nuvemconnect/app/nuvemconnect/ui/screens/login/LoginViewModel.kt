package com.nuvemconnect.app.nuvemconnect.ui.screens.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String>  = _email.asStateFlow()

    private val _isUserInteracted = MutableStateFlow(false)
    val isUserInteracted: StateFlow<Boolean> = _isUserInteracted

    private val _password = MutableStateFlow("")
    val password: StateFlow<String>  = _password.asStateFlow()

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
        _isUserInteracted.value = true
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }




}