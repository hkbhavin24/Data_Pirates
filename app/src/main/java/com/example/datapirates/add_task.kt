package com.example.datapirates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datapirates.databinding.ActivityAddTaskBinding

class add_task : AppCompatActivity() {
    lateinit var binding:ActivityAddTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}