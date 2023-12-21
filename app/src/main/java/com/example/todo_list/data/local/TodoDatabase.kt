package com.example.todo_list.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo_list.domain.model.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = true)

abstract class TodoDatabase : RoomDatabase(){
    abstract val todoDao:TodoDao

}

/*
* The database class that holds the database
*  and serves as the main access point
* for the underlying connection to your app's persisted data.*/