package com.taingy.walmarts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.taingy.walmarts.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")
        binding.tvWelcome.text = "Welcome $username"

        binding.layoutElectronic.setOnClickListener {
            startActivity(Intent(this, ProductListActivity::class.java))
        }
        binding.layoutClothing.setOnClickListener {
            Toast.makeText(this, "You have chosen the Clothing category of shopping.", Toast.LENGTH_LONG).show()
        }
        binding.layoutBeauty.setOnClickListener {
            Toast.makeText(this, "You have chosen the Beauty category of shopping.", Toast.LENGTH_LONG).show()
        }
        binding.layoutFood.setOnClickListener {
            Toast.makeText(this, "You have chosen the Food category of shopping.", Toast.LENGTH_LONG).show()
        }
    }
}