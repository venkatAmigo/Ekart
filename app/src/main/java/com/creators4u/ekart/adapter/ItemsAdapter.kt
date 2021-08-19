package com.creators4u.ekart.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.creators4u.ekart.R

class ItemsAdapter(val categories:List<String>): RecyclerView.Adapter<ItemsAdapter.ItemsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return ItemsHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsHolder, position: Int) {
        holder.name.text=categories[position]

        }
    override fun getItemCount(): Int {
        return  categories.size
    }
    class ItemsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name=itemView.findViewById<TextView>(R.id.name)
        val price=itemView.findViewById<TextView>(R.id.name)
        val desc=itemView.findViewById<TextView>(R.id.name)
    }
    }

