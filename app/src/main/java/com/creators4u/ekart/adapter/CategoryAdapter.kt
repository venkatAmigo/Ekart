package com.creators4u.ekart.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.creators4u.ekart.R
import com.creators4u.ekart.adapter.CategoryAdapter.*
import com.creators4u.ekart.model.Products
import com.creators4u.ekart.view.ItemsActivity

class CategoryAdapter(val categories:List<String>,val products:Products): RecyclerView.Adapter<CategoryHolder>() {

    var context:Context?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        context=parent.context
        val view=LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return CategoryHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.name.text=categories[position]
        holder.cardView.setOnClickListener {
            val intent=Intent(context,ItemsActivity::class.java)

            //intent.putExtra("Data",products.types.mobiles)
        }

    }

    override fun getItemCount(): Int {
       return  categories.size
    }
    class CategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name=itemView.findViewById<TextView>(R.id.name)
        val cardView=itemView.findViewById<CardView>(R.id.category_card)

    }

}