package com.example.nit3213studentdashboardapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213studentdashboardapplication.model.Entity

class EntityAdapter : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    private var entityList = listOf<Entity>()

    fun setData(list: List<Entity>) {
        entityList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            android.R.layout.simple_list_item_2,
            parent,
            false
        )
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entityList[position]
        holder.title.text = entity.title
        holder.subtitle.text = entity.author
    }

    override fun getItemCount(): Int = entityList.size

    class EntityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(android.R.id.text1)
        val subtitle: TextView = view.findViewById(android.R.id.text2)
    }
}
