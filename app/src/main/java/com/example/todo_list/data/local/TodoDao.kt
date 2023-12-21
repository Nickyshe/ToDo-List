package com.example.todo_list.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.todo_list.domain.model.Todo
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertTodo(todo:Todo)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTodo(todo: Todo)
    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT *from Todo where id = :id")
    suspend fun getTodoById(id: Int): Todo?

    @Query("SELECT *from Todo")
    fun getALLTodos(): Flow<List<Todo>>

    //Data access objects (DAOs) that provide methods
// that your app can use to query, update, insert, and delete data in the database.
}