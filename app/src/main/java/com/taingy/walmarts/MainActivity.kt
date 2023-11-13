package com.taingy.walmarts

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.taingy.walmarts.model.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList = mutableListOf(
                User("Jame", "Ben", "jame@mail.com", "123456"),
                User("John", "Cina", "john@mail.com", "123456"),
                User("Jack", "Ma", "jack@mail.com", "123456"),
                User("Josh", "Sa", "josh@mail.com", "123456"),
                User("Jamie", "Miller", "jamie@mail.com", "123456")
        )

        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btSignIn = findViewById<Button>(R.id.bt_sign_in)
        val btCreateAccount = findViewById<Button>(R.id.bt_create)
        val tvForgetPassword = findViewById<TextView>(R.id.tv_forget_password)

        btSignIn.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val isUser = userList.count { user -> user.username == email && user.password == password }
            if (isUser == 0) {
                val intent = Intent(this, ShoppingActivity::class.java)
                intent.putExtra("username", email)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid username or password!", Toast.LENGTH_LONG).show()
            }
        }

        btCreateAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        tvForgetPassword.setOnClickListener {
            val user = userList.first { user -> user.username == etEmail.text.toString() }
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, user.password)
                type = "text/plain"
            }

            try {
                startActivity(sendIntent)
            } catch (e: ActivityNotFoundException) {

            }
        }
    }

}