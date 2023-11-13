package com.taingy.walmarts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taingy.walmarts.model.Product

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val products = ArrayList<Product>()
        products.add(Product("iPad", "iPad Pro 11-inch", R.drawable.img_ipad, 400.0))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", R.drawable.img_mac, 2500.00))
        products.add(Product("Dell Inspiron", "13th Gen Intel® CoreTM i7", R.drawable.img_laptop, 1499.00))
        products.add(Product("Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", R.drawable.img_keyboard, 199.00))
        products.add(Product("MacBook M3 Max", "14-core CPU\n30-core GPU", R.drawable.img_mac_pro, 3499.00))

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val productAdapter = ProductAdapter(this, products, false)
        recyclerView.adapter = productAdapter

        val btViewCart = findViewById<Button>(R.id.bt_view_cart)
        btViewCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }


    companion object {
        val productsInCart = mutableListOf<Product>()
    }
}