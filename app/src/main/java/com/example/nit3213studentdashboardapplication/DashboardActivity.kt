package com.example.nit3213studentdashboardapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nit3213studentdashboardapplication.EntityAdapter
import com.example.nit3213studentdashboardapplication.api.RetrofitClient
import com.example.nit3213studentdashboardapplication.databinding.ActivityDashboardBinding
import com.example.nit3213studentdashboardapplication.model.DashboardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var adapter: EntityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val keypass = intent.getStringExtra("keypass") ?: ""

        adapter = EntityAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Call API to fetch book data
        RetrofitClient.api.getDashboardData(keypass).enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(
                call: Call<DashboardResponse>,
                response: Response<DashboardResponse>
            ) {
                if (response.isSuccessful) {
                    val books = response.body()?.entities ?: emptyList()
                    adapter.setData(books)
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
