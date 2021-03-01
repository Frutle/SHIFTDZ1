package com.example.cwaetheritywaether.view.RecyclerViewTown

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cwaetheritywaether.R
import com.example.cwaetheritywaether.model.Town

class TownAdapter(private val onClick: (Town) -> Unit) : RecyclerView.Adapter<TownAdapter.townHolder>() {

    var town: List<Town> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): townHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.town_item, parent, false)
        return townHolder(view,onClick)
    }

    override fun onBindViewHolder(holder: townHolder, position: Int) {
        val town = town[position]
        holder.bind(town)
    }

    override fun getItemCount(): Int {
        return town.count()
    }

    class townHolder(itemView: View,private val onClick: (Town) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val townName: TextView = itemView.findViewById(R.id.townName)
        private val townTemperature: TextView = itemView.findViewById(R.id.townTemperature)
        private val townBreeze : TextView = itemView.findViewById(R.id.townBreeze)
        private val townCloudCover : TextView = itemView.findViewById(R.id.townCloudCOver)

        fun bind(town: Town) {
            townName.text = itemView.context.getString(R.string.town_format, town.townName)
            townTemperature.text = (town.temperature ?: itemView.context.getString(R.string.temperature)).toString()
            townBreeze.text = itemView.context.getString(R.string.breeze_format, town.breeze)
            townCloudCover.text = itemView.context.getString(R.string.cloud_cover_format, town.cloudCover)

            itemView.setOnClickListener { onClick(town) }
        }
    }

}