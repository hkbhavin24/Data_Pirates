package com.example.datapirates

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datapirates.Adapter.taskadepter
import com.example.datapirates.Database.RoomDB
import com.example.datapirates.Database.TaskDao
import com.example.datapirates.Database.TaskEntity
import com.example.datapirates.databinding.ActivityAddTaskBinding
import java.util.Calendar


class add_task : AppCompatActivity() {
    lateinit var db:RoomDB
    lateinit var taskAdapter: taskadepter
    lateinit var btnDatePicker: Button
    lateinit var btnTimePicker: Button
    lateinit var txtDate: EditText
    lateinit var txtTime: EditText
    var mYear: Int = 0
    var mMonth: Int = 0
    var mDay: Int = 0
    var mHour: Int = 0
    var mMinute: Int = 0
    lateinit var binding: ActivityAddTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        db = RoomDB.getInstance(this)

        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)


        btnDatePicker = findViewById(R.id.btn_date)
        btnTimePicker = findViewById(R.id.btn_time)
        txtDate = findViewById(R.id.in_date)
        txtTime = findViewById(R.id.in_time)

        btnDatePicker.setOnClickListener {
            onclick(it)
        }
        btnTimePicker.setOnClickListener {
            onclick(it)
        }
        binding.addtask.setOnClickListener {
            var data = TaskEntity(
                binding.title.text.toString(),
                binding.discription.text.toString(),
                binding.category.toString(),
                binding.inDate.toString(),
                binding.inTime.toString(),false
            )
            db.task().addTask(data)
            finish()
        }

    }

    fun onclick(v: View) {
        if (v === btnDatePicker) {
            val c: Calendar = Calendar.getInstance()
            mYear = c.get(Calendar.YEAR)
            mMonth = c.get(Calendar.MONTH)
            mDay = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth -> txtDate.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year) },
                mYear,
                mMonth,
                mDay
            )
            datePickerDialog.show()
        }
        if (v === btnTimePicker) {
            val c = Calendar.getInstance()
            mHour = c[Calendar.HOUR_OF_DAY]
            mMinute = c[Calendar.MINUTE]

            val timePickerDialog = TimePickerDialog(
                this,
                { view, hourOfDay, minute -> txtTime.setText("$hourOfDay:$minute") },
                mHour,
                mMinute,
                false
            )
            timePickerDialog.show()
        }
    }
}