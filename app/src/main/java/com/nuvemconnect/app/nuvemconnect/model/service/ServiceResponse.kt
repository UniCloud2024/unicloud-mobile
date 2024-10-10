package com.nuvemconnect.app.nuvemconnect.model.service

data class AccountResponse(
    val uuid: String,
)

data class LoginResponse(
    val token: String,
)

data class ResetPasswordResponse (
    val tokenUUID: String,
    val token: String
)

data class SendResetPasswordResponse (
    val message: String
)