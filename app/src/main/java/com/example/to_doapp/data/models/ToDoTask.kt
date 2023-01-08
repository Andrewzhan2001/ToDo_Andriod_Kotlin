package com.example.to_doapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.to_doapp.util.Constants.DATABASE_TABLE

// this notation come from room library
// telling room databse that this class is used to create table in database
@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    // each field in this class will be presented as a column in database

    // this column act as primary key
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,
    val description: String,
    val priority: Priority
)
