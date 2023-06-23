package com.example.datapirates.RoomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Insert
    fun addTask(data : TaskEntity)

    @Query("SELECT * FROM task")
    fun gettask() : List<TaskEntity>

    @Update
    fun updatetask(task : TaskEntity)

    @Delete
    fun deletetask(data: TaskEntity)

    @Query("DELETE FROM task")
    fun deleteAlltask()

}