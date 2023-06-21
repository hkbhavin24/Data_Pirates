package com.example.datapirates.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity(

    @ColumnInfo(name = "title") var task:String,
    @ColumnInfo(name = "description") var description:String,
    @ColumnInfo(name = "category") var category: String,
    @ColumnInfo(name = "date") var date:String,
    @ColumnInfo(name = "stime") var stime : String,
    @ColumnInfo(name = "etime") var etime:String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}