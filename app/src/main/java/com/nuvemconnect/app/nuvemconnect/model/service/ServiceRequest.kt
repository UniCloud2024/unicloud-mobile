package com.nuvemconnect.app.nuvemconnect.model.service

import com.google.gson.annotations.SerializedName

data class AccountRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("passwordConfirmation")
    val passwordConfirmation: String,
)

data class LoginRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
)

data class ResetPasswordRequest(
    @SerializedName("email")
    val email: String,
)

data class SendResetPasswordRequest(
    @SerializedName("tokenUUID")
    val tokenUUID: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("passwordConfirmation")
    val passwordConfirmation: String,
)
