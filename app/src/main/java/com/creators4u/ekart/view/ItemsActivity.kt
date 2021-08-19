package com.creators4u.ekart.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.creators4u.ekart.R
import com.creators4u.ekart.adapter.ItemsAdapter

class ItemsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        //val adapter=ItemsAdapter()
    }
}