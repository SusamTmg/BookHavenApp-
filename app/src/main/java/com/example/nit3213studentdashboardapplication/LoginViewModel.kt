package com.example.nit3213studentdashboardapplication

import androidx.lifecycle.ViewModel
import com.example.nit3213studentdashboardapplication.api.RetrofitClient
import com.example.nit3213studentdashboardapplication.model.LoginRequest
import com.example.nit3213studentdashboardapplication.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    // Real API call used in the app
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
                    onSuccess(response.body()!!.keypass)
                } else {
                    onError("Login failed. Please check your credentials.")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onError("Something went wrong: ${t.localizedMessage}")
            }
        })
    }

    // Used only for testing logic
    fun isValidLogin(username: String, password: String): Boolean {
        return username.isNotBlank() && password.startsWith("s") && password.length >= 9
    }
}
