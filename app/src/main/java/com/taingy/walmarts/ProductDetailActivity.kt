package com.taingy.walmarts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.taingy.walmarts.model.Product

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val price = intent.getDoubleExtra("price", 0.0)
        val img = intent.getIntExtra("image", 0)

        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val tvDescription = findViewById<TextView>(R.id.tv_description)
        val tvPrice = findViewById<TextView>(R.id.tv_price)
        val ivImage = findViewById<ImageView>(R.id.iv_image)

        tvTitle.text = name
        tvDescription.text = description
        tvPrice.text = "$$price"
        ivImage.setImageDrawable(getDrawable(img))
    }
}