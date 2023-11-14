package com.taingy.walmarts

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.taingy.walmarts.databinding.ActivityMainBinding
import com.taingy.walmarts.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userList: List<User>
    init {
        userList = mutableListOf(
            User("Jame", "Ben", "jame@mail.com", "123456"),
            User("John", "Cina", "john@mail.com", "123456"),
            User("Jack", "Ma", "jack@mail.com", "123456"),
            User("Josh", "Sa", "josh@mail.com", "123456"),
            User("Jamie", "Miller", "jamie@mail.com", "123456")
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSignIn.setOnClickListener { performSignIn() }
        binding.btCreateAccount.setOnClickListener { gotoRegister() }
        binding.tvForgetPassword.setOnClickListener { onForgetPassword() }
    }

    private fun performSignIn() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val isUser = userList.count { user -> user.username == email && user.password == password }
        if (isUser >= 0) {
            val intent = Intent(this, ShoppingActivity::class.java)
            intent.putExtra("username", email)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Invalid username or password!", Toast.LENGTH_LONG).show()
        }
    }

    private fun gotoRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    private fun onForgetPassword() {
        val inputName = binding.etEmail.text.toString()
        val user = userList.first { user -> user.username == inputName }
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