package com.nuvemconnect.app.nuvemconnect.di.modules

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val authModule = module {
    single { provideRetrofit(get()) }
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://nuvemconnectapi.seronsoftware.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}