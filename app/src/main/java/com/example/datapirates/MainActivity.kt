package com.example.datapirates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datapirates.Adapter.CategoryAdapter
import com.example.datapirates.Database.RoomDB
import com.example.datapirates.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var db : RoomDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = RoomDB.getInstance(this)
        var list = db.task().getTask()

        binding.rcvCategory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rcvCategory.adapter = CategoryAdapter(list)
    }
}