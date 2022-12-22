package com.example.to_doapp.di

import android.content.Context
import androidx.room.Room
import com.example.to_doapp.ui.data.TodoDao
import com.example.to_doapp.ui.data.TodoDatabase
import com.example.to_doapp.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TodoDatabase
    = Room.databaseBuilder(
        context,
        TodoDatabase::class.java,  // actual database class
        DATABASE_NAME // name of database
    ).build()


    @Singleton
    @Provides
    fun provideDao(database: TodoDatabase): TodoDao = database.todoDao()
}
