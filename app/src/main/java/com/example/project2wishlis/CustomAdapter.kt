package com.example.project2wishlis

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter(var userData: List<UserData>) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.nameText.setText(userData[position].getName())
        holder.priceText.setText(userData[position].getPrice())
        holder.urlText.setText(userData[position].getUrl())
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameText: TextView
        var priceText: TextView
        var urlText: TextView

        init {
            nameText = itemView.findViewById<TextView>(R.id.nameText)
            priceText = itemView.findViewById<TextView>(R.id.priceText)
            urlText = itemView.findViewById<TextView>(R.id.urlText)
        }
    }
}