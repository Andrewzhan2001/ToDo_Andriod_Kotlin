package com.example.to_doapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.to_doapp.data.models.TodoTask

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    // abstract function that returns the TodoDao.
    abstract fun todoDao(): TodoDao
}