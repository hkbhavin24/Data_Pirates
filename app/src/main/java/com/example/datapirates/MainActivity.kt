package com.example.datapirates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datapirates.Adapter.CategoryAdapter
import com.example.datapirates.Adapter.taskadepter
import com.example.datapirates.RoomDatabase.RoomDB
import com.example.datapirates.RoomDatabase.TaskDao
import com.example.datapirates.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {

        lateinit var binding: ActivityMainBinding
        lateinit var adapter: taskadepter
        lateinit var database: TaskDao
        lateinit var db : RoomDB


        fun Updated() {
            var list = database.gettask()
//            adapter.update(list)

        }

        fun setList() {
            var list = database.gettask()
            adapter = taskadepter(list)
            binding.rcvtask.adapter = adapter

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = RoomDB.getInstance(this)
        var list = db.task().gettask()

        binding.rcvtask.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rcvtask.adapter = taskadepter(list)



        binding.addtask.setOnClickListener {
            var intent = Intent(this,add_task::class.java)
            startActivity(intent)
        }
    }
}