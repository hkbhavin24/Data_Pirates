package com.example.datapirates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datapirates.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding =ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}