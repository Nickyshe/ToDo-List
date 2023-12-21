package com.example.todo_list.domain.repository

import com.example.todo_list.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun insertTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
    suspend fun getAllTodoById(id: Int):Todo?
    suspend fun getAllTodos():Flow<List<Todo>>
}