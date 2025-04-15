package com.example.nit3213studentdashboardapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Receive data from intent
        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val genre = intent.getStringExtra("genre")
        val year = intent.getIntExtra("year", 0)
        val description = intent.getStringExtra("description")

        // Find TextViews
        val titleView = findViewById<TextView>(R.id.detailTitle)
        val authorView = findViewById<TextView>(R.id.detailAuthor)
        val genreView = findViewById<TextView>(R.id.detailGenre)
        val yearView = findViewById<TextView>(R.id.detailYear)
        val descriptionView = findViewById<TextView>(R.id.detailDescription)

        // Set data to views
        titleView.text = title
        authorView.text = "Author: $author"
        genreView.text = "Genre: $genre"
        yearView.text = "Published: $year"
        descriptionView.text = "Summary: $description"

        // Manual back button
        val backBtn = findViewById<Button>(R.id.btnBackToDashboard)
        backBtn.setOnClickListener {
            finish() // Go back to Dashboard
        }
    }
}
