package com.example.nit3213studentdashboardapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nit3213studentdashboardapplication.api.RetrofitClient
import com.example.nit3213studentdashboardapplication.model.LoginRequest
import com.example.nit3213studentdashboardapplication.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private val viewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Use ViewModel to login via API
                viewModel.loginUser(username, password,
                    onSuccess = { keypass ->
                        // Login successful, open DashboardActivity with keypass
                        val intent = Intent(this, DashboardActivity::class.java)
                        intent.putExtra("keypass", keypass)
                        startActivity(intent)
                    },
                    onError = { errorMessage ->
                        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}
