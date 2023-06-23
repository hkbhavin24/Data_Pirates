package com.example.datapirates

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.datapirates.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.fragFrame, SignInFragment()).commit()

        binding.btnSignIn.setTextColor(Color.WHITE)
        binding.btnSignIn.setBackgroundColor(Color.BLACK)


        binding.btnSignIn.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragFrame, SignInFragment())
                .commit()
            (it as Button).setTextColor(Color.WHITE)
            (it as Button).setBackgroundColor(Color.BLACK)
            binding.btnSignUp.setBackgroundColor(Color.WHITE)
            binding.btnSignUp.setTextColor(Color.BLACK)

        }
        binding.btnSignUp.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragFrame, SignUpFragment())
                .commit()

            (it as Button).setTextColor(Color.WHITE)
            (it as Button).setBackgroundColor(Color.BLACK)
            binding.btnSignIn.setTextColor(Color.BLACK)
            binding.btnSignIn.setBackgroundColor(Color.WHITE)

        }
    }
}