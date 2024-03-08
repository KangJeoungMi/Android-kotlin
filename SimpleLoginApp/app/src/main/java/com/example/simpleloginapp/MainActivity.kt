package com.example.simpleloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var usernameInput : EditText
    private lateinit var password : EditText
    private lateinit var loginBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.usename_input)
        password = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = password.text.toString()
            Log.i("Test Credentials","Username : $username and password : $password")

        }
    }
}