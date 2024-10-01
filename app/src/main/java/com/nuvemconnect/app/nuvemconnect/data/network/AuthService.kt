package com.nuvemconnect.app.nuvemconnect.data.network

import com.nuvemconnect.app.nuvemconnect.model.service.AccountRequest
import com.nuvemconnect.app.nuvemconnect.model.service.AccountResponse
import com.nuvemconnect.app.nuvemconnect.model.service.LoginRequest
import com.nuvemconnect.app.nuvemconnect.model.service.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("account")
    suspend fun createAccount(@Body request: AccountRequest): AccountResponse

    @POST("account/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

}