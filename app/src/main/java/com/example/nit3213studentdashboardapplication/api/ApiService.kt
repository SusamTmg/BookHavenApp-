package com.example.nit3213studentdashboardapplication.api

import com.example.nit3213studentdashboardapplication.model.GenericResponse
import com.example.nit3213studentdashboardapplication.model.LoginRequest
import com.example.nit3213studentdashboardapplication.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("sydney/auth")
    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>

    @GET("dashboard/{keypass}")
    fun getDashboardData(
        @Path("keypass") keypass: String
    ): Call<GenericResponse>
}
