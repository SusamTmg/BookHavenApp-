package com.example.nit3213studentdashboardapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213studentdashboardapplication.databinding.ItemEntityBinding
import com.google.gson.JsonObject

class GenericEntityAdapter(
    private val entities: List<JsonObject>,
    private val onItemClick: (JsonObject) -> Unit
) : RecyclerView.Adapter<GenericEntityAdapter.EntityViewHolder>() {

    class EntityViewHolder(
        private val binding: ItemEntityBinding,
        private val onItemClick: (JsonObject) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: JsonObject) {
            // Find the first non-empty string field to use as the title
            val titleField = entity.entrySet().firstOrNull { 
                it.value.isJsonPrimitive && it.value.asJsonPrimitive.isString && it.value.asString.isNotEmpty()
            }
            
            binding.titleText.text = titleField?.value?.asString ?: "Untitled"
            
            // Find the second non-empty string field to use as the subtitle
            val subtitleField = entity.entrySet().filter { 
                it.value.isJsonPrimitive && it.value.asJsonPrimitive.isString && it.value.asString.isNotEmpty()
            }.getOrNull(1)
            
            binding.authorText.text = subtitleField?.value?.asString ?: ""
            
            itemView.setOnClickListener {
                onItemClick(entity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val binding = ItemEntityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EntityViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(entities[position])
    }

    override fun getItemCount() = entities.size
} 