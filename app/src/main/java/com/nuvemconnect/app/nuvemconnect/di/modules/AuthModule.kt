package com.nuvemconnect.app.nuvemconnect.di.modules

import com.nuvemconnect.app.nuvemconnect.data.network.AuthService
import com.nuvemconnect.app.nuvemconnect.data.repository.ServiceRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val authModule =
    module {
        single(named("authRetrofit")) { provideRetrofit(get()) }
        single { provideOkHttpClient(get()) }
        single { provideLogInterceptor() }
        single { provideRepository(get()) }
        single { provideService(get(named("authRetrofit"))) }
    }

fun provideRepository(authService: AuthService): ServiceRepository  {
    val repository = ServiceRepository(authService = authService)
    return repository
}

fun provideService(retrofit: Retrofit): AuthService{
    return retrofit.create(AuthService::class.java)
}

fun provideRetrofit(client: OkHttpClient): Retrofit =
    Retrofit
        .Builder()
        .baseUrl("https://nuvemconnectapi.seronsoftware.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

fun provideOkHttpClient(httpLogginInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(httpLogginInterceptor)
        .build()

fun provideLogInterceptor(): HttpLoggingInterceptor{
    return HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}