package com.example.todo_list.data.repository

import com.example.todo_list.data.local.TodoDao
import com.example.todo_list.domain.model.Todo
import com.example.todo_list.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(private val dao: TodoDao):TodoRepository {
    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    override suspend fun updateTodo(todo: Todo) {
       dao.updateTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
     dao.deleteTodo(todo)
    }

    override suspend fun getAllTodoById(id: Int): Todo? {
    dao.getTodoById(id)
        return TODO("Provide the return value")
    }

    override suspend fun getAllTodos(): Flow<List<Todo>> {
      dao.getALLTodos()
        return TODO("Provide the return value")
    }
}