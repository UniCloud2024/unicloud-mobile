package com.nuvemconnect.app.nuvemconnect.data.repository

import com.nuvemconnect.app.nuvemconnect.data.network.AuthService
import com.nuvemconnect.app.nuvemconnect.model.service.AccountRequest
import com.nuvemconnect.app.nuvemconnect.model.service.AccountResponse
import com.nuvemconnect.app.nuvemconnect.model.service.LoginRequest
import com.nuvemconnect.app.nuvemconnect.model.service.LoginResponse

class ServiceRepository(
    private val authService: AuthService,
) {

    suspend fun createAccount(account: AccountRequest): AccountResponse  {
        val response = authService.createAccount(account)
        return response
    }

    suspend fun login(account: LoginRequest): LoginResponse  {
        val response = authService.login(account)
        return response
    }
}
