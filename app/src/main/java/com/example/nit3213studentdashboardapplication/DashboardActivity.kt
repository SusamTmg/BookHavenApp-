package com.example.nit3213studentdashboardapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nit3213studentdashboardapplication.api.ApiService
import com.example.nit3213studentdashboardapplication.databinding.ActivityDashboardBinding
import com.example.nit3213studentdashboardapplication.model.DashboardResponse
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {

    // Injecting ApiService using Koin
    private val apiService: ApiService by inject()

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var adapter: EntityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle custom back arrow click
        binding.toolbar.setNavigationOnClickListener {
            finish() // Goes back to LoginActivity
        }

        val keypass = intent.getStringExtra("keypass") ?: ""

        // Use Koin-injected ApiService to fetch dashboard data
        apiService.getDashboardData(keypass).enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(
                call: Call<DashboardResponse>,
                response: Response<DashboardResponse>
            ) {
                if (response.isSuccessful) {
                    val books = response.body()?.entities ?: emptyList()

                    adapter = EntityAdapter(books) { selectedBook ->
                        val intent = Intent(this@DashboardActivity, DetailsActivity::class.java).apply {
                            putExtra("title", selectedBook.title)
                            putExtra("author", selectedBook.author)
                            putExtra("genre", selectedBook.genre)
                            putExtra("year", selectedBook.publicationYear)
                            putExtra("description", selectedBook.description)
                        }
                        startActivity(intent)
                    }

                    binding.recyclerView.layoutManager = LinearLayoutManager(this@DashboardActivity)
                    binding.recyclerView.adapter = adapter
                } else {
                    Toast.makeText(this@DashboardActivity, "Failed to load books", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                Log.e("Dashboard", "Error: ${t.message}")
                Toast.makeText(this@DashboardActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
