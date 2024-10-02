package com.nuvemconnect.app.nuvemconnect.di.modules

import com.nuvemconnect.app.nuvemconnect.data.network.AuthService
import com.nuvemconnect.app.nuvemconnect.data.repository.ServiceRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val authModule =
    module {
        single { provideRetrofit(get()) }
        single { provideRepository(get()) }
    }

fun provideRepository(authService: AuthService): ServiceRepository  {
    val repository = ServiceRepository(authService = authService)
    return repository
}

fun provideRetrofit(client: OkHttpClient): Retrofit =
    Retrofit
        .Builder()
        .baseUrl("https://nuvemconnectapi.seronsoftware.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .build()
