package com.example.nit3213studentdashboardapplication

import androidx.lifecycle.ViewModel
import com.example.nit3213studentdashboardapplication.api.RetrofitClient
import com.example.nit3213studentdashboardapplication.model.LoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.nit3213studentdashboardapplication.model.LoginResponse

class LoginViewModel : ViewModel() {

    fun loginUser(
        username: String,
        password: String,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = LoginRequest(username, password)

        RetrofitClient.api.loginUser(request).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val keypass = response.body()!!.keypass
                    onSuccess(keypass)
                } else {
                    onError("Login failed. Please check your credentials.")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onError("Something went wrong: ${t.localizedMessage}")
            }
        })
    }
}
