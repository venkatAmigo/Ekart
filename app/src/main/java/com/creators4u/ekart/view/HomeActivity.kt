package com.creators4u.ekart.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.creators4u.ekart.R
import com.creators4u.ekart.adapter.CategoryAdapter
import com.creators4u.ekart.model.Products
import com.google.gson.Gson
import java.io.FileReader
import java.io.InputStream
import java.lang.Exception
import java.nio.charset.Charset

class HomeActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerView=findViewById(R.id.category_recycler)

        //Parsing Json using Json Library
        val gson= Gson()
        val products: Products =gson.fromJson(getJson("data.json"),Products::class.java)

        categoryAdapter= CategoryAdapter(products.categories,products)
        recyclerView.layoutManager= LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        recyclerView.adapter=categoryAdapter
    }
    private fun getJson(filename:String):String
    {
        try {
            val inputStream: InputStream = this.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            return String(buffer, Charset.defaultCharset())
        }
        catch(exception:Exception)
        {

        }
        return ""
    }

}