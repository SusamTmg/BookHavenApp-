package com.example.nit3213studentdashboardapplication

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.gson.Gson
import com.google.gson.JsonObject

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Get the entity JSON string from intent
        val entityJson = intent.getStringExtra("entity")
        val entity = Gson().fromJson(entityJson, JsonObject::class.java)

        // Find the container for dynamic fields
        val detailsContainer = findViewById<LinearLayout>(R.id.detailsContainer)

        // Clear any existing views
        detailsContainer.removeAllViews()

        // Add each field from the entity as a CardView with TextView
        entity.entrySet().forEach { (key, value) ->
            if (value.isJsonPrimitive) {
                // Create a CardView for each field
                val cardView = CardView(this).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        setMargins(0, 8, 0, 8)
                    }
                    radius = 12f
                    elevation = 4f
                    setCardBackgroundColor(0xFFFFFFFF.toInt())
                }

                // Create a TextView inside the CardView
                val textView = TextView(this).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        setPadding(16, 16, 16, 16)
                    }
                    text = "${key.capitalize()}: ${value.asString}"
                    textSize = 16f
                    setTextColor(0xFF4E342E.toInt())
                }

                // Add the TextView to the CardView
                cardView.addView(textView)
                
                // Add the CardView to the container
                detailsContainer.addView(cardView)
            }
        }

        // Manual back button
        val backBtn = findViewById<Button>(R.id.btnBackToDashboard)
        backBtn.setOnClickListener {
            finish() // Go back to Dashboard
        }
    }
}
