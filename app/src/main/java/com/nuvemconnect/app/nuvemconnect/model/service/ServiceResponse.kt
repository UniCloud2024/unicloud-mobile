package com.nuvemconnect.app.nuvemconnect.model.service

import com.google.gson.annotations.SerializedName

data class AccountResponse(
    @SerializedName("uuid")
    val uuid: String,
)

data class LoginResponse(
    @SerializedName("token")
    val token: String,
)

data class ResetPasswordResponse(
    @SerializedName("tokenUUID")
    val tokenUUID: String,
    @SerializedName("token")
    val token: String,
)

data class SendResetPasswordResponse(
    @SerializedName("message")
    val message: String,
)
