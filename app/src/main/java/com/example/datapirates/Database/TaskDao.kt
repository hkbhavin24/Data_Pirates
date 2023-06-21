package com.example.datapirates.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert()
    fun addTask(data : TaskEntity)

    @Query("select * from task")
    fun getTask() : List<TaskEntity>
//
//    @Query("UPDATE food SET name=:name, price=:price, veg= :veg WHERE id=:id")
//    fun updateFood(name: String, price: Int, veg:Boolean, id:Int)

    @Delete
    fun deleteFood(data: TaskEntity)


}