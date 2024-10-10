package com.nuvemconnect.app.nuvemconnect.data.repository

import com.nuvemconnect.app.nuvemconnect.data.network.AuthService
import com.nuvemconnect.app.nuvemconnect.model.service.AccountRequest
import com.nuvemconnect.app.nuvemconnect.model.service.AccountResponse
import com.nuvemconnect.app.nuvemconnect.model.service.LoginRequest
import com.nuvemconnect.app.nuvemconnect.model.service.LoginResponse
import com.nuvemconnect.app.nuvemconnect.model.service.ResetPasswordRequest
import com.nuvemconnect.app.nuvemconnect.model.service.ResetPasswordResponse
import com.nuvemconnect.app.nuvemconnect.model.service.SendResetPasswordRequest
import com.nuvemconnect.app.nuvemconnect.model.service.SendResetPasswordResponse
import retrofit2.Response

class ServiceRepository(
    private val authService: AuthService,
) {
    suspend fun createAccount(account: AccountRequest): Response<AccountResponse> = authService.createAccount(account)

    suspend fun login(account: LoginRequest): Response<LoginResponse> = authService.login(account)

    suspend fun resetPasswordRequest(request: ResetPasswordRequest): Response<ResetPasswordResponse> =
        authService.resetPasswordRequest(request)

    suspend fun sendResetPassword(request: SendResetPasswordRequest): Response<SendResetPasswordResponse> =
        authService.sendResetPassword(request)
}
