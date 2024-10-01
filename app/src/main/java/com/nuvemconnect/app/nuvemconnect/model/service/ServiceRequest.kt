package com.nuvemconnect.app.nuvemconnect.model.service

data class AccountRequest(val name: String, val email: String, val password: String, val passwordConfirmation: String)

data class LoginRequest(val email: String, val password: String)