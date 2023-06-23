package com.example.datapirates.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1)
abstract class RoomDB : RoomDatabase() {

    companion object{
        var DB_NAME = "task"
        fun getInstance(context: Context): RoomDB {

            var room = Room.databaseBuilder(context,RoomDB::class.java, DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
            return room
        }
    }
    abstract fun task(): TaskDao
}