package com.taingy.walmarts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taingy.walmarts.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setView()
    }

    private fun setView() {
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val price = intent.getDoubleExtra("price", 0.0)
        val img = intent.getIntExtra("image", 0)

        binding.tvTitle.text = name
        binding.tvDescription.text = description
        binding.tvPrice.text = "$$price"
        binding.ivImage.setImageDrawable(getDrawable(img))
    }
}