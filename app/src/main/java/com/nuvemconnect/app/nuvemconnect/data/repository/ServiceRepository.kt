package com.nuvemconnect.app.nuvemconnect.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.nuvemconnect.app.nuvemconnect.data.network.AuthService
import com.nuvemconnect.app.nuvemconnect.model.service.AccountRequest
import com.nuvemconnect.app.nuvemconnect.model.service.AccountResponse
import com.nuvemconnect.app.nuvemconnect.model.service.LoginRequest
import com.nuvemconnect.app.nuvemconnect.model.service.LoginResponse
import com.nuvemconnect.app.nuvemconnect.model.service.ResetPasswordRequest
import com.nuvemconnect.app.nuvemconnect.model.service.ResetPasswordResponse
import com.nuvemconnect.app.nuvemconnect.model.service.SendResetPasswordRequest
import com.nuvemconnect.app.nuvemconnect.model.service.SendResetPasswordResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

class ServiceRepository(
    private val authService: AuthService,
    private val dataStore: DataStore<Preferences>
) {

    // Camada Online

    suspend fun createAccount(account: AccountRequest): Response<AccountResponse> = authService.createAccount(account)

    suspend fun login(account: LoginRequest): Response<LoginResponse> = authService.login(account)

    suspend fun resetPasswordRequest(request: ResetPasswordRequest): Response<ResetPasswordResponse> =
        authService.resetPasswordRequest(request)

    suspend fun sendResetPassword(request: SendResetPasswordRequest): Response<SendResetPasswordResponse> =
        authService.sendResetPassword(request)

    // Camada Offline

    object AUTHTOKEN{
        val key = stringPreferencesKey("auth_token")
    }

    suspend fun saveAuthToken(token: String){
        dataStore.edit { preferences ->
            preferences[AUTHTOKEN.key] = token
        }
    }

    fun readAuthToken(): Flow<String?> {
        return dataStore.data.map { preferences ->
            preferences[AUTHTOKEN.key]
        }
    }

    suspend fun deleteAuthToken(){
        dataStore.edit { preferences ->
            preferences[AUTHTOKEN.key] = ""
        }
    }

}
