package com.example.nit3213studentdashboardapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nit3213studentdashboardapplication.api.RetrofitClient
import com.example.nit3213studentdashboardapplication.databinding.ActivityDashboardBinding
import com.example.nit3213studentdashboardapplication.model.DashboardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.koin.android.ext.android.inject
import com.example.nit3213studentdashboardapplication.api.ApiService


class DashboardActivity : AppCompatActivity() {

    private val apiService: ApiService by inject()
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var adapter: EntityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle vector back arrow click inside the MaterialToolbar
        binding.toolbar.setNavigationOnClickListener {
            // Finish DashboardActivity and return to LoginActivity
            finish()
        }

        val keypass = intent.getStringExtra("keypass") ?: ""

        apiService.getDashboardData(keypass).enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(
                call: Call<DashboardResponse>,
                response: Response<DashboardResponse>
            ) {
                if (response.isSuccessful) {
                    val books = response.body()?.entities ?: emptyList()

                    // Set up RecyclerView with item click
                    adapter = EntityAdapter(books) { selectedBook ->
                        val intent = Intent(this@DashboardActivity, DetailsActivity::class.java)
                        intent.putExtra("title", selectedBook.title)
                        intent.putExtra("author", selectedBook.author)
                        intent.putExtra("genre", selectedBook.genre)
                        intent.putExtra("year", selectedBook.publicationYear)
                        intent.putExtra("description", selectedBook.description)
                        startActivity(intent)
                    }

                    binding.recyclerView.layoutManager = LinearLayoutManager(this@DashboardActivity)
                    binding.recyclerView.adapter = adapter

                } else {
                    Toast.makeText(
                        this@DashboardActivity,
                        "Failed to load books",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                Log.e("Dashboard", "Error: ${t.message}")
                Toast.makeText(
                    this@DashboardActivity,
                    "Error: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}
