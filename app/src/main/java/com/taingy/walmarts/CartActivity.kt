package com.taingy.walmarts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.taingy.walmarts.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getProductList()

    }

    private fun getProductList() {
        val products = ProductListActivity.productsInCart
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        val productAdapter = ProductAdapter(this, products, true)
        binding.recyclerView.adapter = productAdapter
    }
}