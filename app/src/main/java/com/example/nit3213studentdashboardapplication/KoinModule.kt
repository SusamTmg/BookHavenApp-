package com.example.nit3213studentdashboardapplication.di

import com.example.nit3213studentdashboardapplication.api.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://nit3213api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
