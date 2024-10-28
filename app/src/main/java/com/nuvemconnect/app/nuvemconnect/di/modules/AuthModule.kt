package com.nuvemconnect.app.nuvemconnect.di.modules

import android.content.Context
import androidx.credentials.GetCredentialRequest
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.nuvemconnect.app.nuvemconnect.data.network.AuthService
import com.nuvemconnect.app.nuvemconnect.data.repository.ServiceRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.MessageDigest
import java.util.UUID

val authModule =
    module {
        single(named("authRetrofit")) { provideRetrofit(get()) }
        single { provideOkHttpClient(get()) }
        single { provideLogInterceptor() }
        single { provideRepository(get(), get(), androidContext(), get()) }
        single { provideService(get(named("authRetrofit"))) }
        single { provideAuthDataStore(androidContext()) }
        single { provideGoogleIdOption(WebClientId.ID_KEY, getRandomString()) }
        single { provideGetCredentialRequest(get()) }
    }

fun provideRepository(
    authService: AuthService,
    dataStore: DataStore<Preferences>,
    context: Context,
    getCredentialRequest: GetCredentialRequest,
): ServiceRepository {
    val repository =
        ServiceRepository(authService = authService, dataStore = dataStore, context = context, getCredentialRequest = getCredentialRequest)
    return repository
}

fun provideService(retrofit: Retrofit): AuthService = retrofit.create(AuthService::class.java)

fun provideRetrofit(client: OkHttpClient): Retrofit =
    Retrofit
        .Builder()
        .baseUrl("https://nuvemconnectapi.seronsoftware.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

fun provideOkHttpClient(httpLogginInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient
        .Builder()
        .addInterceptor(httpLogginInterceptor)
        .build()

fun provideLogInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

val Context.authDataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")

fun provideAuthDataStore(context: Context): DataStore<Preferences> = context.authDataStore

object WebClientId {
    const val ID_KEY: String = "OAuth WebApplication ClientId goes here"
}

fun getRandomString(): String {
    val nonce = UUID.randomUUID().toString()
    val byte = nonce.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(byte)
    val hashedNonce = digest.fold("") { str, it -> str + "%02x".format(it) }
    return hashedNonce
}

fun provideGoogleIdOption(
    webClientId: String,
    randomString: String,
): GetGoogleIdOption =
    GetGoogleIdOption
        .Builder()
        .setFilterByAuthorizedAccounts(true)
        .setServerClientId(webClientId)
        .setAutoSelectEnabled(true)
        .setNonce(randomString)
        .build()

fun provideGetCredentialRequest(googleIdOption: GetGoogleIdOption) =
    GetCredentialRequest
        .Builder()
        .addCredentialOption(googleIdOption)
        .build()
