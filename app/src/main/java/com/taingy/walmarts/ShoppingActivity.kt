package com.taingy.walmarts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val tvWelcome = findViewById<TextView>(R.id.tv_welcome)
        val username = intent.getStringExtra("username")
        tvWelcome.text = "Welcome $username"

        val layoutElectronic = findViewById<LinearLayout>(R.id.layout_electronic)
        val layoutClothing = findViewById<LinearLayout>(R.id.layout_clothing)
        val layoutBeauty = findViewById<LinearLayout>(R.id.layout_beauty)
        val layoutFood = findViewById<LinearLayout>(R.id.layout_food)

        layoutElectronic.setOnClickListener {
            Toast.makeText(this, "You have chosen the Electronic category of shopping.", Toast.LENGTH_LONG).show()
        }
        layoutClothing.setOnClickListener {
            Toast.makeText(this, "You have chosen the Clothing category of shopping.", Toast.LENGTH_LONG).show()
        }
        layoutBeauty.setOnClickListener {
            Toast.makeText(this, "You have chosen the Beauty category of shopping.", Toast.LENGTH_LONG).show()
        }
        layoutFood.setOnClickListener {
            Toast.makeText(this, "You have chosen the Food category of shopping.", Toast.LENGTH_LONG).show()
        }
    }
}