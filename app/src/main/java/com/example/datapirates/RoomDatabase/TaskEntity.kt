package com.example.datapirates.RoomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity(
    @ColumnInfo(name = "title") var title:String,
    @ColumnInfo(name = "description") var description:String,
    @ColumnInfo(name = "category") var category: String,
    @ColumnInfo(name = "date") var date:String,
    @ColumnInfo(name = "stime") var edate: String,
    @ColumnInfo(name = "etime") var etime: Boolean
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}